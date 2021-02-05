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
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.logging.*;
import model.Club;
import model.ClubDBMapper;
import model.Player;

import view.TransactionView;

/**
 *
 * @author z003ywys
 */
public class TransactionController implements ActionListener, MouseListener {

    private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getName());
    private TransactionView trV;
    private Club club;
    private String selectedTeam;
    private DefaultListModel<String> listModelUrsprung;
    private DefaultListModel<String> listModelSend;
    private ClubDBMapper dao = new ClubDBMapper();
    private List<Club> clubs;

    public TransactionController(TransactionView trV, Club club) {
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
        this.club = club;
        clubs = dao.getAllClubs();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        switch (command) {
            case "suchen":
                suchen();
                break;
            case "trans_finish":
                transFinish();
                break;
            case "add":
                add();
                break;
            case "rem":
                remove();
                break;
        }
    }

    private void suchen() {
        trV.getErgListTeam().removeAll();
        String searchTerm = trV.getReceivingTeamInput().getText();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Club c : clubs) {
            if ((searchTerm.equals("Erhaltendes Team") || c.getName().toLowerCase().contains(searchTerm.toLowerCase())) && !c.equals(club)) {
                listModel.addElement(c.getName());
            }
        }
        trV.getErgListTeam().setModel(listModel);

        LOGGER.log(Level.INFO, "Search \"{0}\"", searchTerm);

        trV.repaint();
        trV.revalidate();
    }

    private void add() {
        String player = trV.getListEigenerKader().getSelectedValue();

        if (player != null) {
            listModelUrsprung.removeElement(player);
            listModelSend.addElement(player);
            LOGGER.log(Level.INFO, "Add {0}", player);

            trV.repaint();
            trV.revalidate();
        }

    }

    private void remove() {
        String player = trV.getListeTransKader().getSelectedValue();

        if (player != null) {
            listModelSend.removeElement(player);
            listModelUrsprung.addElement(player);
            LOGGER.log(Level.INFO, "Remove {0}", player);

            trV.repaint();
            trV.revalidate();
        }
    }

    private void transFinish() {
        int confirm = JOptionPane.showConfirmDialog(trV, "Wollen Sie die Transaktion abschliessen", "Bestaetigen",
                JOptionPane.YES_NO_OPTION);
        Player removedPlayer;
        Club targetClub = null;

        if (confirm == JOptionPane.YES_OPTION) {
            if (listModelSend.getSize() == 0) {
                LOGGER.log(Level.WARNING, "No players selected");
                JOptionPane.showMessageDialog(trV, "Bitte Waehlen Sie die zu uebertragenden Teams aus");
                return;
            }

            for (Club c : clubs) {
                if (c.getName().equals(selectedTeam)) {
                    targetClub = c;
                }
            }

            for (int i = 0; i < listModelSend.getSize(); i++) {
                if (listModelSend.getElementAt(i) != null) {
                    removedPlayer = club.removePlayer(listModelSend.getElementAt(i));
                    targetClub.addPlayer(removedPlayer);
                }
            }
            dao.updateClub(club);
            dao.updateClub(targetClub);
            if (MainController.reloadFromDB()) {
                JOptionPane.showMessageDialog(trV, "Transfer war erfolgreich");
                LOGGER.log(Level.INFO, "Transfer finished successfully");
            } else {
                JOptionPane.showMessageDialog(trV, "Potenzieller Fehler bei Transaktion. Bitte Daten kontrolieren.");
                LOGGER.log(Level.SEVERE, "Transfer finished with errors");
            }
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
            for (Player p : club.getPlayers()) {
                listModelUrsprung.addElement(p.getName());
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

}
