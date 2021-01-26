/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;

import model.Liga;
import model.PlanModel;
import view.ErgebnisInputView;

/**
 *
 * @author z003ywys
 */
public class ErgebnisInputController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ErgebnisInputController.class.getName());

    private ErgebnisInputView ergDialog;
    private PlanModel plm;
    private List<List<String>> scoreTeamA;
    private List<List<String>> scoreTeamB;
    int teamAErg;
    int teamBErg;

    public ErgebnisInputController(ErgebnisInputView ergDialog, String teamA, String teamB, PlanModel plmEx) {
        this.ergDialog = ergDialog;
        this.ergDialog.setTeamALbl(teamA);
        this.ergDialog.setTeamBLbl(teamB);
        this.plm = plmEx;
        this.ergDialog.getSaveBtn().addActionListener(this);
        this.ergDialog.getTeamAAddGoalForPlayer().addActionListener(this);
        this.ergDialog.getTeamASubGoalForPlayer().addActionListener(this);
        this.ergDialog.getTeamBAddGoalForPlayer().addActionListener(this);
        this.ergDialog.getTeamBSubGoalForPlayer().addActionListener(this);
        scoreTeamA = new ArrayList<List<String>>();
        scoreTeamB = new ArrayList<List<String>>();
        getData();
        teamAErg = -1;
        teamBErg = -1;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String a = ergDialog.getErg1().getText();
        // String b = ergDialog.getErg2().getText();
        String nameA = ergDialog.getTeamAPlayerList().getSelectedValue();
        String nameB = ergDialog.getTeamBPlayerList().getSelectedValue();
        switch (e.getActionCommand()) {
            case "scoreTeamA":
                scoreTeam(nameA, scoreTeamA);
                break;
            case "descoreTeamA":
                descoreTeam(nameA, scoreTeamA);
                break;
            case "scoreTeamB":
                scoreTeam(nameB, scoreTeamB);
                break;
            case "descoreTeamB":
                descoreTeam(nameB, scoreTeamB);
                break;
            case "save":
                LOGGER.log(Level.INFO, "save");
                save();
                break;
        }
        updateView();
    }

    private void getData() {
        // TODO daten aus DB holen
        List<String> spieler = new ArrayList<>();
        spieler.add("Thomas Mueller");
        spieler.add("Philipp Lahm");
        DefaultListModel<String> listModelTeamA = new DefaultListModel<>();
        listModelTeamA.addElement("Thomas Mueller");
        listModelTeamA.addElement("Philipp Lahm");

        ergDialog.setTeamAPlayerList(listModelTeamA);
        ergDialog.repaint();
        ergDialog.revalidate();
    }

    private void scoreTeam(String name, List<List<String>> dataSet) {
        int index = -1;
        boolean found = false;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i).contains(name)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            currentCount++;
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        } else {
            if (name != null) {
                List<String> temp = new ArrayList<>();
                temp.add(name);
                String countFin = String.valueOf(1);
                temp.add(countFin);
                dataSet.add(temp);
            }
        }

    }

    private void descoreTeam(String name, List<List<String>> dataSet) {
        LOGGER.log(Level.INFO, "Descore Team A");
        int index = -1;
        boolean found = false;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i).contains(name)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            if (currentCount > 0) {
                currentCount--;
            }
            if (currentCount == 0) {
                // Aus der Liste Entfernen
            }
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        }
    }

    private void updateView() {
        DefaultTableModel tbmA = (DefaultTableModel) ergDialog.getScoredPlayerTeamA().getModel();

        for (int i = tbmA.getRowCount() - 1; i >= 0; i--) {
            tbmA.removeRow(i);
        }
        // Team A
        for (List<String> strName : scoreTeamA) {

            if (!strName.get(1).equals("0")) {
                Object[] temp = strName.toArray();
                tbmA.addRow(temp);
            }
        }
        ergDialog.setScoredPlayerTeamA(tbmA);

        DefaultTableModel tbmB = (DefaultTableModel) ergDialog.getScoredPlayerTeamB().getModel();
        for (int i = tbmB.getRowCount() - 1; i >= 0; i--) {
            tbmB.removeRow(i);
        }
        for (List<String> strName : scoreTeamB) {
            if (!strName.get(1).equals("0")) {
                Object[] temp = strName.toArray();
                tbmB.addRow(temp);
            }
        }
        ergDialog.setScoredPlayerTeamB(tbmB);

        // Den spielstand aktualisieren
        teamAErg = getSpielStand(scoreTeamA);
        teamBErg = getSpielStand(scoreTeamB);
        ergDialog.setErgTeamALbl(String.valueOf(teamAErg));
        ergDialog.setErgTeamBLbl1(String.valueOf(teamBErg));
    }

    private int getSpielStand(List<List<String>> inPutData) {
        int erg = 0;
        for (int i = 0; i < inPutData.size(); i++) {
            for (int j = 1; j < inPutData.get(i).size(); j++) {
                String temp = inPutData.get(i).get(j);
                int tempErg = Integer.parseInt(temp);
                erg += tempErg;

            }
        }
        return erg;
    }

    private void save() {
        if (teamAErg == -1 || teamBErg == -1) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bitte fuegen Sie Ergebnisse hinzu");
            LOGGER.log(Level.INFO, "Spielstand: " + teamAErg + " zu " + teamBErg);
        } else {
            // TODO in DB Schreiben und Model aendern
            LOGGER.log(Level.INFO, scoreTeamA.toString());
            LOGGER.log(Level.INFO, scoreTeamB.toString());

            ergDialog.dispose();
        }
    }

}
