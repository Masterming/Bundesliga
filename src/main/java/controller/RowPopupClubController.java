package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Liga;
import view.RowPopupClubView;

/**
 *
 * @author z003ywys
 */
public class RowPopupClubController implements ActionListener {

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
        int row;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();

        switch (evt.getActionCommand()) {
            case "loeschen":
                System.out.println("Loeschen");
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();

                if (name != null) {
                    int confirm = JOptionPane.showConfirmDialog(master,
                            "Wollen Sie den Club " + name + " wirklich loeschen?", "Loeschen", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        System.out.println("True");
                        l.removeClub(name);
                    } else {
                        System.out.println("false");
                    }
                }
                break;
            case "bearbeiten":
                System.out.println("Bearbeiten");
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();

                if (name != null) {
                    String newName = JOptionPane.showInputDialog(master, "Neuen Namen eingeben", name);
                    if (newName != null) {
                        newName = newName.trim();
                        if (!newName.isEmpty()) {
                            l.changeClubName(name, newName);
                        }
                    }
                }
                break;
        }
    }
}
