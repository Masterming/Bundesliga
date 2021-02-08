package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.*;

import model.Club;
import model.Liga;
import view.ClubAddView;

/**
 *
 * @author z003ywys
 */
public class ClubAddController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ClubAddController.class.getName());
    private JFrame master;
    private ClubAddView cAv;
    private Liga l;
    // private ClubDB

    public ClubAddController(JFrame master, ClubAddView cAv, Liga L) {
        this.master = master;
        this.cAv = cAv;
        this.cAv.getClubAddBtn().addActionListener(this);
        this.l = L;
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
        if (cAv.getClubNameTxt().getText() != null && cAv.getClubStadionTxt().getText() != null) {
            clubName = cAv.getClubNameTxt().getText().toString();
            stadion = cAv.getClubStadionTxt().getText().toString();
            clubName = clubName.trim();
            stadion = stadion.trim();
            if (clubName.length() > 0 && stadion.length() > 0) {
                eingabe = true;
            }
        }
        if (!eingabe) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Bitte geben sie etwas fuer Clubname und Stadion ein");
        } else {
            Club temp = new Club(clubName, stadion);
            l.addClub(temp);
            LOGGER.log(Level.INFO, "Club Hinzugefuegt: " + clubName);
            master.repaint();
            master.revalidate();
            cAv.dispose();

        }

    }

}
