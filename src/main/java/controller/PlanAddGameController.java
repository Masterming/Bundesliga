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
    private PlanAddGameView paGV;
    private Liga l;
    private Liga ligaA;
    private Liga ligaB;
    private String selectedALiga;
    private String selectedBLiga;
    private String teamA;
    private String teamB;
    private Map<Integer, Liga> ligas;

    public PlanAddGameController(JFrame master, PlanAddGameView PagV, Liga l) {
        this.master = master;
        this.paGV = PagV;
        this.l = l;
        // this.paGV.get
        this.paGV.getAddSpielBtn().addActionListener(this);
        this.paGV.getTeamALigaList().addItemListener(this);
        this.paGV.getTeamBLigaList().addItemListener(this);
        this.paGV.getTeamAList().addItemListener(this);
        this.paGV.getTeamBList().addItemListener(this);
        this.ligas = MainController.getLigas();

        adaptViewToLiga();
        getListData();

    }

    private void adaptViewToLiga() {
        if (l.getId() == 1) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            paGV.setTeamALigaList(dfC);
            paGV.setTeamBLigaList(dfB);
            // TODO Teams Holen pro liga
        }
        if (l.getId() == 2) {
            String[] ligen = new String[3];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            ligen[2] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            paGV.setTeamALigaList(dfC);
            paGV.setTeamBLigaList(dfB);
        }
        if (l.getId() == 3) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 2";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            paGV.setTeamALigaList(dfC);
            paGV.setTeamBLigaList(dfB);
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
        String dateTemp = paGV.getDateInputTxt().getText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dtGame = LocalDateTime.now();
        boolean ok = true;
        try {
            dtGame = LocalDateTime.from(f.parse(dateTemp));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Bitte Datum im richtigen Format eingeben");
            JOptionPane.showMessageDialog(null, "Bitte Datum im richtigen Format eingeben");
            ok = false;
        }
        if (ok) {
            LOGGER.log(Level.INFO, dtGame.toString());
            LOGGER.log(Level.INFO, teamA);
            LOGGER.log(Level.INFO, teamB);
            // TODO Spiel in DB Schreiben und Model aktualisieren
            //Ligas holen
            Club c1 = this.ligaA.getClub(paGV.getTeamALbl().getText());
            Club c2 = this.ligaB.getClub(paGV.getTeamBLbl().getText());
            Game g1 = new Game(c1, c2, dtGame, this.ligaA, this.ligaB);
            if (this.ligaA.getId() != this.ligaB.getId()) {
                this.ligaA.updateGame(g1);
                this.ligaB.updateGame(g1);
            } else {
                this.ligaA.updateGame(g1);
            }
            
            paGV.dispose();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        //
        String teamAtemp="";
        String teamBtemp="";
        boolean change = false;
        if (!paGV.getTeamALigaList().getSelectedItem().toString().equals(selectedALiga)
                || !paGV.getTeamBLigaList().getSelectedItem().toString().equals(selectedBLiga)) {
            change = true;
        }
        selectedALiga = paGV.getTeamALigaList().getSelectedItem().toString();
        selectedBLiga = paGV.getTeamBLigaList().getSelectedItem().toString();
        if (selectedALiga.contains("1")) {
            if (selectedBLiga.contains("3")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                paGV.getTeamALigaList().setSelectedIndex(1);
                paGV.repaint();
                paGV.revalidate();
            }
        }
        if (selectedALiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                paGV.getTeamALigaList().setSelectedIndex(1);
                paGV.repaint();
                paGV.revalidate();
            }
        }
        if (selectedBLiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                paGV.getTeamALigaList().setSelectedIndex(1);
                paGV.repaint();
                paGV.revalidate();
            }
        }
        if(selectedBLiga.contains("2") && selectedALiga.contains("2")){
            JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
            paGV.getTeamALigaList().setSelectedIndex(3);
            paGV.getTeamBLigaList().setSelectedIndex(3);
        }
        if (change) {
            getListData();
        }
        if (paGV.getTeamAList().getSelectedItem() != null) {
            teamAtemp = paGV.getTeamAList().getSelectedItem().toString();
        }
        if (paGV.getTeamBList().getSelectedItem() != null) {
            teamBtemp = paGV.getTeamBList().getSelectedItem().toString();
        }
        if (!teamAtemp.equals(teamBtemp) && !teamAtemp.isEmpty() && !teamBtemp.isEmpty()) {
            teamA = teamAtemp;
            teamB = teamBtemp;
            paGV.setTeamALbl(teamA);
            paGV.setTeamBLbl(teamB);
            paGV.repaint();
            paGV.revalidate();
        } 
        else if(!teamAtemp.isEmpty() && !teamBtemp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Die Teams die gegeneinander Spielen muessen verschieden sein");
            //Kombobox zuürcksetzen
            paGV.getTeamAList().setSelectedItem(teamA);
            paGV.getTeamBList().setSelectedItem(teamB);
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
        if(selectedALiga == null){
            selectedALiga = "Liga 1";
        }
        if(selectedBLiga == null){
            selectedBLiga = "Liga 1";
        }
        
        if (selectedALiga.contains("1")) {
            paGV.getTeamAList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(1);
            //this.targetLigaId = 1;
        }
        if (selectedBLiga.contains("1")) {
            paGV.getTeamBList().removeAll();
            for (Club c : ligas.get(1).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(1);
        }

        if (selectedALiga.contains("2")) {
            // TODO List Model befuellen
            paGV.getTeamAList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(2);
        }
        if (selectedBLiga.contains("2")) {
            paGV.getTeamBList().removeAll();
            for (Club c : ligas.get(2).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(2);
        }
        if (selectedALiga.contains("3")) {
            // TODO List Model befuellen
            paGV.getTeamAList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamA.addElement(c.getName());
            }
            this.ligaA = this.ligas.get(3);
        }
        if (selectedBLiga.contains("3")) {
            paGV.getTeamBList().removeAll();
            for (Club c : ligas.get(3).getClubs()) {
                listModelTeamB.addElement(c.getName());
            }
            this.ligaB = this.ligas.get(3);
        }
        
        paGV.setTeamAList(listModelTeamA);
        paGV.setTeamBList(listModelTeamB);
        paGV.repaint();
        paGV.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        String liga1 = paGV.getTeamALigaList().getSelectedItem().toString();
        if (liga1.contains("1")) {
            // Nur nOch liga 2 oder liga 1 bei
            String[] disLiga = new String[2];
            disLiga[0] = "Liga 1";
            disLiga[2] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(disLiga);
            paGV.setTeamBLigaList(dfC);
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
