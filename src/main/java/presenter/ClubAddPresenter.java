package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Club;
import model.Liga;
import view.ClubAddView;

/**
 * @author z003ywys
 */
public class ClubAddPresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ClubAddPresenter.class.getName());
    private ClubAddView view;
    private JFrame master;
    private Liga liga;
    private Map<Integer,Liga>ligas;

    public ClubAddPresenter(JFrame master, ClubAddView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getClubAddBtn().addActionListener(this);
        this.ligas = MainPresenter.getLigas();
        
    }

    public ClubAddPresenter(JFrame master, ClubAddView view, Liga liga, List ligas) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        //this.ligas = ligas;
        this.ligas = MainPresenter.getLigas();
        this.view.getClubAddBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comm = evt.getActionCommand();
        switch (comm) {
            case "clubAdd":
                addClub();
                break;
        }
    }

    private void addClub() {
        boolean eingabe = false;
        String clubName = "";
        String stadion = "";
        if (view.getClubNameTxt().getText() != null && view.getClubStadionTxt().getText() != null) {
            clubName = view.getClubNameTxt().getText();
            stadion = view.getClubStadionTxt().getText();
            clubName = clubName.trim();
            stadion = stadion.trim();
            if (clubName.length() > 0 && stadion.length() > 0) {
                eingabe = true;
            }
        }
        if (!eingabe) {
            JOptionPane.showMessageDialog(master, "Bitte geben sie etwas fuer Clubname und Stadion ein");
        } else {
            Club temp = new Club(clubName, stadion);
            boolean clubExists = false;
            for (Liga l : ligas.values()) {
                for (Club c : l.getClubs()) {
                    if (c.getName().equals(clubName)) {
                        clubExists = true;
                        JOptionPane.showMessageDialog(master, "Club existiert bereits in der " + l.getName());
                        break;
                    }
                }
            }
            if (!clubExists) {
                liga.addClub(temp);
                JOptionPane.showMessageDialog(master, "Club wurde hinzugefügt");
            }
            LOGGER.log(Level.INFO, "Club Hinzugefuegt: {0}", clubName);
            master.repaint();
            master.revalidate();
            view.dispose();

        }
    }
}
