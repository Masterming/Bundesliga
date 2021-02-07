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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.logging.*;
import model.Club;

import model.Liga;
import model.LigaDBMapper;
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
    private LigaDBMapper lDBM;
    private List <Liga> allLigas ;
    private int ligaRemID;

    public ClubAddExistingController(ClubAddExistingView cAeV, Liga l) {
        this.cAeV = cAeV;
        this.l = l;
        this.cAeV.getAdClubToLigaBtn().addActionListener(this);
        this.cAeV.getSelectedLiga().addItemListener(this);
        this.cAeV.getLigaClubList().addMouseListener(this);
        clubList = new DefaultListModel<>();
        this.cAeV.getLigaClubList().setModel(clubList);
        // Elemente fuer die Erste Liga hinzufuegen
        lDBM = new LigaDBMapper();
        this.allLigas=lDBM.getLigas();
        adaptViewToLiga();
        
    }

    private void adaptViewToLiga() {
        // TODO Club View Anpassen
        if (l.getId() == 1) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            cAeV.setLigaComboModel(dfC);
            populateComboBox();
           
        }
        if (l.getId() == 2) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            cAeV.setLigaComboModel(dfC);
            populateComboBox();
        }
        if (l.getId() == 3) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            cAeV.setLigaComboModel(dfC);
            populateComboBox();
        }
        
        
        cAeV.repaint();
        cAeV.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "clubAddLiga":

                int confirm = JOptionPane.showConfirmDialog(cAeV, "Wollen Sie den Club zur Liga hinzufuegen ?",
                        "Club Hinzufuegen", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    LOGGER.log(Level.INFO, "CLub: " + selectedClub + " zur Liga hinzugefuegt");
                    // TODO Transfer
                    if (selectedClub != null){
                        //l.removeClub(selectedClub);
                        //l.addClub(c)
                       Club remClub = allLigas.get(this.ligaRemID).removeClub(selectedClub);
                       l.addClub(remClub);
                       lDBM.updateLiga(l);
                       lDBM.updateLiga(allLigas.get(this.ligaRemID));
                       MainController.reloadFromDB();
                       JOptionPane.showMessageDialog(cAeV, "Transfer war erfolgreich");
                    }
                }
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // 1. Liga auswahl
        if (evt.getClickCount() == 1) {
            selectedLiga = cAeV.getSelectedLiga().getSelectedItem().toString();
            try {
                selectedClub = cAeV.getLigaClubList().getSelectedValue().toString();
                if (selectedClub != null) {
                    cAeV.getToAddClubLbl().setText(selectedClub);
                    
                    
                    
                    
                } else {
                    cAeV.getToAddClubLbl().setText("");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
                cAeV.getToAddClubLbl().setText("");
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
        populateComboBox();
    }
    
    private void populateComboBox(){
        String ligStr = cAeV.getSelectedLiga().getSelectedItem().toString();
        clubList.removeAllElements();
        if (ligStr.contains("1")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for(Club c : allLigas.get(0).getClubs()){
                 clubList.addElement(c.getName());
            }
            this.ligaRemID=0;

        }
        if (ligStr.contains("2")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for(Club c : allLigas.get(1).getClubs()){
                 clubList.addElement(c.getName());
            }
            this.ligaRemID=1;
            
        }
        if (ligStr.contains("3")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for(Club c : allLigas.get(2).getClubs()){
                 clubList.addElement(c.getName());
            }
            this.ligaRemID=2;
        }
    }

}
