package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import model.Game;
import model.Liga;
import view.GameHistoryView;

/**
 * @author z003ywys
 */
public class GameHistoryPresenter implements ActionListener {
    private Liga l;
    private GameHistoryView ghV;
    private PlanPresenter plC;

    public GameHistoryPresenter(Liga l, GameHistoryView ghV, PlanPresenter PLC) {
        this.l = l;
        this.ghV = ghV;
        this.ghV.getBackToPlanBtn().addActionListener(this);
        this.plC = PLC;
        getDataAndAdaptView();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String act = evt.getActionCommand();
        if (act == "backToPlan") {
            this.plC.restorePlanView();
        }
    }

    private void getDataAndAdaptView() {
        String[][] data = new String[l.getFinishCount()][];
        int count = 0;
        for (Game game : this.l.getGames()) {
            if (game.isFinished()) {
                String day = String.valueOf(game.getStart().getDayOfMonth());
                String month = String.valueOf(game.getStart().getMonthValue());
                String year = String.valueOf(game.getStart().getYear());
                String hour = String.valueOf(game.getStart().getHour());
                String minute = String.valueOf(game.getStart().getMinute());

                String heim = game.getClub(0).getName();
                String torHeim = String.valueOf(game.getScore(0));
                String gast = game.getClub(1).getName();
                String torGast = String.valueOf(game.getScore(1));
                String datum = day + "." + month + "." + year + " um " + hour + ":" + minute;
                String austragungsOrt = game.getClub(0).getStadion();
                String temp[] = new String[6];
                temp[0] = datum;
                temp[1] = heim;
                temp[2] = torHeim;
                temp[3] = torGast;
                temp[4] = gast;
                temp[5] = austragungsOrt;
                data[count] = temp;
                count++;
            }
        }

        if (l.getFinishCount() > 0) {
            DefaultTableModel tbm = (DefaultTableModel) ghV.getHistoryTable().getModel();
            for (String[] d : data) {
                tbm.addRow(d);
            }
        }
    }
}
