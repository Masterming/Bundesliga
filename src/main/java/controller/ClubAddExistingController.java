/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.logging.*;

import model.Liga;
import view.ClubAddExistingView;

/**
 *
 * @author z003ywys
 */
public class ClubAddExistingController implements ActionListener, MouseListener, ItemListener {

    private final static Logger LOGGER = Logger.getLogger(ClubAddExistingController.class.getName());
    private ClubAddExistingView cAeV;
    private Liga l;
    private String selectedLiga;
    private String selectedClub;
    private DefaultListModel<String> clubList;

    public ClubAddExistingController(ClubAddExistingView cAeV, Liga l) {
        this.cAeV = cAeV;
        this.l = l;
        this.cAeV.getAdClubToLigaBtn().addActionListener(this);
        this.cAeV.getSelectedLiga().addItemListener(this);
        this.cAeV.getLigaClubList().addMouseListener(this);
        clubList = new DefaultListModel<>();
        this.cAeV.getLigaClubList().setModel(clubList);
        // Elemente fuer die Erste Liga hinzufuegen
        adaptViewToLiga();
    }

    private void adaptViewToLiga() {
        // TODO Club View Anpassen
        if (l.getId() == 1) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            this.cAeV.setLigaComboModel(dfC);
            // Club Liste Setzen
            this.clubList.addElement("FC Erzgebirge Aue");
        }
        if (l.getId() == 2) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            this.cAeV.setLigaComboModel(dfC);
            // Club Liste Setzen -->
            this.clubList.addElement("FC Bayern Muenchen");
            this.clubList.addElement("RB Leipzig");
        }
        if (l.getId() == 3) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            this.cAeV.setLigaComboModel(dfC);
            // Club Liste Setzen
            this.clubList.addElement("Ingolstadt");
        }
        this.cAeV.repaint();
        this.cAeV.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "clubAddLiga":

                int best = JOptionPane.showConfirmDialog(this.cAeV, "Wollen Sie den Club zur Liga hinzufuegen ?");
                if (best == 0) {
                    LOGGER.log(Level.INFO, "CLub: " + this.selectedClub + " zur Liga hinzugefuegt");
                    // TODO Transfer

                    JOptionPane.showMessageDialog(this.cAeV, "Transfer war erfolgreich");
                }
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // 1. Liga auswahl
        if (evt.getClickCount() == 1) {
            selectedLiga = this.cAeV.getSelectedLiga().getSelectedItem().toString();
            try {
                selectedClub = this.cAeV.getLigaClubList().getSelectedValue().toString();
                if (selectedClub != null) {
                    this.cAeV.getToAddClubLbl().setText(selectedClub);
                } else {
                    this.cAeV.getToAddClubLbl().setText("");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
                this.cAeV.getToAddClubLbl().setText("");
            }

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

    @Override
    public void itemStateChanged(ItemEvent evt) {
        String ligStr = this.cAeV.getSelectedLiga().getSelectedItem().toString();
        this.clubList.removeAllElements();
        if (ligStr.contains("1")) {
            // TODO Clubs Aufzaehlen aus der Liga
            this.clubList.addElement("FC Bayern Muenchen");
            this.clubList.addElement("RB Leipzig");

        }
        if (ligStr.contains("2")) {
            // TODO Clubs Aufzaehlen aus der Liga
            this.clubList.addElement("FC Erzgebirge Aue");
        }
        if (ligStr.contains("3")) {
            // TODO Clubs Aufzaehlen aus der Liga
            this.clubList.addElement("Ingolstadt");
        }
    }

}
