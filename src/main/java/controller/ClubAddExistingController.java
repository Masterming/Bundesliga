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
import java.util.List;
import java.util.logging.*;

import model.Club;
import model.Liga;
import model.LigaDBMapper;
import view.ClubAddExistingView;

/**
 * @author z003ywys
 */
public class ClubAddExistingController implements ActionListener, MouseListener, ItemListener {

    private final static Logger LOGGER = Logger.getLogger(ClubAddExistingController.class.getName());
    private ClubAddExistingView view;
    private Liga l;
    private String selectedClub;
    private DefaultListModel<String> clubList;
    private LigaDBMapper dao = new LigaDBMapper();
    private List<Liga> allLigas;
    private int ligaRemID;

    public ClubAddExistingController(ClubAddExistingView view, Liga l) {
        this.view = view;
        this.l = l;
        this.view.getAdClubToLigaBtn().addActionListener(this);
        this.view.getSelectedLiga().addItemListener(this);
        this.view.getLigaClubList().addMouseListener(this);
        clubList = new DefaultListModel<>();
        this.view.getLigaClubList().setModel(clubList);
        this.allLigas = dao.getLigas();
        adaptViewToLiga();

    }

    private void adaptViewToLiga() {
        // TODO Club View Anpassen
        if (l.getId() == 1) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            view.setLigaComboModel(dfC);
            populateComboBox();

        }
        if (l.getId() == 2) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            view.setLigaComboModel(dfC);
            populateComboBox();
        }
        if (l.getId() == 3) {
            String[] ligen = new String[1];
            ligen[0] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            view.setLigaComboModel(dfC);
            populateComboBox();
        }

        view.repaint();
        view.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "clubAddLiga":

                int confirm = JOptionPane.showConfirmDialog(view, "Wollen Sie den Club zur Liga hinzufuegen ?",
                        "Club Hinzufuegen", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    LOGGER.log(Level.INFO, "CLub: " + selectedClub + " zur Liga hinzugefuegt");
                    // TODO Transfer
                    if (selectedClub != null) {
                        // l.removeClub(selectedClub);
                        // l.addClub(c)
                        Club remClub = allLigas.get(this.ligaRemID).removeClub(selectedClub);
                        dao.updateLiga(allLigas.get(this.ligaRemID));
                        allLigas.get(l.getId() - 1).addClub(remClub);
                        dao.updateLiga(allLigas.get(l.getId() - 1));

                        MainController.reloadFromDB();
                        JOptionPane.showMessageDialog(view, "Transfer war erfolgreich");
                    }
                }
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // 1. Liga auswahl
        if (evt.getClickCount() == 1) {
            try {
                selectedClub = view.getLigaClubList().getSelectedValue();
                if (selectedClub != null) {
                    view.getToAddClubLbl().setText(selectedClub);

                } else {
                    view.getToAddClubLbl().setText("");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
                view.getToAddClubLbl().setText("");
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

    private void populateComboBox() {
        String ligStr = view.getSelectedLiga().getSelectedItem().toString();
        clubList.removeAllElements();
        if (ligStr.contains("1")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : allLigas.get(0).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.ligaRemID = 0;

        }
        if (ligStr.contains("2")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : allLigas.get(1).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.ligaRemID = 1;

        }
        if (ligStr.contains("3")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : allLigas.get(2).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.ligaRemID = 2;
        }
    }

}
