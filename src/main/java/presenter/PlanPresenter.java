package presenter;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Club;
import model.Game;
import model.Liga;
import view.ErgebnisInputView;
import view.GameHistoryView;
import view.PlanAddGameView;
import view.PlanView;

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
            int numOfClubs = (liga.getId() > 2 ? 20 : 18);
            if (liga.getClubs().size() != numOfClubs) {
                JOptionPane.showMessageDialog(master, "Falsche anzahl an Teams: "
                        + String.valueOf(liga.getClubs().size()) + " != " + String.valueOf(numOfClubs));
                LOGGER.log(Level.INFO, ("Falsche anzahl an Teams: " + String.valueOf(liga.getClubs().size()) + " != "
                        + String.valueOf(numOfClubs)));
                break;
            }
            boolean success = true;
            for (int i = 0; i < numOfClubs; i++) {
                Club c1 = liga.getClubs().get(i);
                Club c2;
                for (int j = 0; j < numOfClubs; j++) {
                    if (i != j) {
                        c2 = liga.getClubs().get(j);
                        Game newGame = new Game(c1, c2, LocalDateTime.now(), liga, liga);
                        if (liga.updateGame(newGame)) {
                            // LOGGER.log(Level.INFO, "Setup of {0} successful", newGame);
                            // LOGGER.log(Level.INFO, "Spiel wurde erfolgreich erstellt und gesichert!");
                        } else {
                            LOGGER.log(Level.INFO, ("Generating Game: " + c1.getName() + " vs " + c2.getName()));
                            LOGGER.log(Level.SEVERE, "Spiel existiert bereits oder wurde schon gespielt!");
                            success = false;
                        }
                    }
                }
            }
            if (!success)
                JOptionPane.showMessageDialog(master,
                        "Ein oder mehrere Spiele existieren bereits, oder wurden schon gespielt!");
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
            for (Liga l : MainPresenter.getLigas().values()) {
                l.reset();
            }
            break;
        case "gamesHistory":
            this.view.getPlanContent().removeAll();
            GameHistoryView gh = new GameHistoryView();
            GameHistoryPresenter ghC = new GameHistoryPresenter(liga, gh, this);
            // gh.getBackToPlanBtn().addActionListener(this);
            this.view.getPlanContent().add(gh);
            this.view.getPlanContent().setVisible(true);
            this.view.getPlanContent().repaint();
            this.view.getPlanContent().revalidate();
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
            // Hier nochmal schleife durchgehen
            ErgebnisInputPresenter ergC = new ErgebnisInputPresenter(master, ergV, g, liga);
            ergV.setVisible(true);
            break;
        }
    }

    private void getDataAndAdaptView() {
        int counter = 0;
        this.view.getPlanContent().setLayout(new BoxLayout(view.getPlanContent(), BoxLayout.Y_AXIS));
        this.view.getPlanContent().removeAll();
        for (Game g : this.liga.getGames()) {

            this.view.getPlanContent().setLayout(new BoxLayout(view.getPlanContent(), BoxLayout.Y_AXIS));

            if (g.isFinished() == false) {
                JLabel test = new JLabel();
                String day = String.valueOf(g.getStart().getDayOfMonth());
                String month = String.valueOf(g.getStart().getMonthValue());
                String year = String.valueOf(g.getStart().getYear());
                String hour = String.valueOf(g.getStart().getHour());
                String minute = String.valueOf(g.getStart().getMinute());
                String labelText = day + "." + month + "." + year + " um "
                        + String.format("%02d", Integer.parseInt(hour)) + ":"
                        + String.format("%02d", Integer.parseInt(minute)) + " Uhr ";
                test.setText(labelText);
                JButton testBtn = new JButton();
                String labelButton = g.getClub(0).getName() + " - " + g.getClub(1).getName();
                testBtn.setText(labelButton);
                test.setBackground(Color.lightGray);
                test.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setActionCommand(String.valueOf(counter));
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
    // Alternative Lösung: PlanPresenter implementiert Observer und wird
    // benachrichtigt wenn sich Model ändert und passt dann den View an

    public void restorePlanView() {
        getDataAndAdaptView();
    }

}
