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
import view.PlanViewTemp;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(PlanController.class.getName());

    private PlanView view;
    private JFrame master;
    private Liga liga;
    private List<JButton> listButtons;
    private List<Game> unfinishedGames;

    public PlanController(JFrame master, PlanView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
        this.view.getCreateGames().addActionListener(this);
        this.view.getSetResult().addActionListener(this);
        this.view.getRestartSeasonBtn().addActionListener(this);
        this.listButtons = new ArrayList();
        this.unfinishedGames = new ArrayList();
        getDataAndAdaptView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "addSpiel") {
            // LOGGER.log(Level.INFO, "Plan Controller angekommen");
            PlanAddGameView pagV = new PlanAddGameView(master, true);
            PlanAddGameController pagC = new PlanAddGameController(master, pagV, liga);
            pagV.setVisible(true);
        } 
        else if (e.getActionCommand()=="addSpielAuto"){
            System.out.println("SPielplan wird automatisch erstellt");
            //TODO Spielplan automatisch erstellen und Liga Model aktualiseiren
            
        }
        else if(e.getActionCommand()=="setResultAuto"){
            System.out.println("Spielergebnisse werden automatisch erstellt");
            //TO Do Ergebnisse für vorhandene Spiele autoamtisch setzen und Liga Modell aktualisieren
        }
        else if (e.getActionCommand()=="restartSeason"){
            System.out.println("Restart Season");
            // TO DO Tabelle mit den Spielen komplett löschen und alles andere auch
        }
        else {
            ErgebnisInputView ergV = new ErgebnisInputView(master, true);
            JButton temp = (JButton) e.getSource();
            int count = 0;
            for (JButton jB : listButtons) {
                if (temp == jB) {
                    count = listButtons.indexOf(jB);
                    break;
                }
            }
            Game g = unfinishedGames.get(count);
            // Hier nochmal schleuife durchfgehen
            ErgebnisInputController ergC = new ErgebnisInputController(ergV, g, liga);
            ergV.setVisible(true);
        }
    }

    private void getDataAndAdaptView() {
        int counter = 0;
        // TODO: gelöschte Clubs ? --> wie finden wir die raus

        for (Game g : this.liga.getGames()) {

            this.view.getPlanContent().setLayout(new BoxLayout(view.getPlanContent(), BoxLayout.Y_AXIS));

            if (g.isFinished() == false) {
                JLabel test = new JLabel();
                String day = String.valueOf(g.getStart().getDayOfMonth());
                String mounth = String.valueOf(g.getStart().getMonthValue());
                String year = String.valueOf(g.getStart().getYear());
                String hour = String.valueOf(g.getStart().getHour());
                String minute = String.valueOf(g.getStart().getMinute());
                String labelText = day + "." + mounth + "." + year + " um " + hour + ":" + minute + " Uhr ";
                test.setText(labelText);
                JButton testBtn = new JButton();
                String labelButton = g.getClub1().getName() + " - " + g.getClub2().getName();
                testBtn.setText(labelButton);
                test.setBackground(java.awt.Color.lightGray);
                test.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setActionCommand(String.valueOf(counter));

                // testBtn.setActionCommand(String.valueOf(i) + "RB Leipzig");
                // testBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
                // action(evt);
                // });
                testBtn.addActionListener(this);
                
                view.getPlanContent().add(test);
                view.getPlanContent().add(testBtn);
                view.getPlanContent().setVisible(true);
                view.getPlanContent().repaint();
                view.getPlanContent().revalidate();
                this.listButtons.add(testBtn);
                this.unfinishedGames.add(g);
            }

        }
    }
    // Alternatuve Lösung: PlanController implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

}
