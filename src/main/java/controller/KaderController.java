/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import view.KaderView;
import view.RowPopupPlayerView;

/**
 *
 * @author z003ywys
 */
public class KaderController implements ActionListener, MouseListener {
    private KaderView kdV;
    private String team;

    public KaderController(KaderView kdV, String team) {
        this.kdV = kdV;
        this.team = team;
        // Tabelle mit Rechtsklick -> Namen aendern und Spieler Loeschen
        this.kdV.getPlayerTable().addMouseListener(this);
        this.setTableData();
    }

    private void setTableData() {
        DefaultTableModel tbm = (DefaultTableModel) this.kdV.getPlayerTable().getModel();
        String[][] data = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        this.kdV.setPlayerTableContent(tbm);
    }

    private String[][] getData() {
        // TODO daten holen
        String[][] data = new String[0][];
        data = new String[2][];
        String temp[] = new String[2];
        temp[0] = "Thomas Mueller";
        temp[1] = "1123";
        data[0] = temp;

        temp = new String[2];
        temp[0] = "Max Mustermann";
        temp[1] = "900";
        data[1] = temp;
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.

        if (SwingUtilities.isRightMouseButton(evt)) {
            System.out.println("kontext Menue");
            System.out.println("Rechts klick");
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item
            RowPopupPlayerView kontext = new RowPopupPlayerView(this.kdV.getPlayerTable());
            kontext.show(this.kdV.getPlayerTable(), evt.getX(), evt.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
