package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.*;

import model.Club;
import model.Liga;
import model.Player;
import view.SpielerAddView;

/**
 * @author z003ywys
 */
public class SpielerAddController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(SpielerAddController.class.getName());
    private SpielerAddView spAV;
    private Club club;
    private Liga l;

    public SpielerAddController(SpielerAddView spAV, Club cl, Liga l) {
        this.spAV = spAV;
        this.spAV.getAddSpielerBtn().addActionListener(this);
        this.club = cl;
        this.l = l;
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
        String name = spAV.getPlayerNameTxt().getText();
        String anzTorStr = spAV.getAnzToreTxt().getText();
        int anzTor = -1;
        boolean inputOk = true;
        try {
            anzTor = Integer.parseInt(anzTorStr);
        } catch (Exception ex) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Es wurden keine ganzen Zahlen eingeben! Bitte versuchen Sie es erneut");
            LOGGER.log(Level.WARNING, "Es wurden keine ganzen Zahlen eingeben");
            inputOk = false;
        }
        if (inputOk) {
            LOGGER.log(Level.INFO, "Spieler hinzugefuegt");
            Player P = new Player(name, anzTor);
            club.addPlayer(P);
            l.updateClub(club);
        }
    }

}
