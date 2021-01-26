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
public class RowPopupClubView extends JPopupMenu {

    /**
     *
     */
    private JMenuItem loeschen;
    private JMenuItem bearbeiten;
    private static final long serialVersionUID = 108L;

    public RowPopupClubView() {
        loeschen = new JMenuItem("Loeschen");
        loeschen.setActionCommand("loeschen");
//        loeschen.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                LOGGER.log("Loeschen");
//                // Selected Value bekommen bzw. aendern
//                int index1 = table.getSelectedRow();
//                String name = table.getValueAt(index1, 0).toString();
//                LOGGER.log(name);
//                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
//                if (name != null) {
//                    // Pop Up menue mit text
//                    int best = JOptionPane.showConfirmDialog(null,
//                            "Wollen Sie den Club " + name + " wirklich loeschen?");
//                    if (best == 0) {
//                        // TODO Name aus DB Loeschen
//                        
//                        
//                        
//                        tbm.removeRow(index1);
//                    } else {
//                    }
//                }
//            }
//
//        });
        add(loeschen);
        bearbeiten = new JMenuItem("Bearbeiten");
        bearbeiten.setActionCommand("bearbeiten");
//        bearbeiten.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                int row = table.getSelectedRow();
//                int column = table.getSelectedColumn();
//                // ueber Kader View
//
//                String name = table.getValueAt(row, 0).toString();
//                String stadion = table.getValueAt(row, 1).toString();
//                DefaultTableModel tbm = (DefaultTableModel) table.getModel();
//                if (name != null && column == 0) {
//                    // Pop Up menue mit text
//
//                    String nameNeu = JOptionPane.showInputDialog("Neuen Namen eingeben");
//                    nameNeu = nameNeu.trim();
//                    if (nameNeu != null) {
//                        if (!"".equals(nameNeu)) {
//                            tbm.setValueAt(nameNeu, row, column);
//                        }
//                    }
//
//                }
//                if (stadion != null && column == 1) {
//                    String stadionNeu = JOptionPane.showInputDialog("Neuen Stadion eingeben eingeben");
//                    stadionNeu.trim();
//                    if (!"".equals(stadionNeu)) {
//                        tbm.setValueAt(stadionNeu, row, column);
//                    }
//                }
//
//            }
//        });
        add(bearbeiten);

    }

    public JMenuItem getLoeschen() {
        return loeschen;
    }

    public JMenuItem getBearbeiten() {
        return bearbeiten;
    }
    

}
