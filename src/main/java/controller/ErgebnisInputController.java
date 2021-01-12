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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Liga;
import model.PlanModel;
import view.ErgebnisInputView;

/**
 *
 * @author z003ywys
 */
public class ErgebnisInputController implements ActionListener {

    private ErgebnisInputView ergDialog;
    private PlanModel plm;
    private List<List<String>> scoreTeamA;
    private List<List<String>> scoreTeamB;
    int teamAErg;
    int teamBErg;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //String a = this.ergDialog.getErg1().getText();
        //String b = this.ergDialog.getErg2().getText();
        String nameA = this.ergDialog.getTeamAPlayerList().getSelectedValue();
        String nameB = this.ergDialog.getTeamBPlayerList().getSelectedValue();
        switch(e.getActionCommand()){
            case "scoreTeamA":
                scoreTeam(nameA, this.scoreTeamA);
                break;
            case "descoreTeamA":
                descoreTeam(nameA, this.scoreTeamA);
                break;
            case "scoreTeamB":
                scoreTeam(nameB, this.scoreTeamB);
                break;
            case "descoreTeamB":
                descoreTeam(nameB, this.scoreTeamB);
                break;
            case "save":
                System.out.println("save");
                save();
                break;
        }
        updateView();
    }

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
        scoreTeamA= new ArrayList<List<String>>();
        scoreTeamB = new ArrayList<List<String>>();
        getData();
        teamAErg=-1;
        teamBErg=-1;
        
    }
    
    private void getData(){
        
        List<String>spieler =new ArrayList();
        spieler.add("Thomas Müller");
        spieler.add("Philipp Lahm");
        DefaultListModel listModelTeamA = new DefaultListModel();
        listModelTeamA.addElement("Thomas Müller");
        listModelTeamA.addElement("Philipp Lahm");
        this.ergDialog.setTeamAPlayerList(listModelTeamA);
        this.ergDialog.repaint();
        this.ergDialog.revalidate();
    }
    
    private void scoreTeam(String name, List<List<String>> dataSet){
        int index=-1;
        boolean found =false;
        for(int i=0; i<dataSet.size();i++){
            if(dataSet.get(i).contains(name)){
                found=true;
                index=i;
                break;
            }
        }
        if(found){
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            currentCount++;
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        }
        else{
            List<String>temp = new ArrayList();
            temp.add(name);
            String countFin = String.valueOf(1);
            temp.add(countFin);
            dataSet.add(temp);
        }
        
    }
    private void descoreTeam(String name, List<List<String>> dataSet){
        System.out.println("Descore Team A");
                int index=-1;
        boolean found =false;
        for(int i=0; i<dataSet.size();i++){
            if(dataSet.get(i).contains(name)){
                found=true;
                index=i;
                break;
            }
        }
        if(found){
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            if(currentCount>0){
            currentCount--;
            }
            if(currentCount==0){
                //Aus der Liste Entfernen
            }
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        }
    }
    private void updateView(){
        DefaultTableModel tbmA = (DefaultTableModel)this.ergDialog.getScoredPlayerTeamA().getModel();

        for(int i=tbmA.getRowCount()-1; i>=0;i--){
            tbmA.removeRow(i);
        }
        //Team A
        for(List<String> strName : scoreTeamA){

           if(!strName.get(1).equals("0")){
           Object[] temp = strName.toArray();
           tbmA.addRow(temp);
           }
        }
        this.ergDialog.setScoredPlayerTeamA(tbmA);
        
        
        
        DefaultTableModel tbmB = (DefaultTableModel)this.ergDialog.getScoredPlayerTeamB().getModel();
        for(int i=tbmB.getRowCount()-1; i>=0;i--){
            tbmB.removeRow(i);
        }
        for(List<String>strName : scoreTeamB){
          if(!strName.get(1).equals("0")){
           Object[] temp = strName.toArray();
           tbmB.addRow(temp);
           }
        }
        this.ergDialog.setScoredPlayerTeamB(tbmB);
        
        
        
        //Den spielstand aktualisieren
        teamAErg = getSpielStand(this.scoreTeamA);
        teamBErg = getSpielStand(this.scoreTeamB);
        this.ergDialog.setErgTeamALbl(String.valueOf(teamAErg));
        this.ergDialog.setErgTeamBLbl1(String.valueOf(teamBErg));
    }
    private int getSpielStand(List<List<String>> inPutData){
        int erg=0;
        for(int i=0; i<inPutData.size();i++){
            for(int j=1; j<inPutData.get(i).size();j++){
                String temp = inPutData.get(i).get(j);
                int tempErg=Integer.parseInt(temp);
                erg+=tempErg;
                
            }
        }
        return erg;
    }
    private void save(){
        if(teamAErg==-1 || teamBErg==-1){
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"Bitte fügen Sie Ergebnisse hinzu"); 
            System.out.println("Spielstand: " + teamAErg + " zu " + teamBErg);
        }
        else{
            //TO Do in DB Schreiben
            System.out.println(this.scoreTeamA);
            System.out.println(this.scoreTeamB);
        }
    }
    
}
