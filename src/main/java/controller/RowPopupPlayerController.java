/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Club;
import model.Liga;
import static org.hibernate.bytecode.BytecodeLogger.LOGGER;
import view.RowPopupPlayerView;

/**
 *
 * @author z003ywys
 */
public class RowPopupPlayerController implements ActionListener {
    private RowPopupPlayerView rPoPV;
    private Club cl;
    private JTable table;
    private JFrame master;
    private Liga liga;

    public RowPopupPlayerController(RowPopupPlayerView rPoPV, Club cl, JTable table, JFrame master, Liga l) {
        this.rPoPV = rPoPV;
        this.cl = cl;
        this.table = table;
        this.master = master;
        this.liga=l;
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent evt) {
        String name;
        int row;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        switch (evt.getActionCommand()){
            case "loeschen":
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();

                if (name != null) {
                    int confirm = JOptionPane.showConfirmDialog(master,
                            "Wollen Sie den Spieler " + name + " wirklich loeschen?", "Loeschen",
                            JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        //LOGGER.log(Level.INFO, "Remove Club " + name);
                        //cl.removePlayer(p);
                    }
                }
                break;
            case "bearbeiten":
                row = table.getSelectedRow();
                name = table.getValueAt(row, 0).toString();

                if (name != null) {
                    String newName = JOptionPane.showInputDialog(master, "Neuen Namen eingeben", name);
                    if (newName != null) {
                        newName = newName.trim();
                        if (!newName.isEmpty()) {
                            //LOGGER.log(Level.INFO, "Rename Club " + name + " to " + newName);
                            //cl.
                        }
                    }
                }
                break;
        }
    }
    
}
