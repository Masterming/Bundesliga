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

        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        view.getDateInputTxt().setText(LocalDateTime.now().format(f));

        adaptViewToLiga();
        getListData();

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
            LOGGER.log(Level.WARNING, "Wrong datetime format");
            JOptionPane.showMessageDialog(view, "Bitte Datum im richtigen Format eingeben");
            ok = false;
        }
        if (ok) {
            LOGGER.log(Level.INFO, dtGame.toString());
            LOGGER.log(Level.INFO, teamA);
            LOGGER.log(Level.INFO, teamB);
            Club c1 = ligaA.getClub(view.getTeamALbl().getText());
            Club c2 = ligaB.getClub(view.getTeamBLbl().getText());
            Game g1 = new Game(c1, c2, dtGame, ligaA, ligaB);
            ligaA.updateGame(g1);
            if (ligaA.getId() != ligaB.getId()) {
                ligaB.updateGame(g1);
            }

            view.dispose();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String teamAtemp = "";
        String teamBtemp = "";
        boolean change = false;
        if (!view.getTeamALigaList().getSelectedItem().toString().equals(selectedALiga)
                || !view.getTeamBLigaList().getSelectedItem().toString().equals(selectedBLiga)) {
            change = true;
        }
        selectedALiga = view.getTeamALigaList().getSelectedItem().toString();
        selectedBLiga = view.getTeamBLigaList().getSelectedItem().toString();
        if (selectedALiga.contains("1")) {
            if (selectedBLiga.contains("3")) {
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (selectedALiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (selectedBLiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                JOptionPane.showMessageDialog(view, "Gewuenschte Ligakombination nicht auswaehlbar");
                view.getTeamALigaList().setSelectedIndex(1);
                view.repaint();
                view.revalidate();
            }
        }
        if (selectedBLiga.contains("2") && selectedALiga.contains("2")) {
            JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
            view.getTeamALigaList().setSelectedIndex(3);
            view.getTeamBLigaList().setSelectedIndex(3);
        }
        if (change) {
            getListData();
        }
        if (view.getTeamAList().getSelectedItem() != null) {
            teamAtemp = view.getTeamAList().getSelectedItem().toString();
        }
        if (view.getTeamBList().getSelectedItem() != null) {
            teamBtemp = view.getTeamBList().getSelectedItem().toString();
        }
        if (!teamAtemp.equals(teamBtemp) && !teamAtemp.isEmpty() && !teamBtemp.isEmpty()) {
            teamA = teamAtemp;
            teamB = teamBtemp;
            view.setTeamALbl(teamA);
            view.setTeamBLbl(teamB);
            view.repaint();
            view.revalidate();
        } else if (!teamAtemp.isEmpty() && !teamBtemp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Die Teams die gegeneinander Spielen muessen verschieden sein");
            view.getTeamAList().setSelectedItem(teamA);
            view.getTeamBList().setSelectedItem(teamB);
        }
    }

    private void getListData() {
        LOGGER.log(Level.INFO, selectedALiga);
        LOGGER.log(Level.INFO, selectedBLiga);
        DefaultComboBoxModel<String> listModelTeamA = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> listModelTeamB = new DefaultComboBoxModel<>();

        if (selectedALiga == null) {
            selectedALiga = "Liga 1";
        }
        if (selectedBLiga == null) {
            selectedBLiga = "Liga 1";
        }

        if (selectedALiga.contains("1")) {
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            ligaA = this.ligas.get(1);
        }
        if (selectedBLiga.contains("1")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            ligaB = ligas.get(1);
        }

        if (selectedALiga.contains("2")) {
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            ligaA = ligas.get(2);
        }
        if (selectedBLiga.contains("2")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            ligaB = ligas.get(2);
        }
        if (selectedALiga.contains("3")) {
            view.getTeamAList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            ligaA = ligas.get(3);
        }
        if (selectedBLiga.contains("3")) {
            view.getTeamBList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            ligaB = ligas.get(3);
        }

        view.setTeamAList(listModelTeamA);
        view.setTeamBList(listModelTeamB);
        view.repaint();
        view.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String liga1 = view.getTeamALigaList().getSelectedItem().toString();
        if (liga1.contains("1")) {
            String[] disLiga = new String[2];
            disLiga[0] = "Liga 1";
            disLiga[2] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(disLiga);
            view.setTeamBLigaList(dfC);
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
