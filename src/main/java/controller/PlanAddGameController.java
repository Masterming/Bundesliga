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
        String teamA = this.paGV.getTeamAInputTxt().getText();
        String teamB = this.paGV.getTeamBInputTxt().getText();
        String dateTemp = this.paGV.getDateInputTxt().getText();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime  dtGame = LocalDateTime.now();
        boolean ok =true;
        try{
        dtGame = LocalDateTime.from(f.parse(dateTemp));
        }catch(Exception e){
            System.out.println("Bitte Datum im richtigen Format eingeben");
            ok =false;
        }
        if(ok){
            System.out.println(dtGame);
            //Spiel in DB Schreiben und Model aktualisieren
            
        }
        
    }
    
    
}
