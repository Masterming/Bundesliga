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
    private TransactionView view;
    private Club club;
    private String selectedTeam;
    private DefaultListModel<String> listModelUrsprung;
    private DefaultListModel<String> listModelSend;
    private ClubDBMapper dao = new ClubDBMapper();
    private List<Club> clubs;

    public TransactionController(TransactionView trV, Club club) {
        this.view = trV;
        this.view.getAddToTransBtn().addActionListener(this);
        this.view.getRemoveFromTransBtn().addActionListener(this);
        this.view.getSuchenBtn().addActionListener(this);
        this.view.getTransFinishBtn().addActionListener(this);
        this.view.getErgListTeam().addMouseListener(this);
        listModelUrsprung = new DefaultListModel<>();
        this.view.getListEigenerKader().setModel(listModelUrsprung);
        listModelSend = new DefaultListModel<>();
        this.view.getListeTransKader().setModel(listModelSend);
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
        view.getErgListTeam().removeAll();
        String searchTerm = view.getReceivingTeamInput().getText();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Club c : clubs) {
            if ((searchTerm.equals("Erhaltendes Team") || c.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                    && !c.equals(club)) {
                listModel.addElement(c.getName());
            }
        }
        view.getErgListTeam().setModel(listModel);

        LOGGER.log(Level.INFO, "Search \"{0}\"", searchTerm);

        view.repaint();
        view.revalidate();
    }

    private void add() {
        String player = view.getListEigenerKader().getSelectedValue();

        if (player != null) {
            listModelUrsprung.removeElement(player);
            listModelSend.addElement(player);
            LOGGER.log(Level.INFO, "Add {0}", player);

            view.repaint();
            view.revalidate();
        }

    }

    private void remove() {
        String player = view.getListeTransKader().getSelectedValue();

        if (player != null) {
            listModelSend.removeElement(player);
            listModelUrsprung.addElement(player);
            LOGGER.log(Level.INFO, "Remove {0}", player);

            view.repaint();
            view.revalidate();
        }
    }

    private void transFinish() {
        int confirm = JOptionPane.showConfirmDialog(view, "Wollen Sie die Transaktion abschliessen", "Bestaetigen",
                JOptionPane.YES_NO_OPTION);
        Player removedPlayer;
        Club target = null;
        Club origin = null;

        if (confirm == JOptionPane.YES_OPTION) {
            if (listModelSend.getSize() == 0) {
                LOGGER.log(Level.WARNING, "No players selected");
                JOptionPane.showMessageDialog(view, "Bitte Waehlen Sie die zu uebertragenden Teams aus");
                return;
            }

            for (Club c : clubs) {
                if (c.getName().equals(selectedTeam)) {
                    target = c;
                }
                if (c.equals(club)) {
                    origin = c;
                }
            }

            for (int i = 0; i < listModelSend.getSize(); i++) {
                if (listModelSend.getElementAt(i) != null && target != null && origin != null) {
                    removedPlayer = origin.removePlayer(listModelSend.getElementAt(i));
                    target.addPlayer(removedPlayer);
                }
            }

            // dao.updateClub(origin);
            // dao.updateClub(target);
            if (MainController.reloadFromDB()) {
                JOptionPane.showMessageDialog(view, "Transfer war erfolgreich");
                LOGGER.log(Level.INFO, "Player Transfer finished successfully");
            } else {
                JOptionPane.showMessageDialog(view, "Potenzieller Fehler bei Transaktion. Bitte Daten kontrolieren.");
                LOGGER.log(Level.SEVERE, "Player Transfer finished with errors");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            LOGGER.log(Level.INFO, "Item in Liste geklickt");
            selectedTeam = view.getErgListTeam().getSelectedValue();
            view.setReceiveTeamLbl(selectedTeam);
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
