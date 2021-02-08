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
    private String teamA;
    private String teamB;
    private Map<Integer, Liga> ligas;

    public PlanAddGameController(JFrame master, PlanAddGameView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
        this.view.getTeamALigaList().addItemListener(this);
        this.view.getTeamBLigaList().addItemListener(this);
        this.view.getTeamAList().addItemListener(this);
        this.view.getTeamBList().addItemListener(this);
        this.ligas = MainController.getLigas();

        adaptViewToLiga();

    }

    private void adaptViewToLiga() {
        if (liga.getId() == 1) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setTeamALigaList(dfC);
            view.setTeamBLigaList(dfB);
            // TODO Teams Holen pro liga
        }
        if (liga.getId() == 2) {
            String[] ligen = new String[3];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            ligen[2] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setTeamALigaList(dfC);
            view.setTeamBLigaList(dfB);
        }
        if (liga.getId() == 3) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 2";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            view.setTeamALigaList(dfC);
            view.setTeamBLigaList(dfB);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch (comm) {
            case "addGame":
                LOGGER.log(Level.INFO, "Spiel hinzugefuegt");
                addGame();
                break;
        }
    }

    private void addGame() {
        String dateTemp = view.getDateInputTxt().getText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dtGame = LocalDateTime.now();
        boolean ok = true;
        try {
            dtGame = LocalDateTime.from(f.parse(dateTemp));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Bitte Datum im richtigen Format eingeben");
            JOptionPane.showMessageDialog(view, "Bitte Datum im richtigen Format eingeben");
            ok = false;
        }
        if (ok) {
            LOGGER.log(Level.INFO, dtGame.toString());
            LOGGER.log(Level.INFO, teamA);
            LOGGER.log(Level.INFO, teamB);
            // TODO Spiel in DB Schreiben und Model aktualisieren
            //Ligas holen
            Game g1 = new Game(this.ligaA.getClub(teamA), this.ligaB.getClub(teamB), dtGame);

            view.dispose();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        //
        boolean change = false;
        if (!view.getTeamALigaList().getSelectedItem().toString().equals(selectedALiga)
                || !view.getTeamBLigaList().getSelectedItem().toString().equals(selectedBLiga)) {
            change = true;
        }
        selectedALiga = view.getTeamALigaList().getSelectedItem().toString();
        selectedBLiga = view.getTeamBLigaList().getSelectedItem().toString();
        if (selectedALiga.contains("1")) {
            if (selectedBLiga.contains("3")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (selectedALiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (selectedBLiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (change) {
            getListData();
        }
        if (view.getTeamAList().getSelectedItem() != null) {
            teamA = view.getTeamAList().getSelectedItem().toString();
        }
        if (view.getTeamBList().getSelectedItem() != null) {
            teamB = view.getTeamBList().getSelectedItem().toString();
        }
        if (!teamA.equals(teamB)) {
            view.setTeamALbl(teamA);
            view.setTeamBLbl(teamB);
        } else {
            JOptionPane.showMessageDialog(view, "Die Teams die gegeneinander Spielen muessen verschieden sein");
        }
    }

    private void getListData() {
        LOGGER.log(Level.INFO, selectedALiga);
        LOGGER.log(Level.INFO, selectedBLiga);
        // Club Liste an die jeweiige Liga angepasst werden
        // TODO --> Daten aus DB holen
        DefaultComboBoxModel<String> listModelTeamA = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> listModelTeamB = new DefaultComboBoxModel<>();

        // TODO List Model befuellen
        if (selectedALiga.contains("1")) {
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(1);
            //this.targetLigaId = 1;
        }
        if (selectedBLiga.contains("1")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(1);
        }

        if (selectedALiga.contains("2")) {
            // TODO List Model befuellen
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(2);
        }
        if (selectedBLiga.contains("2")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(2);
        }
        if (selectedALiga.contains("3")) {
            // TODO List Model befuellen
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(3);
        }
        if (selectedBLiga.contains("3")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(3);
        }
        view.setTeamAList(listModelTeamA);
        view.setTeamBList(listModelTeamB);
        view.repaint();
        view.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        String liga1 = view.getTeamALigaList().getSelectedItem().toString();
        if (liga1.contains("1")) {
            // Nur nOch liga 2 oder liga 1 bei
            String[] disLiga = new String[2];
            disLiga[0] = "Liga 1";
            disLiga[2] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(disLiga);
            view.setTeamBLigaList(dfC);
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
