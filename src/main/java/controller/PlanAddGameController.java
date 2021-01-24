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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Liga;
import model.PlanModel;
import view.PlanAddGameView;

/**
 *
 * @author z003ywys
 */
public class PlanAddGameController implements ActionListener, ItemListener, MouseListener {
    private JFrame mainView;
    private PlanAddGameView paGV;
    private PlanModel plM;
    private Liga l;
    private String selectedALiga;
    private String selectedBLiga;
    private String teamA;
    private String teamB;

    public PlanAddGameController(JFrame mainView, PlanAddGameView PagV, PlanModel plM, Liga l) {
        this.mainView = mainView;
        this.paGV = PagV;
        this.plM = plM;
        this.l = l;
        // this.paGV.get
        this.paGV.getAddSpielBtn().addActionListener(this);
        this.paGV.getTeamALigaList().addItemListener(this);
        this.paGV.getTeamBLigaList().addItemListener(this);
        this.paGV.getTeamAList().addItemListener(this);
        this.paGV.getTeamBList().addItemListener(this);

        adaptViewToLiga();

    }

    private void adaptViewToLiga() {
        if (this.l.getName().contains("1")) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            this.paGV.setTeamALigaList(dfC);
            this.paGV.setTeamBLigaList(dfB);
            // TODO Teams Holen pro liga
        }
        if (this.l.getName().contains("2")) {
            String[] ligen = new String[3];
            ligen[0] = "Liga 1";
            ligen[1] = "Liga 2";
            ligen[2] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            this.paGV.setTeamALigaList(dfC);
            this.paGV.setTeamBLigaList(dfB);
        }
        if (this.l.getName().contains("3")) {
            String[] ligen = new String[2];
            ligen[0] = "Liga 2";
            ligen[1] = "Liga 3";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(ligen);
            DefaultComboBoxModel<String> dfB = new DefaultComboBoxModel<>(ligen);
            this.paGV.setTeamALigaList(dfC);
            this.paGV.setTeamBLigaList(dfB);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch (comm) {
            case "addGame":
                System.out.println("Spiel hinzugefuegt");
                addGame();
                break;
        }
    }

    private void addGame() {
        String dateTemp = this.paGV.getDateInputTxt().getText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime dtGame = LocalDateTime.now();
        boolean ok = true;
        try {
            dtGame = LocalDateTime.from(f.parse(dateTemp));
        } catch (Exception e) {
            System.out.println("Bitte Datum im richtigen Format eingeben");
            JOptionPane.showMessageDialog(null, "Bitte Datum im richtigen Format eingeben");
            ok = false;
        }
        if (ok) {
            System.out.println(dtGame);
            System.out.println(this.teamA);
            System.out.println(this.teamB);
            // TODO Spiel in DB Schreiben und Model aktualisieren
            this.plM.setlM(new Liga("Test"));
            // this.l.setName(this.l.getName());
            this.paGV.dispose();

        }
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        //
        boolean change = false;
        if (this.paGV.getTeamALigaList().getSelectedItem().toString() != selectedALiga
                || this.paGV.getTeamBLigaList().getSelectedItem().toString() != selectedBLiga) {
            change = true;
        }
        selectedALiga = this.paGV.getTeamALigaList().getSelectedItem().toString();
        selectedBLiga = this.paGV.getTeamBLigaList().getSelectedItem().toString();
        if (selectedALiga.contains("1")) {
            if (selectedBLiga.contains("3")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                this.paGV.getTeamALigaList().setSelectedIndex(1);
                this.paGV.repaint();
                this.paGV.revalidate();
            }
        }
        if (selectedALiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                this.paGV.getTeamALigaList().setSelectedIndex(1);
                this.paGV.repaint();
                this.paGV.revalidate();
            }
        }
        if (selectedBLiga.contains("3")) {
            if (selectedBLiga.contains("1")) {
                // Fehlermeldung
                JOptionPane.showMessageDialog(null, "Gewuenschte Ligakombination nicht auswaehlbar");
                this.paGV.getTeamALigaList().setSelectedIndex(1);
                this.paGV.repaint();
                this.paGV.revalidate();
            }
        }
        if (change) {
            getListData();
        }
        if (this.paGV.getTeamAList().getSelectedItem() != null) {
            teamA = this.paGV.getTeamAList().getSelectedItem().toString();
        }
        if (this.paGV.getTeamBList().getSelectedItem() != null) {
            teamB = this.paGV.getTeamBList().getSelectedItem().toString();
        }
        if (teamA != teamB) {
            this.paGV.setTeamALbl(teamA);
            this.paGV.setTeamBLbl(teamB);
        } else {
            JOptionPane.showMessageDialog(null, "Die Teams die gegeneinander Spielen muessen verschieden sein");
        }
    }

    private void getListData() {
        System.out.println(selectedALiga);
        System.out.println(selectedBLiga);
        // Club Liste an die jeweiige Liga angepasst werden
        // TODO --> Daten aus DB holen
        DefaultComboBoxModel<String> listModelTeamA = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> listModelTeamB = new DefaultComboBoxModel<>();

        // TODO List Model befuellen
        if (this.selectedALiga.contains("1")) {
            this.paGV.getTeamAList().removeAll();
            listModelTeamA.addElement("RB Leipzig");
            listModelTeamA.addElement("FC Bayern Muenchen");
        }
        if (this.selectedBLiga.contains("1")) {
            this.paGV.getTeamBList().removeAll();
            listModelTeamB.addElement("RB Leipzig");
            listModelTeamB.addElement("FC Bayern Muenchen");
        }

        if (this.selectedALiga.contains("2")) {
            // TODO List Model befuellen
            this.paGV.getTeamAList().removeAll();
            listModelTeamA.addElement("FC Erzgevirge Aue");
            listModelTeamA.addElement("HSV Hamburg");
        }
        if (this.selectedBLiga.contains("2")) {
            this.paGV.getTeamBList().removeAll();
            listModelTeamB.addElement("FC Erzgevirge Aue");
            listModelTeamB.addElement("HSV Hamburg");
        }
        if (this.selectedALiga.contains("3")) {
            // TODO List Model befuellen
            this.paGV.getTeamAList().removeAll();
            listModelTeamA.addElement("Ingolstadt");
            listModelTeamA.addElement("Dynamo Dresden");
        }
        if (this.selectedBLiga.contains("3")) {
            this.paGV.getTeamBList().removeAll();
            listModelTeamB.addElement("Ingolstadt");
            listModelTeamB.addElement("Dynamo Dresden");
        }
        this.paGV.setTeamAList(listModelTeamA);
        this.paGV.setTeamBList(listModelTeamB);
        this.paGV.repaint();
        this.paGV.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        String liga1 = this.paGV.getTeamALigaList().getSelectedItem().toString();
        if (liga1.contains("1")) {
            // Nur nOch liga 2 oder liga 1 bei
            String[] disLiga = new String[2];
            disLiga[0] = "Liga 1";
            disLiga[2] = "Liga 2";
            DefaultComboBoxModel<String> dfC = new DefaultComboBoxModel<>(disLiga);
            this.paGV.setTeamBLigaList(dfC);
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
