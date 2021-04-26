package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import model.Club;
import model.Liga;
import view.TableView;

/**
 * @author z003ywys
 */
public class TablePresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(TablePresenter.class.getName());
    private TableView view;
    private Liga liga;

    public TablePresenter(TableView view, Liga liga) {
        this.view = view;
        this.liga = liga;
        // this.view.setjLabel1(liga.getName());
        // this.view.getjButton1().addActionListener(this);
        this.setTableData();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
        case "test":
            LOGGER.log(Level.INFO, "Table Controller Button/ Aktion erfolgreich");
            LOGGER.log(Level.INFO, "Gezeigte Liga: {0}", liga.getName());
            break;
        }
    }

    private void setTableData() {
        // Neues TableModel erstellen je nach Liga
        // Aufrufen der SetTableContentMethode der Tabelle
        DefaultTableModel tbm = (DefaultTableModel) view.getjTable1().getModel();

        // Bekomme list mit CLub Objkete mit Daten
        // Sample Data
        String[][] data = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        view.setTableContent(tbm);
    }

    private String[][] getData() {
        // sort clubs in order of rank
        Collections.sort(liga.getClubs());
        Collections.reverse(liga.getClubs());

        String[][] data = new String[liga.getClubs().size()][];
        Integer rank = 1;
        int count = 0;

        for (Club c : liga.getClubs()) {
            String[] temp = new String[8];
            temp[0] = rank.toString();
            temp[1] = c.getName();
            temp[2] = String.valueOf(c.getGamesCount());
            temp[3] = String.valueOf(c.getPoints());
            temp[4] = String.valueOf(c.getWins());
            temp[5] = String.valueOf(c.getDraw());
            temp[6] = String.valueOf(c.getLosses());
            int gcd = gcd(c.getMadeGoals(), c.getReceivedGoals());
            if (gcd == 0 || c.getMadeGoals() == 0 || c.getReceivedGoals() == 0) {
                temp[7] = String.valueOf(c.getMadeGoals()) + " : " + String.valueOf(c.getReceivedGoals());
            } else {
                temp[7] = String.valueOf(c.getMadeGoals() / gcd) + " : " + String.valueOf(c.getReceivedGoals() / gcd);
            }
            data[count] = temp;
            rank++;
            count++;
        }
        return data;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
