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
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;
import javax.swing.JFrame;
import model.Club;
import model.Liga;
import model.Player;

import view.KaderView;
import view.RowPopupPlayerView;

/**
 *
 * @author z003ywys
 */
public class KaderController implements ActionListener, MouseListener {

    private final static Logger LOGGER = Logger.getLogger(KaderController.class.getName());
    private KaderView kdV;
    private Club team;
    private JFrame master;
    private Liga li;

    public KaderController(KaderView kdV, Club team, JFrame mas, Liga l) {
        this.kdV = kdV;
        this.team = team;
        // Tabelle mit Rechtsklick -> Namen aendern und Spieler Loeschen
        this.kdV.getPlayerTable().addMouseListener(this);
        this.master=mas;
        this.li = l;
        this.setTableData();
    }

    private void setTableData() {
        DefaultTableModel tbm = (DefaultTableModel) kdV.getPlayerTable().getModel();
        String[][] data = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        kdV.setPlayerTableContent(tbm);
    }

    private String[][] getData() {
        // TODO daten holen
        String[][] data = new String[team.getPlayers().size()][];
         int count = 0;

        for (Player p : team.getPlayers()) {
            String[] temp = new String[2];
            temp[0] = p.getName();
            temp[1] = String.valueOf(p.getGoals());
            data[count] = temp;
            count++;
        }
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
            LOGGER.log(Level.INFO, "kontext Menue");
            LOGGER.log(Level.INFO, "Rechts klick");
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item
            
            RowPopupPlayerView kontext = new RowPopupPlayerView(kdV.getPlayerTable());
            RowPopupPlayerController rPoPPlC = new RowPopupPlayerController(kontext,this.team,this.kdV.getPlayerTable(),master,this.li);
            kontext.show(kdV.getPlayerTable(), evt.getX(), evt.getY());
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
