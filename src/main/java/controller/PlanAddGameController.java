package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.*;

import model.Club;
import model.Game;
import model.Liga;
import view.PlanAddGameView;

/**
 *
 * @author z003ywys
 */
public class PlanAddGameController implements ActionListener, ItemListener, MouseListener {

    private final static Logger LOGGER = Logger.getLogger(PlanAddGameController.class.getName());
    private JFrame master;
    private PlanAddGameView view;
    private Liga liga;
    private Liga ligaA;
    private Liga ligaB;
    private String selectedALiga;
    private String selectedBLiga;
    private Map<Integer, Liga> ligas;

    public PlanAddGameController(JFrame master, PlanAddGameView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
        this.view.getClubALigaList().addItemListener(this);
        this.view.getClubBLigaList().addItemListener(this);
        this.view.getClubAList().addItemListener(this);
        this.view.getClubBList().addItemListener(this);
        this.ligas = MainController.getLigas();

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        view.getDateInputTxt().setText(LocalDateTime.now().format(f));

        adaptViewToLiga();
        getListData();
        updateOverview();
    }

    private void adaptViewToLiga() {
        if (liga.getId() == 1) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setClubALigaList(dfC);
            view.setClubBLigaList(dfB);
            // TODO Clubs Holen pro liga
        }
        if (liga.getId() == 2) {
            String[] ligen = new String[3];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            ligen[2] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setClubALigaList(dfC);
            view.setClubBLigaList(dfB);
        }
        if (liga.getId() == 3) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 2";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setClubALigaList(dfC);
            view.setClubBLigaList(dfB);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch (comm) {
            case "addGame":
                addGame();
                break;
        }
    }

    private void addGame() {
        String dateTemp = view.getDateInputTxt().getText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dtGame;

        Club c1 = ligaA.getClub(view.getClubALbl().getText());
        Club c2 = ligaB.getClub(view.getClubBLbl().getText());

        if (c1 == null || c2 == null) {
            JOptionPane.showMessageDialog(view, "Einer der Clubs ist invalide");
            return;
        }

        if (c1.equals(c2)) {
            JOptionPane.showMessageDialog(view, "Die Clubs die gegeneinander Spielen muessen verschieden sein");
            return;
        }

        try {
            dtGame = LocalDateTime.from(f.parse(dateTemp));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Bitte Datum im richtigen Format eingeben");
            return;
        }

        if ((selectedALiga.contains("1") && selectedBLiga.contains("3")) || (selectedALiga.contains("3") && selectedBLiga.contains("1"))) {
            JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
            return;
        }

        /*
        LOGGER.log(Level.INFO, ligaA.toString());
        LOGGER.log(Level.INFO, ligaB.toString());
        LOGGER.log(Level.INFO, c1.toString());
        LOGGER.log(Level.INFO, c2.toString());
        LOGGER.log(Level.INFO, dtGame.toString());
         */
        Game game = new Game(c1, c2, dtGame, ligaA, ligaB);
        ligaA.updateGame(game);
        if (ligaA.getId() != ligaB.getId()) {
            ligaB.updateGame(game);
        }
        LOGGER.log(Level.INFO, "Setup of {0} successful", game);

        view.dispose();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        updateOverview();
    }

    private void updateOverview() {
        if (!view.getClubALigaList().getSelectedItem().toString().equals(selectedALiga)
                || !view.getClubBLigaList().getSelectedItem().toString().equals(selectedBLiga)) {
            selectedALiga = view.getClubALigaList().getSelectedItem().toString();
            selectedBLiga = view.getClubBLigaList().getSelectedItem().toString();
            getListData();
        }
        if (view.getClubAList().getSelectedItem() != null) {
            view.setClubALbl(view.getClubAList().getSelectedItem().toString());
        }
        if (view.getClubBList().getSelectedItem() != null) {
            view.setClubBLbl(view.getClubBList().getSelectedItem().toString());
        }

        view.repaint();
        view.revalidate();
    }

    private void getListData() {
        DefaultComboBoxModel<String> listModelClubA = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> listModelClubB = new DefaultComboBoxModel<>();

        if (selectedALiga == null) {
            selectedALiga = "Liga 1";
        }
        if (selectedBLiga == null) {
            selectedBLiga = "Liga 1";
        }

        if (selectedALiga.contains("1")) {
            view.getClubAList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelClubA.addElement(c.getName());
            }
            ligaA = this.ligas.get(1);
        }
        if (selectedBLiga.contains("1")) {
            view.getClubBList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelClubB.addElement(c.getName());
            }
            ligaB = ligas.get(1);
        }

        if (selectedALiga.contains("2")) {
            view.getClubAList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelClubA.addElement(c.getName());
            }
            ligaA = ligas.get(2);
        }
        if (selectedBLiga.contains("2")) {
            view.getClubBList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelClubB.addElement(c.getName());
            }
            ligaB = ligas.get(2);
        }
        if (selectedALiga.contains("3")) {
            view.getClubAList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelClubA.addElement(c.getName());
            }
            ligaA = ligas.get(3);
        }
        if (selectedBLiga.contains("3")) {
            view.getClubBList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelClubB.addElement(c.getName());
            }
            ligaB = ligas.get(3);
        }

        view.setClubAList(listModelClubA);
        view.setClubBList(listModelClubB);
        view.repaint();
        view.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String liga1 = view.getClubALigaList().getSelectedItem().toString();
        if (liga1.contains("1")) {
            String[] disLiga = new String[2];
            disLiga[0] = "Liga 1";
            disLiga[2] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(disLiga);
            view.setClubBLigaList(dfC);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
