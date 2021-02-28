package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Liga;
import view.RowPopupClubView;

/**
 * @author z003ywys
 */
public class RowPopupClubController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(RowPopupClubController.class.getName());

    private RowPopupClubView view;
    private Liga liga;
    private JTable table;
    private JFrame master;

    public RowPopupClubController(JFrame master, RowPopupClubView view, Liga liga, JTable table) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.table = table;
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
                        if (newName != null && !newName.isBlank()) {
                            LOGGER.log(Level.INFO, "Rename Club {0} to {1}", new String[]{name, newName.trim()});
                            liga.changeClubName(name, newName);
                        }
                        break;
                    case 1:
                        String stadionName = JOptionPane.showInputDialog(master, "Neuen Stadionname eingeben", stadion).trim();
                        if (!stadionName.isEmpty()) {
                            LOGGER.log(Level.INFO, "Change stadion to {0}", stadionName);
                            liga.changeClubStadion(name, stadionName);
                        }
                        break;

                }
                break;
        }
    }
}
