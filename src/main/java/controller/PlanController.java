/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.JFrame;

import model.PlanModel;
import view.PlanAddGameView;
import view.PlanView;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {

    private PlanModel plm;
    private PlanView plv;
    private JFrame master;

    public PlanController(JFrame master, PlanView plx, PlanModel plmx) {
        this.plm = plmx;
        this.plv = plx;
        this.master = master;
        this.plm.addObserver(this.plv);
        this.plv.getAddSpielBtn().addActionListener(this);
        // this.plv.getjButton1().addActionListener(this);
        // Problem: Durch MVC- Beobahcter Pattern wird View erst durch die Veraenderung
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
                PlanAddGameView pagV = new PlanAddGameView(this.master, true);
                PlanAddGameController pagC = new PlanAddGameController(this.master, pagV, this.plm, this.plm.getLiga());
                pagV.setVisible(true);
                break;
        }
    }
    // Alternatuve Lösung: PlanController implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

}
