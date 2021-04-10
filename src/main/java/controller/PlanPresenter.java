package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
 * @author z003ywys
 */
public class PlanPresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(PlanPresenter.class.getName());
    private PlanView view;
    private JFrame master;
    private Liga liga;
    private List<JButton> listButtons;
    private List<Game> unfinishedGames;

    public PlanPresenter(JFrame master, PlanView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getAddSpielBtn().addActionListener(this);
        this.view.getCreateGames().addActionListener(this);
        this.view.getSetResult().addActionListener(this);
        this.view.getRestartSeasonBtn().addActionListener(this);
        this.view.getGameHistory().addActionListener(this);
        this.listButtons = new ArrayList<>();
        this.unfinishedGames = new ArrayList<>();
        getDataAndAdaptView();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case "addGame":
            LOGGER.log(Level.INFO, "Spiel hinzufuegen");
            PlanAddGameView pagV = new PlanAddGameView(master, true);
            PlanAddGamePresenter pagC = new PlanAddGamePresenter(master, pagV, liga);
            pagV.setVisible(true);
            break;
        case "addGameAuto":
            LOGGER.log(Level.INFO, "Spielplan wird automatisch erstellt");
            // TODO Spielplan automatisch erstellen und Liga Model aktualiseiren
            break;
        case "setResultAuto":
            LOGGER.log(Level.INFO, "Spielergebnisse werden automatisch erstellt");
            // Tordurchschnitt Bundesliga zwischen 2.5 & 3.5
            Random rand = new Random();
            for (Game game : liga.getGames()) {
                if (!game.isFinished()) {
                    int goals = rand.nextInt(6);
                    int clubScore[] = { 0, 0 };
                    for (int i = 0; i < goals; i++) {
                        int det = rand.nextInt(2);
                        clubScore[det]++;
                        game.getClub(det).addPlayerGoals(rand.nextInt(game.getClub(det).getSize()), 1);
                    }
                    game.setResults(clubScore[0], clubScore[1]);
                }
            }
            liga.updateGames(liga.getGames());
            break;
        case "restartSeason":
            LOGGER.log(Level.INFO, "Restart Season");
            // TODO Saison-Daten zurücksetzen (Spieler mit Toranzahl und Teams bleiben,
            // alles andere geht)
            for (Liga l : MainPresenter.getLigas().values()) {
                l.reset();
            }
            break;
        case "gamesHistory":
            System.out.println("Game History");
            this.view.getPlanContent().removeAll();
            GameHistoryView gh = new GameHistoryView();
            GameHistoryPresenter ghC = new GameHistoryPresenter(liga, gh, this);
            // gh.getBackToPlanBtn().addActionListener(this);
            this.view.getPlanContent().add(gh);
            this.view.getPlanContent().setVisible(true);
            this.view.getPlanContent().repaint();
            this.view.getPlanContent().revalidate();
            // TODO Spieldaten aus der DB holen

            break;
        default:
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
            // Hier nochmal schleuife durchgehen
            ErgebnisInputPresenter ergC = new ErgebnisInputPresenter(master, ergV, g, liga);
            ergV.setVisible(true);
            break;
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
                String labelText = day + "." + mounth + "." + year + " um "
                        + String.format("%02d", Integer.parseInt(hour)) + ":"
                        + String.format("%02d", Integer.parseInt(minute)) + " Uhr ";
                test.setText(labelText);
                JButton testBtn = new JButton();
                String labelButton = g.getClub(0).getName() + " - " + g.getClub(1).getName();
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
    // Alternatuve Lösung: PlanPresenter implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

    public void restorePlanView() {
        getDataAndAdaptView();
    }

}
