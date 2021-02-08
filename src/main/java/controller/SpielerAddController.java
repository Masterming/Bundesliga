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
    private SpielerAddView view;
    private Club club;
    private Liga liga;

    public SpielerAddController(SpielerAddView view, Club club, Liga liga) {
        this.view = view;
        this.liga = liga;
        this.club = club;
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
        String anzTorStr = view.getAnzToreTxt().getText();
        int anzTor = -1;
        boolean inputOk = true;
        try {
            anzTor = Integer.parseInt(anzTorStr);
        } catch (NumberFormatException ex) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Es wurden keine ganzen Zahlen eingeben! Bitte versuchen Sie es erneut");
            LOGGER.log(Level.WARNING, "Es wurden keine ganzen Zahlen eingeben");
            inputOk = false;
        }
        if (inputOk) {
            LOGGER.log(Level.INFO, "Spieler hinzugefuegt");
            Player P = new Player(name, anzTor);
            club.addPlayer(P);
            liga.updateClub(club);
        }
    }

}
