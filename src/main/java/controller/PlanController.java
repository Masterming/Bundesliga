package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.logging.*;
import model.Liga;

import view.PlanAddGameView;
import view.PlanView;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(PlanController.class.getName());

    private PlanView view;
    private JFrame master;
    private Liga liga;

    public PlanController(JFrame master, PlanView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
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
                LOGGER.log(Level.INFO, "Plan Controller angekommen");
                PlanAddGameView pagV = new PlanAddGameView(master, true);
                PlanAddGameController pagC = new PlanAddGameController(master, pagV, liga);
                pagV.setVisible(true);
                break;
        }
    }
    // Alternatuve Lösung: PlanController implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

}
