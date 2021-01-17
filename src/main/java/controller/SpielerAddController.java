/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Club;
import model.Liga;
import view.SpielerAddView;

/**
 *
 * @author z003ywys
 */
public class SpielerAddController implements ActionListener {
    private SpielerAddView spAV;
    private Club club;

    public SpielerAddController(SpielerAddView spAV) {
        this.spAV = spAV;
        this.spAV.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "addSpieler":
                System.out.println("Spieler hinzugefuegt");
                addSpieler();
                break;
        }
    }

    private void addSpieler() {
        String name = this.spAV.getPlayerNameTxt().getText();
        String anzTorStr = this.spAV.getAnzToreTxt().getText();
        int anzTor = -1;
        boolean inputOk = true;
        try {
            anzTor = Integer.parseInt(anzTorStr);
        } catch (Exception ex) {
            System.out.println("Es wurden keine ganzen Zahlen einegeben");
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Es wurden keine ganzen Zahlen einegeben! Bitte Versucen sie es erneut");
            inputOk = false;
        }
        if (inputOk) {
            // TODO Spieler in DB Schreiben
        }
    }

}
