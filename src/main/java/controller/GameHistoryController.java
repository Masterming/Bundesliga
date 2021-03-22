/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Game;
import model.Liga;
import view.GameHistoryView;
import view.PlanViewTemp;

/**
 *
 * @author z003ywys
 */
public class GameHistoryController implements ActionListener {
    private Liga l;
    private GameHistoryView ghV;
    private PlanController plC;

    public GameHistoryController(Liga l, GameHistoryView ghV,PlanController PLC) {
        this.l = l;
        this.ghV = ghV;
        this.ghV.getBackToPlanBtn().addActionListener(this);
        this.plC = PLC;
        getDataAndAdapatView();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String act = evt.getActionCommand();
        if(act=="backToPlan"){
            System.out.println("Go Back to Plan");
            this.plC.restorePlanView();
            
        }
    }
    private void getDataAndAdapatView(){
        String[][] data = new String[l.getFinishCount()][];
        int count =0;
        for (Game g : this.l.getGames()){
            if(g.isFinished()){
                String day = String.valueOf(g.getStart().getDayOfMonth());
                String month = String.valueOf(g.getStart().getMonthValue());
                String year = String.valueOf(g.getStart().getYear());
                String hour = String.valueOf(g.getStart().getHour());
                String minute = String.valueOf(g.getStart().getMinute());
                
                String heim = g.getClub1().getName();
                String torHeim = String.valueOf(g.getScore1());
                String gast = g.getClub2().getName();
                String torGast = String.valueOf(g.getScore2());
                String datum = day  +  "." + month + "." + year + " um "  + hour + ":" + minute;
                String austragungsOrt = g.getClub1().getStadion();
                String temp[] = new String[6];
                temp[0] = datum;
                temp[1] = heim;
                temp[2] = torHeim;
                temp[3] = torGast;
                temp[4] = gast;
                temp[5] = austragungsOrt;
                data[count] = temp;
                count++;
            }
        }
        
        
        if(l.getFinishCount()>0){
         DefaultTableModel tbm = (DefaultTableModel) ghV.getHistoryTable().getModel();
         for (String[] d : data) {
            tbm.addRow(d);
        }
        }
    }
    
}
