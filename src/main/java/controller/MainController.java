/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Liga;
import view.MainView;
import view.MainView2;

/**
 *
 * @author z003ywys
 */
public class MainController implements ActionListener {
    private MainView2 view;
    private Liga ligaModel;
    
    boolean liga1 = false;
    boolean liga2 = false;
    boolean liga3 = false;
    boolean table = false;
    boolean spielplan = false;
    boolean clubs = false;

    public MainController(MainView2 view, Liga ligaModel) {
        this.view = view;
        this.ligaModel = ligaModel;
        this.view.getLiga1Btn().addActionListener(this);
        this.view.getLiga2Btn().addActionListener(this);
        this.view.getLiga3Btn().addActionListener(this);
        this.view.getClubsBtn().addActionListener(this);
        this.view.getPlanBtn().addActionListener(this);
        this.view.getTableBtn().addActionListener(this);
        this.view.setVisible(true);
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
        case "liga1":
            liga1 = true;
            liga2 = false;
            liga3 = false;
            break;
        case "liga2":
            liga1 = false;
            liga2 = true;
            liga3 = false;
            break;
        case "liga3":
            liga1 = false;
            liga2 = false;
            liga3 = true;
            break;
        case "table":
            table=true;
            spielplan = false;
            clubs = false;
            break;
        case "plan":
            table=false;
            spielplan = true;
            clubs = false;
            break;
        case "clubs":
            table=false;
            spielplan = false;
            clubs = true;
            break;
        }
        renderView();
        
    }
    private void renderView(){
        if(liga1){
            this.view.getLiga1Btn().setBackground(Color.white);
        }
        else{
            this.view.getLiga1Btn().setBackground(Color.lightGray);
        }
        if(liga2){
            this.view.getLiga2Btn().setBackground(Color.white);
        }
        else{
            this.view.getLiga2Btn().setBackground(Color.lightGray);
        }
        if(liga3){
            this.view.getLiga3Btn().setBackground(Color.white);
        }
        else{
            this.view.getLiga3Btn().setBackground(Color.lightGray);
        }
        if(table){
            this.view.getTableBtn().setBackground(Color.white);
        }
        else{
            this.view.getTableBtn().setBackground(Color.lightGray);
        }
        if(spielplan){
            this.view.getPlanBtn().setBackground(Color.white);
            
        }else{
            this.view.getPlanBtn().setBackground(Color.lightGray);
        }
        if(clubs){
            this.view.getClubsBtn().setBackground(Color.white);
        }else{
            this.view.getClubsBtn().setBackground(Color.lightGray);
        }
    }
    
}

