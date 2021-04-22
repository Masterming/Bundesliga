package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Club;

import model.Liga;
import view.RowPopupClubView;

/**
 * @author z003ywys
 */
public class RowPopupClubPresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(RowPopupClubPresenter.class.getName());

    private RowPopupClubView view;
    private Liga liga;
    private JTable table;
    private JFrame master;
    private Map<Integer, Liga>ligas;

    public RowPopupClubPresenter(JFrame master, RowPopupClubView view, Liga liga, JTable table) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.table = table;
        this.ligas = MainPresenter.getLigas();
        this.view.getBearbeiten().addActionListener(this);
        this.view.getLoeschen().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        int row = table.getSelectedRow();
        if (row == -1) {
            return;
        }
        String name = table.getValueAt(row, 0).toString();
        String stadion = table.getValueAt(row, 1).toString();

        switch (evt.getActionCommand()) {
            case "loeschen":
                int confirm = JOptionPane.showConfirmDialog(master,
                        "Wollen Sie den Club " + name + " wirklich loeschen?", "Club Loeschen",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    LOGGER.log(Level.INFO, "Remove Club {0}", name);
                    liga.removeClub(name);
                }
                break;

            case "bearbeiten":
                switch (table.getSelectedColumn()) {
                    case 0:
                        String newName = JOptionPane.showInputDialog(master, "Neuen Namen eingeben", name);
                         newName = newName.trim();
                        if (!newName.isBlank()){
                            LOGGER.log(Level.INFO, "Rename Club {0} to {1}", new String[]{name, newName.trim()});
                            boolean clubExists = false;
                            for (Liga l : ligas.values()) {
                                for (Club c : l.getClubs()) {
                                    if (c.getName().equals(newName)) {
                                        clubExists = true;
                                        JOptionPane.showMessageDialog(master, "Club existiert bereits in der " + l.getName());
                                        break;
                                    }
                                }
                            }
                            if(!clubExists){
                                liga.changeClubName(name, newName);
                                JOptionPane.showMessageDialog(master, "Club Name wurde erfolgreich geändert");
                            }
                            
                        }
                        break;
                    case 1:
                        String stadionName = JOptionPane.showInputDialog(master, "Neuen Stadionname eingeben", stadion)
                                .trim();
                        if (!stadionName.isEmpty()) {
                            LOGGER.log(Level.INFO, "Change stadion to {0}", stadionName);
                            liga.changeClubStadion(name, stadionName);
                            JOptionPane.showMessageDialog(master, "Stadion Name wurde erfolgreich geändert");
                        }
                        break;

                }
                break;
        }
    }
}
