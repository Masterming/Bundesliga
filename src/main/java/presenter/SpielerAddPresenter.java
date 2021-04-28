package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Club;
import model.Liga;
import model.Player;
import view.SpielerAddView;

/**
 * @author z003ywys
 */
public class SpielerAddPresenter implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(SpielerAddPresenter.class.getName());
    private SpielerAddView view;
    private JFrame master;
    private Liga liga;
    private Club club;
    private Map<Integer, Liga> ligas;

    public SpielerAddPresenter(JFrame master, SpielerAddView view, Club club, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.club = club;
        this.ligas = MainPresenter.getLigas();
        this.view.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
        case "addSpieler":
            addSpieler();
            break;
        }
    }

    private void addSpieler() {
        String name = view.getPlayerNameTxt().getText();
        name = name.trim();
        String anzTorStr = view.getAnzToreTxt().getText();
        anzTorStr = anzTorStr.trim();
        int anzTor = -1;
        boolean inputOk = true;
        if (name.isBlank() || name.isEmpty()) {
            inputOk = false;
            JOptionPane.showMessageDialog(master,
                    "Es wurden kein Name für den Spieler eingeben! Bitte versuchen Sie es erneut");
        }
        try {
            anzTor = Integer.parseInt(anzTorStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(master,
                    "Es wurden keine ganzen Zahlen eingeben! Bitte versuchen Sie es erneut");
            LOGGER.log(Level.WARNING, "Es wurden keine ganzen Zahlen eingeben");
            inputOk = false;
        }
        if (inputOk) {
            boolean addPlayerOk = true;
            LOGGER.log(Level.INFO, "Spieler hinzugefuegt");
            Player P = new Player(name, anzTor);
            boolean playerExists = false;
            Club existingClub = null;
            for (Liga l : ligas.values()) {
                for (Club c : l.getClubs()) {
                    for (Player pl : c.getPlayers()) {
                        if (pl.getName().equals(name)) {
                            playerExists = true;
                            existingClub = c;
                        }
                    }
                }
            }
            if (!playerExists) {
                addPlayerOk = club.addPlayer(P);
                if (addPlayerOk) {
                    JOptionPane.showMessageDialog(master, "Spieler wurde erfolgreich hinzugefügt");
                    this.view.getAnzToreTxt().setText("");
                    this.view.getPlayerNameTxt().setText("");
                    liga.updateClub(club);
                }
            } else {
                JOptionPane.showMessageDialog(master, "Spieler existiert bereits in " + existingClub.getName());
            }

        }
    }

}
