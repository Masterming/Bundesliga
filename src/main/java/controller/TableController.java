package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;

import model.Club;
import model.Liga;
import view.TableView;

/**
 *
 * @author z003ywys
 */
public class TableController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(TableController.class.getName());

    private TableView view;
    private Liga liga;

    public TableController(TableView view, Liga liga) {
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
        // TODO Daten Holen
        String[][] data = new String[liga.getClubs().size()][];
        int count = 0;

        for (Club c : liga.getClubs()) {
            String[] temp = new String[8];
            temp[0] = "1";
            temp[1] = c.getName();
            temp[2] = String.valueOf(c.getGamesCount());
            temp[3] = String.valueOf(c.getPoints());
            temp[4] = String.valueOf(c.getWins());
            temp[5] = String.valueOf(c.getDraw());
            temp[6] = String.valueOf(c.getLosses());
            temp[7] = String.valueOf(c.getMadeGoals()) + " : " + String.valueOf(c.getReceivedGoals());
            data[count] = temp;
            count++;
        }
        return data;
    }

}
