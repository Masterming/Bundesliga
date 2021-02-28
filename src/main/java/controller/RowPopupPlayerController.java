package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Club;
import model.Liga;
import view.RowPopupPlayerView;

/**
 * @author z003ywys
 */
public class RowPopupPlayerController implements ActionListener {

    private RowPopupPlayerView view;
    private JFrame master;
    private Liga liga;
    private Club club;
    private JTable table;

    private final static Logger LOGGER = Logger.getLogger(RowPopupPlayerController.class.getName());

    public RowPopupPlayerController(RowPopupPlayerView view, Club club, JTable table, JFrame master, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.club = club;
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
        String goals = table.getValueAt(row, 1).toString();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        switch (evt.getActionCommand()) {
            case "loeschen":
                int confirm = JOptionPane.showConfirmDialog(master,
                        "Wollen Sie den Spieler " + name + " wirklich loeschen?", "Spieler Loeschen",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    LOGGER.log(Level.INFO, "Remove Player {0}", name);
                    club.removePlayer(name);
                    liga.updateClub(club);
                    dtm.removeRow(row);
                }
                break;

            case "bearbeiten":
                switch (table.getSelectedColumn()) {
                    case 0:
                        String newName = JOptionPane.showInputDialog(master, "Neuen Namen eingeben", name);
                        if (newName != null && !newName.isBlank()) {
                            LOGGER.log(Level.INFO, "Rename Club {0} to {1}", new Object[]{name, newName.trim()});
                            club.changePlayerName(name, newName);
                            liga.updateClub(club);
                            dtm.setValueAt(newName, row, 0);
                        }
                        break;
                    case 1:
                        String newGoals = JOptionPane.showInputDialog(master, "Neuen Toranzahl eingeben", goals);
                        int goalsN;
                        try {
                            goalsN = Integer.parseInt(newGoals);
                            club.changePlayerGoals(name, goalsN);
                            liga.updateClub(club);
                            dtm.setValueAt(newGoals, row, 1);
                        } catch (NumberFormatException n) {
                        }
                }
                break;

        }
        table.repaint();
        table.revalidate();
    }
}
