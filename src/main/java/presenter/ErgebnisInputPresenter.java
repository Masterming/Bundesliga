package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Club;

import model.Game;
import model.Liga;
import model.Player;
import view.ErgebnisInputView;

/**
 * @author z003ywys
 */
public class ErgebnisInputPresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ErgebnisInputPresenter.class.getName());
    private ErgebnisInputView view;
    private JFrame master;
    private Liga liga;
    private Game game;
    private List<List<String>> scoreClubA;
    private List<List<String>> scoreClubB;
    int clubAScore;
    int clubBScore;

    public ErgebnisInputPresenter(JFrame master, ErgebnisInputView view, String clubA, String clubB) {
        this.view = view;
        this.master = master;
        this.view.setClubALbl(clubA);
        this.view.setClubBLbl(clubB);
        this.view.getSaveBtn().addActionListener(this);
        this.view.getClubAAddGoalForPlayer().addActionListener(this);
        this.view.getClubASubGoalForPlayer().addActionListener(this);
        this.view.getClubBAddGoalForPlayer().addActionListener(this);
        this.view.getClubBSubGoalForPlayer().addActionListener(this);
        scoreClubA = new ArrayList<>();
        scoreClubB = new ArrayList<>();
        getData();
        clubAScore = 0;
        clubBScore = 0;

    }

    public ErgebnisInputPresenter(JFrame master, ErgebnisInputView ergDialog, Game game, Liga l) {
        this.game = game;
        this.master = master;
        this.view = ergDialog;
        this.view.setClubALbl(game.getClub(0).getName());
        this.view.setClubBLbl(game.getClub(1).getName());

        String day = String.valueOf(game.getStart().getDayOfMonth());
        String mounth = String.valueOf(game.getStart().getMonthValue());
        String year = String.valueOf(game.getStart().getYear());
        String hour = String.valueOf(game.getStart().getHour());
        String minute = String.valueOf(game.getStart().getMinute());
        String labelText = day + "." + mounth + "." + year + " um " + hour + ":" + minute + " Uhr ";
        Club temp = game.getClub1();
        labelText += " im " + temp.getStadion();
        
        this.view.getDateLbl().setText(labelText);
        this.view.getDateLbl().setSize(this.view.getDateLbl().getPreferredSize());
        this.view.getDateLbl().repaint();
        this.view.getDateLbl().validate();
        this.view.getSaveBtn().addActionListener(this);
        this.view.getClubAAddGoalForPlayer().addActionListener(this);
        this.view.getClubASubGoalForPlayer().addActionListener(this);
        this.view.getClubBAddGoalForPlayer().addActionListener(this);
        this.view.getClubBSubGoalForPlayer().addActionListener(this);
        scoreClubA = new ArrayList<>();
        scoreClubB = new ArrayList<>();
        this.liga = l;
        getData();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // String a = ergDialog.getErg1().getText();
        // String b = ergDialog.getErg2().getText();
        String nameA = view.getClubAPlayerList().getSelectedValue();
        String nameB = view.getClubBPlayerList().getSelectedValue();
        switch (e.getActionCommand()) {
            case "scoreClubA":
                scoreClub(nameA, scoreClubA);
                break;
            case "descoreClubA":
                descoreClub(nameA, scoreClubA);
                break;
            case "scoreClubB":
                scoreClub(nameB, scoreClubB);
                break;
            case "descoreClubB":
                descoreClub(nameB, scoreClubB);
                break;
            case "save":
                LOGGER.log(Level.INFO, "save");
                save();
                break;
        }
        updateView();
    }

    private void getData() {
        // TODO daten aus DB holen
        List<Player> spielerClub1 = game.getClub(0).getPlayers();
        List<Player> spielerClub2 = game.getClub(1).getPlayers();
        DefaultListModel<String> listModelClubA = new DefaultListModel<>();
        for (Player p : spielerClub1) {
            listModelClubA.addElement(p.getName());
        }
        DefaultListModel<String> listModelClubB = new DefaultListModel<>();
        for (Player p : spielerClub2) {
            listModelClubB.addElement(p.getName());
        }
        view.setClubAPlayerList(listModelClubA);
        view.setClubBPlayerList(listModelClubB);
        view.repaint();
        view.revalidate();
    }

    private void scoreClub(String name, List<List<String>> dataSet) {
        int index = -1;
        boolean found = false;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i).contains(name)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            currentCount++;
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        } else {
            if (name != null) {
                List<String> temp = new ArrayList<>();
                temp.add(name);
                String countFin = String.valueOf(1);
                temp.add(countFin);
                dataSet.add(temp);
            }
        }

    }

    private void descoreClub(String name, List<List<String>> dataSet) {
        LOGGER.log(Level.INFO, "Descore Club A");
        int index = -1;
        boolean found = false;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.get(i).contains(name)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            String currentCountStr = dataSet.get(index).get(1);
            int currentCount = Integer.parseInt(currentCountStr);
            if (currentCount > 0) {
                currentCount--;
            }
            if (currentCount == 0) {
                // Aus der Liste Entfernen
            }
            String countFin = String.valueOf(currentCount);
            dataSet.get(index).set(1, countFin);
        }
    }

    private void updateView() {
        DefaultTableModel tbmA = (DefaultTableModel) view.getScoredPlayerClubA().getModel();

        for (int i = tbmA.getRowCount() - 1; i >= 0; i--) {
            tbmA.removeRow(i);
        }
        // Club A
        for (List<String> strName : scoreClubA) {

            if (!strName.get(1).equals("0")) {
                Object[] temp = strName.toArray();
                tbmA.addRow(temp);
            }
        }
        view.setScoredPlayerClubA(tbmA);

        DefaultTableModel tbmB = (DefaultTableModel) view.getScoredPlayerClubB().getModel();
        for (int i = tbmB.getRowCount() - 1; i >= 0; i--) {
            tbmB.removeRow(i);
        }
        for (List<String> strName : scoreClubB) {
            if (!strName.get(1).equals("0")) {
                Object[] temp = strName.toArray();
                tbmB.addRow(temp);
            }
        }
        view.setScoredPlayerClubB(tbmB);

        // Den spielstand aktualisieren
        clubAScore = getSpielStand(scoreClubA);
        clubBScore = getSpielStand(scoreClubB);
        view.setErgClubALbl(String.valueOf(clubAScore));
        view.setErgClubBLbl1(String.valueOf(clubBScore));
    }

    private int getSpielStand(List<List<String>> inPutData) {
        int erg = 0;
        for (int i = 0; i < inPutData.size(); i++) {
            for (int j = 1; j < inPutData.get(i).size(); j++) {
                String temp = inPutData.get(i).get(j);
                int tempErg = Integer.parseInt(temp);
                erg += tempErg;

            }
        }
        return erg;
    }

    private void save() {
        if (clubAScore == -1 || clubBScore == -1) {
            JOptionPane.showMessageDialog(master, "Bitte fuegen Sie Ergebnisse hinzu");
        } else {
            LOGGER.log(Level.INFO, "Spielstand: {0} zu {1}", new Object[] { clubAScore, clubBScore });

            // Score für clubs Setzen
            game.setResults(clubAScore, clubBScore);
            setPlayerGoals();
            liga.updateGame(game);
            view.dispose();
        }
    }

    private void setPlayerGoals() {
        for (List<String> l : scoreClubA) {
            String player = l.get(0);
            int goals = Integer.parseInt(l.get(1));

            game.getClub(0).addPlayerGoals(player, goals);
        }

        for (List<String> l : scoreClubB) {
            String player = l.get(0);
            int goals = Integer.parseInt(l.get(1));

            game.getClub(1).addPlayerGoals(player, goals);
        }
    }

}
