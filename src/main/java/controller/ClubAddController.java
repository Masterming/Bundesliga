/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Club;
import model.Liga;
import view.ClubAddView;

/**
 *
 * @author z003ywys
 */
public class ClubAddController implements ActionListener {
    private JFrame master;
    private ClubAddView cAv;
    private Liga l;
    // private ClubDB

    public ClubAddController(JFrame master, ClubAddView cAv, Liga L) {
        this.master = master;
        this.cAv = cAv;
        this.cAv.getClubAddBtn().addActionListener(this);
        this.l = L;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch (comm) {
            case "clubAdd":
                System.out.println("Club Hinzugefuegt");
                addClub();
                break;
        }
    }

    private void addClub() {
        boolean eingabe = false;
        String clubName = "";
        String stadion = "";
        if (this.cAv.getClubNameTxt().getText() != null && this.cAv.getClubStadionTxt().getText() != null) {
            clubName = this.cAv.getClubNameTxt().getText().toString();
            stadion = this.cAv.getClubStadionTxt().getText().toString();
            clubName = clubName.trim();
            stadion = stadion.trim();
            if (clubName.length() > 0 && stadion.length() > 0) {
                eingabe = true;
            }
        }
        if (!eingabe) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bitte geben sie etwas fuer Clubname und Stadion erin");
        } else {
            // TODO Hinzufuegen zur DB
            Club temp = new Club(clubName, stadion);
            this.l.addClub(temp);
            System.out.println(stadion);
            System.out.println(clubName);
            this.master.repaint();
            this.master.revalidate();
            this.cAv.dispose();

        }

    }

}
