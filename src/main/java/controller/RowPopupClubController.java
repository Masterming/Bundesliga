package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;

import model.Liga;
import view.RowPopupClubView;

/**
 *
 * @author z003ywys
 */
public class RowPopupClubController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(RowPopupClubController.class.getName());

    private RowPopupClubView rPCV;
    private Liga l;
    private JTable table;
    private JFrame master;

    public RowPopupClubController(JFrame master, RowPopupClubView rPCV, Liga c, JTable tab) {
        this.master = master;
        this.rPCV = rPCV;
        this.l = c;
        this.rPCV.getBearbeiten().addActionListener(this);
        this.rPCV.getLoeschen().addActionListener(this);
        this.table = tab;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String name;
        String stadion;
        int row;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        switch (evt.getActionCommand()) {
            case "loeschen":
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();

                if (name != null) {
                    int confirm = JOptionPane.showConfirmDialog(master,
                            "Wollen Sie den Club " + name + " wirklich loeschen?", "Club Loeschen",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        LOGGER.log(Level.INFO, "Remove Club " + name);
                        l.removeClub(name);
                    }
                }
                break;
            case "bearbeiten":
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();
                stadion = table.getValueAt(row, 1).toString();
                if (name != null && table.getSelectedColumn() == 0) {
                    String newName = JOptionPane.showInputDialog(master, "Neuen Namen eingeben", name);
                    if (newName != null) {
                        newName = newName.trim();
                        if (!newName.isEmpty()) {
                            LOGGER.log(Level.INFO, "Rename Club " + name + " to " + newName);
                            l.changeClubName(name, newName);
                        }
                    }
                }
                if (stadion != null && table.getSelectedColumn() == 1) {
                    String stadionName = JOptionPane.showInputDialog(master, "Neuen Stadionname eingeben", stadion);
                    if (stadionName != null) {
                        stadionName = stadionName.trim();
                        if (!stadionName.isEmpty()) {
                            LOGGER.log(Level.INFO, "Change stadion to " + stadionName);
                            l.changeClubStadion(name, stadionName);
                        }
                    }
                }
                break;
        }
    }
}
