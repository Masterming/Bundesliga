package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import java.util.logging.*;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Game;
import model.Liga;
import view.ErgebnisInputView;
import view.GameHistory;
import view.GameHistoryView;

import view.PlanAddGameView;
import view.PlanView;
import view.PlanViewTemp;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(PlanController.class.getName());

    private PlanViewTemp view;
    private JFrame master;
    private Liga liga;
    private List<JButton> listButtons;
    private List<Game> unfinishedGames;

    public PlanController(JFrame master, PlanViewTemp view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
        this.view.getCreateGames().addActionListener(this);
        this.view.getSetResult().addActionListener(this);
        this.view.getRestartSeasonBtn().addActionListener(this);
        this.view.getGameHistory().addActionListener(this);
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
            Random rand = new Random();
            for(Game g : liga.getGames()){
                //Tordurchschnitt Bundesliga zwischen 2,5 und 3,5.
                int goals = rand.nextInt(6);
                for (int i = 0; i < goals; i++){
                    int det = rand.nextInt(2);
                    switch(det){
                        case 1:
                            g.increaseScore1();
                            g.getClub1().getPlayers().get(rand.nextInt(g.getClub1().getPlayers().size())).increaseGoals();
                        case 2:
                            g.increaseScore2();
                            g.getClub2().getPlayers().get(rand.nextInt(g.getClub2().getPlayers().size())).increaseGoals();
                        default:
                    }
                }
                g.setFinished(true);
            }
            //TODO Liga Modell aktualisieren
        }
        else if (e.getActionCommand()=="restartSeason"){
            System.out.println("Restart Season");
            //TODO Saison-Daten zurücksetzen (Spieler mit Toranzahl und Teams bleiben, alles andere geht)
             for (Liga l : MainController.getLigas().values()) {
                    l.reset();
             }
        }
        else if (e.getActionCommand()=="gamesHistory"){
            System.out.println("Game History");
            this.view.getPlanContent().removeAll();
            GameHistoryView gh = new GameHistoryView();
            GameHistoryController ghC = new GameHistoryController(liga,gh, this);
            //gh.getBackToPlanBtn().addActionListener(this);
            this.view.getPlanContent().add(gh);
            this.view.getPlanContent().setVisible(true);
            this.view.getPlanContent().repaint();
            this.view.getPlanContent().revalidate();
            //TODO Spieldaten aus der DB holen
            
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
        this.view.getPlanContent().setLayout(new BoxLayout(view.getPlanContent(), BoxLayout.Y_AXIS));
        this.view.getPlanContent().removeAll();
        for (Game g : this.liga.getGames()) {

            this.view.getPlanContent().setLayout(new BoxLayout(view.getPlanContent(), BoxLayout.Y_AXIS));

            if (g.isFinished() == false) {
                JLabel test = new JLabel();
                String day = String.valueOf(g.getStart().getDayOfMonth());
                String mounth = String.valueOf(g.getStart().getMonthValue());
                String year = String.valueOf(g.getStart().getYear());
                String hour = String.valueOf(g.getStart().getHour());
                String minute = String.valueOf(g.getStart().getMinute());
                String labelText = day + "." + mounth + "." + year + " um " + String.format("%02d", Integer.parseInt(hour)) + ":" + String.format("%02d", Integer.parseInt(minute)) + " Uhr ";
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
    
    public void restorePlanView(){
        getDataAndAdaptView();
    }

}
