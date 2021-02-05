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
import java.util.logging.*;

/**
 *
 * @author z003ywys
 */
public class RowPopupPlayerView extends JPopupMenu {

    private final static Logger LOGGER = Logger.getLogger(RowPopupPlayerView.class.getName());
    private static final long serialVersionUID = 18L;
    private JMenuItem loeschen;
    private JMenuItem bearbeiten;

    public RowPopupPlayerView(JTable table) {
        loeschen = new JMenuItem("Loeschen");
        // loeschen.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent arg0) {
        // // Selected Value bekommen bzw. aendern
        // int index1 = table.getSelectedRow();
        // String name = table.getValueAt(index1, 0).toString();
        // DefaultTableModel tbm = (DefaultTableModel) table.getModel();
        // if (name != null) {
        // // Pop Up menue mit text
        // int confirm = JOptionPane.showConfirmDialog(null,
        // "Wollen Sie den Spieler " + name + " wirklich loeschen?");
        // if (confirm == JOptionPane.YES_OPTION) {
        // LOGGER.log(Level.INFO, "Remove Spieler " + name);
        // tbm.removeRow(index1);
        // } else {
        // }
        // }
        // }
        //
        // });
        loeschen.setActionCommand("loeschen");
        add(loeschen);
        bearbeiten = new JMenuItem("Bearbeiten");
        // bearbeiten.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent arg0) {
        // // Selected Value bekommen bzw. aendern
        // int row = table.getSelectedRow();
        // int column = table.getSelectedColumn();
        // // ueber Kader View
        //
        // String name = table.getValueAt(row, 0).toString();
        // String goal = table.getValueAt(row, 1).toString();
        // DefaultTableModel tbm = (DefaultTableModel) table.getModel();
        // if (name != null && column == 0) {
        // // Pop Up menue mit text
        //
        // String nameNeu = JOptionPane.showInputDialog("Neuen Namen eingeben");
        // nameNeu = nameNeu.trim();
        // if (nameNeu != null) {
        // LOGGER.log(Level.INFO, "Rename Spieler" + name + " to " + nameNeu);
        // if (!"".equals(nameNeu)) {
        // tbm.setValueAt(nameNeu, row, column);
        // }
        // }
        //
        // }
        // if (goal != null && column == 1) {
        // String torAnzahl = JOptionPane.showInputDialog("Neue Toranzahl eingeben");
        // torAnzahl = torAnzahl.trim();
        //
        // if (torAnzahl != null) {
        // if (!"".equals(torAnzahl)) {
        // int goalInt;
        // boolean ok = true;
        // try {
        // goalInt = Integer.parseInt(torAnzahl);
        // if (goalInt < 0) {
        // JOptionPane.showMessageDialog(null,
        // "Bitte nur ganzzahlige Positive Werte eingeben");
        // ok = false;
        // }
        // } catch (Exception e) {
        // JOptionPane.showMessageDialog(null, "Bitte nur ganzzahlige Positive Werte
        // eingeben");
        // ok = false;
        // }
        // if (ok) {
        // tbm.setValueAt(torAnzahl, row, column);
        // }
        // }
        // }
        //
        // }
        //
        // }
        //
        // });
        bearbeiten.setActionCommand("bearbeiten");
        add(bearbeiten);

    }

    public JMenuItem getLoeschen() {
        return loeschen;
    }

    public JMenuItem getBearbeiten() {
        return bearbeiten;
    }

}
