package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.logging.*;

import model.Club;
import model.Liga;
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
    private Map<Integer, Liga> ligas;

    public TransactionController(TransactionView view, Club club) {
        this.view = view;
        this.club = club;
        ligas = MainController.getLigas();
        this.view.getAddToTransBtn().addActionListener(this);
        this.view.getRemoveFromTransBtn().addActionListener(this);
        this.view.getSuchenBtn().addActionListener(this);
        this.view.getTransFinishBtn().addActionListener(this);
        this.view.getErgListTeam().addMouseListener(this);
        listModelUrsprung = new DefaultListModel<>();
        this.view.getListEigenerKader().setModel(listModelUrsprung);
        listModelSend = new DefaultListModel<>();
        this.view.getListeTransKader().setModel(listModelSend);
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
        for (Liga l : ligas.values()) {
            for (Club c : l.getClubs()) {
                if ((searchTerm.equals("Erhaltendes Team")
                        || c.getName().toLowerCase().contains(searchTerm.toLowerCase())) && !c.equals(club)) {
                    listModel.addElement(c.getName());
                }
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
        Club originC = null;
        Club targetC = null;
        Liga originL = null;
        Liga targetL = null;

        if (confirm == JOptionPane.YES_OPTION) {
            if (listModelSend.getSize() == 0) {
                LOGGER.log(Level.WARNING, "No players selected");
                JOptionPane.showMessageDialog(view, "Bitte Waehlen Sie die zu uebertragenden Teams aus");
                return;
            }

            for (Liga l : ligas.values()) {
                if (l.getClub(club.getName()) != null) {
                    originC = l.getClub(club.getName());
                    originL = l;
                }
                if (l.getClub(selectedTeam) != null) {
                    targetC = l.getClub(selectedTeam);
                    targetL = l;
                }
            }

            for (int i = 0; i < listModelSend.getSize(); i++) {
                if (listModelSend.getElementAt(i) != null && targetC != null && originC != null) {
                    removedPlayer = originC.removePlayer(listModelSend.getElementAt(i));
                    targetC.addPlayer(removedPlayer);
                }
            }

            boolean updateOrigin = originL.updateClub(originC);
            boolean updateTarget = targetL.updateClub(targetC);

            if (updateOrigin && updateTarget) {
                JOptionPane.showMessageDialog(view, "Transfer war erfolgreich");
                LOGGER.log(Level.INFO, "Player Transfer finished successfully");
            } else {
                JOptionPane.showMessageDialog(view, "Transfer fehlgeschlagen");
                LOGGER.log(Level.INFO, "Player Transfer failed");

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
