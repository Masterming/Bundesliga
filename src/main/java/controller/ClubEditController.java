/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import view.ClubEditView;
import view.KaderView;
import view.PlanView;
import view.SpielerAddView;
import view.TableView;
import view.TransactionView;

/**
 *
 * @author z003ywys
 */
public class ClubEditController implements ActionListener {
    private ClubEditView cev;
    private String team;
     
        public ClubEditController(ClubEditView CeV, String team) {
        this.cev=CeV;
        this.cev.setClubName(team);
        this.team = team;
        this.cev.getKaderBtn().addActionListener(this);
        this.cev.getTransBtn().addActionListener(this);
        this.cev.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Button wurde gedrückt");
        if(evt.getActionCommand()=="kader"){
            this.cev.getKaderBtn().setBackground(Color.white);
            this.cev.getTransBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.lightGray);
            //this.cev.getClubName().setText("Button Kader wurde geklickt");
            System.out.println("Kader");
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
            
            KaderView kdw2 = new KaderView();
            KaderController kDc = new KaderController(kdw2,team);
            this.cev.getClubEditContent().add(kdw2);
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
            
            
        }
        if(evt.getActionCommand()=="trans"){
            System.out.println("Trans");
            this.cev.getTransBtn().setBackground(Color.white);
            this.cev.getKaderBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.lightGray);
            TransactionView tranView = new TransactionView();
            TransactionController tr = new TransactionController (tranView);
            //Layout setzen ?
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().add(tranView);
            System.out.println("Content hizugefügt");
            this.cev.getClubEditContent().repaint();
            System.out.println("Repaint()");
            this.cev.getClubEditContent().revalidate();
            System.out.println("Revalidate()");

        }
        if(evt.getActionCommand()=="spieler"){
            System.out.println("Spieler");
            this.cev.getTransBtn().setBackground(Color.lightGray);
            this.cev.getKaderBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.white);
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
            SpielerAddView spV = new SpielerAddView();
            SpielerAddControler spAC = new SpielerAddControler(spV);
            this.cev.getClubEditContent().add(spV);
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
        }
    }
}
