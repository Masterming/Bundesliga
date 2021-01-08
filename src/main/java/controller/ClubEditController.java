/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ClubEditView;

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
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Button wurde gedrückt");
        if(evt.getActionCommand()=="kader"){
            System.out.println("Kader");
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
            //Neuen Content festlegen
        }
        if(evt.getActionCommand()=="trans"){
            System.out.println("Trans");
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
        }
    }
}
