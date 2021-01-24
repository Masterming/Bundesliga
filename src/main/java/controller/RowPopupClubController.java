package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public RowPopupClubController(RowPopupClubView rPCV, Liga c, JTable tab) {
        this.rPCV = rPCV;
        this.l = c;
        this.rPCV.getBearbeiten().addActionListener(this);
        this.rPCV.getLoeschen().addActionListener(this);
        this.table = tab;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Loeschen");
        switch (evt.getActionCommand()) {
            case "loeschen":
                // Selected Value bekommen bzw. aendern
                int index1 = table.getSelectedRow();
                String name = table.getValueAt(index1, 0).toString();
                System.out.println(name);
                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
                if (name != null) {
                    // Pop Up menue mit text
                    int best = JOptionPane.showConfirmDialog(null,
                            "Wollen Sie den Club " + name + " wirklich loeschen?");
                    if (best == 0) {
                        System.out.println("True");
                        // TODO Name aus DB Loeschen
                        this.l.removeClub(name);

                        tbm.removeRow(index1);
                    } else {
                        System.out.println("false");
                    }
                }
                break;
            case "bearbeiten":
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                // ueber Kader View

                String name2 = table.getValueAt(row, 0).toString();
                // String stadion = table.getValueAt(row, 1).toString();
                DefaultTableModel tbm2 = (DefaultTableModel) table.getModel();
                if (name2 != null && column == 0) {
                    // Pop Up menue mit text

                    String nameNeu = JOptionPane.showInputDialog("Neuen Namen eingeben");
                    nameNeu = nameNeu.trim();
                    if (nameNeu != null) {
                        if (!"".equals(nameNeu)) {
                            tbm2.setValueAt(nameNeu, row, column);
                            this.l.changeClubName(nameNeu, name2);

                        }
                    }

                }
                // if (stadion != null && column == 1) {
                // String stadionNeu = JOptionPane.showInputDialog("Neuen Stadion eingeben
                // eingeben");
                // stadionNeu.trim();
                // if (!"".equals(stadionNeu)) {
                // tbm2.setValueAt(stadionNeu, row, column);
                // }
                // }
                break;
        }

    }

}
