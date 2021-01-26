/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.*;

import view.ClubEditView;
import view.KaderView;
import view.SpielerAddView;
import view.TransactionView;

/**
 *
 * @author z003ywys
 */
public class ClubEditController implements ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ClubEditController.class.getName());
    private ClubEditView cev;
    private String team;

    public ClubEditController(ClubEditView CeV, String team) {
        this.cev = CeV;
        this.cev.setClubName(team);
        this.team = team;
        this.cev.getKaderBtn().addActionListener(this);
        this.cev.getTransBtn().addActionListener(this);
        this.cev.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        LOGGER.log(Level.INFO, "Button wurde gedrueckt");
        if (evt.getActionCommand() == "kader") {
            this.cev.getKaderBtn().setBackground(Color.white);
            this.cev.getTransBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.lightGray);
            // this.cev.getClubName().setText("Button Kader wurde geklickt");
            LOGGER.log(Level.INFO, "Kader");
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();

            KaderView kdw2 = new KaderView();
            KaderController kDc = new KaderController(kdw2, team);
            this.cev.getClubEditContent().add(kdw2);
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();

        }
        if (evt.getActionCommand() == "trans") {
            LOGGER.log(Level.INFO, "Trans");
            this.cev.getTransBtn().setBackground(Color.white);
            this.cev.getKaderBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.lightGray);
            TransactionView tranView = new TransactionView();
            TransactionController tr = new TransactionController(tranView);
            // Layout setzen ?
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().add(tranView);
            LOGGER.log(Level.INFO, "Content hizugefuegt");
            this.cev.getClubEditContent().repaint();
            LOGGER.log(Level.INFO, "Repaint()");
            this.cev.getClubEditContent().revalidate();
            LOGGER.log(Level.INFO, "Revalidate()");

        }
        if (evt.getActionCommand() == "spieler") {
            LOGGER.log(Level.INFO, "Spieler");
            this.cev.getTransBtn().setBackground(Color.lightGray);
            this.cev.getKaderBtn().setBackground(Color.lightGray);
            this.cev.getAddSpielerBtn().setBackground(Color.white);
            this.cev.getClubEditContent().removeAll();
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
            SpielerAddView spV = new SpielerAddView();
            SpielerAddController spAC = new SpielerAddController(spV);
            this.cev.getClubEditContent().add(spV);
            this.cev.getClubEditContent().repaint();
            this.cev.getClubEditContent().revalidate();
        }
    }
}
