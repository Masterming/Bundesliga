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
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.logging.*;

import view.TransactionView;

/**
 *
 * @author z003ywys
 */
public class TransactionController implements ActionListener, MouseListener {

    private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getName());
    private TransactionView trV;
    private String selectedTeam;
    private DefaultListModel<String> listModelUrsprung;
    private DefaultListModel<String> listModelSend;

    public TransactionController(TransactionView trV) {
        this.trV = trV;
        this.trV.getAddToTransBtn().addActionListener(this);
        this.trV.getRemoveFromTransBtn().addActionListener(this);
        this.trV.getSuchenBtn().addActionListener(this);
        this.trV.getTransFinishBtn().addActionListener(this);
        this.trV.getErgListTeam().addMouseListener(this);
        listModelUrsprung = new DefaultListModel<>();
        this.trV.getListEigenerKader().setModel(listModelUrsprung);
        listModelSend = new DefaultListModel<>();
        this.trV.getListeTransKader().setModel(listModelSend);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        switch (command) {
            case "suchen":
                LOGGER.log(Level.INFO, "suchen");
                suchen();
                break;
            case "trans_finish":
                LOGGER.log(Level.INFO, "trans_finish");
                transFinish();
                break;
            case "add":
                LOGGER.log(Level.INFO, "add");
                add();
                break;
            case "rem":
                LOGGER.log(Level.INFO, "rem");
                remove();
                break;
        }
    }

    private void suchen() {
        trV.getErgListTeam().removeAll();
        String suchAnfrage = trV.getReceivingTeamInput().getText();
        // Such ergebnisse als Liste o.ae. engezigt bekommen
        DefaultListModel<String> listModel = new DefaultListModel<>();
        trV.getErgListTeam().setModel(listModel);
        listModel.addElement(suchAnfrage);

        trV.repaint();
        trV.revalidate();
    }

    private void add() {
        String eigenerK = trV.getListEigenerKader().getSelectedValue();

        listModelUrsprung.removeElement(eigenerK);

        listModelSend.addElement(eigenerK);

        trV.repaint();
        trV.revalidate();

    }

    private void remove() {
        String eigenerK = trV.getListeTransKader().getSelectedValue();

        listModelSend.removeElement(eigenerK);

        listModelUrsprung.addElement(eigenerK);

        trV.repaint();
        trV.revalidate();
    }

    private void transFinish() {
        int best = JOptionPane.showConfirmDialog(null, "Wollen Sie die Transaktion abschliessen");
        boolean nullIncluded = false;
        if (best == 0) {
            List<String> transferPlayer = new ArrayList<>();
            for (int i = 0; i < listModelSend.getSize(); i++) {
                if (listModelSend.getElementAt(i) != null) {
                    transferPlayer.add(listModelSend.getElementAt(i).toString());
                } else {
                    nullIncluded = true;
                }
            }
            // Transaktion mit den Spielern passieren
            if (nullIncluded == false && transferPlayer.size() > 0) {
                // Transaktion durchfuehren
                LOGGER.log(Level.INFO, "trans Finish");
                for (String st : transferPlayer) {
                    if (st != null) {
                        LOGGER.log(Level.INFO, "uebertragende Objekte " + st);
                    }
                }
                JOptionPane.showMessageDialog(trV, "Transfer War erfolgreich");

            } else {
                LOGGER.log(Level.WARNING, "Bitte Waehlen Sie die zu uebertragenden Teams aus");
                JOptionPane.showMessageDialog(trV, "Bitte Waehlen Sie die zu uebertragenden Teams aus");
            }

        } else {
        }

    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            LOGGER.log(Level.INFO, "Item in Liste geklickt");
            selectedTeam = trV.getErgListTeam().getSelectedValue();
            trV.setReceiveTeamLbl(selectedTeam);
            listModelUrsprung.removeAllElements();
            listModelSend.removeAllElements();

            // Eigenen Kader Anpassen
            listModelUrsprung.addElement("Item 1");
            listModelUrsprung.addElement("Item 2");

        }

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
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
