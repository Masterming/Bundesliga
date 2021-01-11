/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.PlanModel;
import view.PlanAddGameView;

/**
 *
 * @author z003ywys
 */
public class PlanAddGameController implements ActionListener {
    private JFrame mainView;
    private PlanAddGameView paGV;
    private PlanModel plM;

    public PlanAddGameController(JFrame mainView, PlanAddGameView PagV, PlanModel plM) {
        this.mainView = mainView;
        this.paGV=PagV;
        this.plM=plM;
        this.paGV.getAddSpielBtn().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch(comm){
            case "addGame":
                System.out.println("Spiel hinzugefügt");
                addGame();
                break;
        }
    }
    
    private void addGame(){
        String teamA = this.paGV.getTeamAInputTxt().getText().trim();
        String teamB = this.paGV.getTeamBInputTxt().getText().trim();
        String dateTemp = this.paGV.getDateInputTxt().getText().trim();
        if(teamA.equalsIgnoreCase("")|| teamB.equalsIgnoreCase("") ||dateTemp.equalsIgnoreCase("")){
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"Bitte geben Sie in alle Felder etwas ein");  
        }else{
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime  dtGame = LocalDateTime.now();
        boolean ok =true;

        try{
        dtGame = LocalDateTime.from(f.parse(dateTemp));
        }catch(Exception e){
            System.out.println("Bitte Datum im richtigen Format eingeben");
            JFrame fa=new JFrame();  
            JOptionPane.showMessageDialog(fa,"Bitte geben Sie das Datum im richtigen Format ein");  
            ok =false;
        }
        if(ok){
            System.out.println(dtGame);
            //TO DO
            //Spiel in DB Schreiben und Model aktualisieren
            
            
        }
        }
        
    }
    
    
}
