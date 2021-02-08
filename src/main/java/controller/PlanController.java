package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import java.util.logging.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Game;
import model.Liga;
import view.ErgebnisInputView;

import view.PlanAddGameView;
import view.PlanView;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(PlanController.class.getName());

    private PlanView plv;
    private JFrame master;
    private Liga lig;
    private List<JButton> listButtons;

    public PlanController(JFrame master, PlanView plx, Liga l) {
        this.plv = plx;
        this.master = master;
        this.lig = l;
        this.plv.getAddSpielBtn().addActionListener(this);
        this.listButtons = new ArrayList();
        // this.plv.getjButton1().addActionListener(this);
        // Problem: Durch MVC- Beobahcter Pattern wird View erst durch die Veraenderung
        // des Models initialisert -->
        // zum Zeitpunkt der Controller erstellung ist nicht bekannt welche Buttons es
        // geben wird --> Kann keine Action verlinkt werden
        // this.setUpPlanView();
        getDataAndAdaptView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "addSpiel"){
            LOGGER.log(Level.INFO, "Plan Controller angekommen");
                PlanAddGameView pagV = new PlanAddGameView(master, true);
                PlanAddGameController pagC = new PlanAddGameController(master, pagV, lig);
                pagV.setVisible(true);
        }
        else{
            ErgebnisInputView ergV = new ErgebnisInputView(master, true);
            JButton temp = (JButton) e.getSource();
            int count =0;
            for(JButton jB: listButtons){
                if(temp == jB){
                    count = listButtons.indexOf(jB);
                    break;
                }
            }
            Game g = this.lig.getGames().get(count);
            ErgebnisInputController ergC = new  ErgebnisInputController(ergV,g,lig);
            ergV.setVisible(true);
        }
    }
    
    private void getDataAndAdaptView(){
        int counter =0;
        for(Game g : this.lig.getGames()){
            this.plv.getPlanContent().setLayout(new BoxLayout(this.plv.getPlanContent(), BoxLayout.Y_AXIS));
            if(g.isFinished()==false){
                JLabel test = new JLabel();
                String labelText = g.getStart().toString();
                test.setText(labelText);
                JButton testBtn = new JButton();
                String labelButton = g.getClub1().getName() + " - "+ g.getClub2().getName();
                testBtn.setText(labelButton);
                test.setBackground(java.awt.Color.lightGray);
                test.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setActionCommand(String.valueOf(counter));
                
                
//                testBtn.setActionCommand(String.valueOf(i) + "RB Leipzig");
//                testBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
//                    action(evt);
//                });
                testBtn.addActionListener(this);
                this.plv.getPlanContent().add(test);
                this.plv.getPlanContent().add(testBtn);
                this.plv.getPlanContent().setVisible(true);
                this.plv.getPlanContent().repaint();
                this.plv.getPlanContent().revalidate();
                this.listButtons.add(testBtn);
            }
        }
    }
    // Alternatuve Lösung: PlanController implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

}
