/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.PlanModel;
import view.PlanAddGameView;
import view.PlanView;
import view.PlanViewNeu;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {
    private PlanModel plm;
    private PlanViewNeu plv;
    private JFrame mainView;

    public PlanController(PlanViewNeu plx, PlanModel plmx, JFrame main) {
        this.plm = plmx;
        this.plv = plx;
        this.mainView = main;
        this.plm.addObserver(this.plv);
        this.plv.getAddSpielBtn().addActionListener(this);
        // this.plv.getjButton1().addActionListener(this);
        // Problem: Durch MVC- Beobahcter Pattern wird View erst durch die Veränderung
        // des Models initialisert -->
        // zum Zeitpunkt der Controller erstellung ist nicht bekannt welche Buttons es
        // geben wird --> Kann keine Action verlinkt werden
        // this.setUpPlanView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "addSpiel":
                System.out.println("Plan Controller angekommen");
                PlanAddGameView pagV = new PlanAddGameView(this.mainView, true);
                PlanAddGameController pagC = new PlanAddGameController(this.mainView, pagV, this.plm, this.plm.getlM());
                pagV.setVisible(true);
                break;
        }
    }

}
