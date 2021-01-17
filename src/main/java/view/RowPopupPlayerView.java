/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author z003ywys
 */
public class RowPopupPlayerView extends JPopupMenu {

    /**
     *
     */
    private static final long serialVersionUID = 109L;

    public RowPopupPlayerView(JTable table) {
        JMenuItem loeschen = new JMenuItem("Löschen");
        loeschen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Löschen");
                // Selected Value bekommen bzw. Ändern
                int index1 = table.getSelectedRow();
                String name = table.getValueAt(index1, 0).toString();
                System.out.println(name);
                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
                if (name != null) {
                    // Pop Up menü mit text
                    int best = JOptionPane.showConfirmDialog(null,
                            "Wollen Sie den Spieler " + name + " wirklich löschen?");
                    if (best == 0) {
                        System.out.println("True");
                        // TO DO Name aus DB Löschen
                        tbm.removeRow(index1);
                    } else {
                        System.out.println("false");
                    }
                }
            }

        });
        add(loeschen);
        JMenuItem bearbeiten = new JMenuItem("Bearbeiten");
        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Bearbeiten");
                // Selected Value bekommen bzw. Ändern
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                // Über Kader View

                String name = table.getValueAt(row, 0).toString();
                String goal = table.getValueAt(row, 1).toString();
                System.out.println(name);
                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
                if (name != null && column == 0) {
                    // Pop Up menü mit text

                    String nameNeu = JOptionPane.showInputDialog("Neuen Namen eingeben");
                    nameNeu = nameNeu.trim();
                    if (nameNeu != null) {
                        if (!"".equals(nameNeu)) {
                            tbm.setValueAt(nameNeu, row, column);
                        }
                    }

                }
                if (goal != null && column == 1) {
                    String torAnzahl = JOptionPane.showInputDialog("Neue Toranzahl eingeben");
                    torAnzahl = torAnzahl.trim();

                    if (torAnzahl != null) {
                        if (!"".equals(torAnzahl)) {
                            int goalInt;
                            boolean ok = true;
                            try {
                                goalInt = Integer.parseInt(torAnzahl);
                                if (goalInt < 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "Bitte nur ganzzahlige Positive Werte eingeben");
                                    ok = false;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Bitte nur ganzzahlige Positive Werte eingeben");
                                ok = false;
                            }
                            if (ok) {
                                tbm.setValueAt(torAnzahl, row, column);
                            }
                        }
                    }

                }

            }

        });
        add(bearbeiten);

    }
}
