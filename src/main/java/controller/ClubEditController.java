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
import javax.swing.JFrame;
import model.Club;
import model.Liga;

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
    private Club club;
    private JFrame master;
    private Liga l;

    public ClubEditController(ClubEditView CeV, Club c, Liga l, JFrame master) {
        this.cev = CeV;
        this.cev.setClubName(c.getName());
        this.club=c;
        this.l=l;
        this.master=master;
        this.cev.getKaderBtn().addActionListener(this);
        this.cev.getTransBtn().addActionListener(this);
        this.cev.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        LOGGER.log(Level.INFO, "Button wurde gedrueckt");
        if (evt.getActionCommand() == "kader") {
            cev.getKaderBtn().setBackground(Color.white);
            cev.getTransBtn().setBackground(Color.lightGray);
            cev.getAddSpielerBtn().setBackground(Color.lightGray);
            // cev.getClubName().setText("Button Kader wurde geklickt");
            LOGGER.log(Level.INFO, "Kader");
            cev.getClubEditContent().removeAll();
            cev.getClubEditContent().repaint();
            cev.getClubEditContent().revalidate();

            KaderView kdw2 = new KaderView();
            KaderController kDc = new KaderController(kdw2, club, this.master,this.l);
            cev.getClubEditContent().add(kdw2);
            cev.getClubEditContent().repaint();
            cev.getClubEditContent().revalidate();

        }
        if (evt.getActionCommand() == "trans") {
            LOGGER.log(Level.INFO, "Trans");
            cev.getTransBtn().setBackground(Color.white);
            cev.getKaderBtn().setBackground(Color.lightGray);
            cev.getAddSpielerBtn().setBackground(Color.lightGray);
            TransactionView tranView = new TransactionView();
            TransactionController tr = new TransactionController(tranView);
            // Layout setzen ?
            cev.getClubEditContent().removeAll();
            cev.getClubEditContent().add(tranView);
            LOGGER.log(Level.INFO, "Content hizugefuegt");
            cev.getClubEditContent().repaint();
            LOGGER.log(Level.INFO, "Repaint()");
            cev.getClubEditContent().revalidate();
            LOGGER.log(Level.INFO, "Revalidate()");

        }
        if (evt.getActionCommand() == "spieler") {
            LOGGER.log(Level.INFO, "Spieler");
            cev.getTransBtn().setBackground(Color.lightGray);
            cev.getKaderBtn().setBackground(Color.lightGray);
            cev.getAddSpielerBtn().setBackground(Color.white);
            cev.getClubEditContent().removeAll();
            cev.getClubEditContent().repaint();
            cev.getClubEditContent().revalidate();
            SpielerAddView spV = new SpielerAddView();
            SpielerAddController spAC = new SpielerAddController(spV);
            cev.getClubEditContent().add(spV);
            cev.getClubEditContent().repaint();
            cev.getClubEditContent().revalidate();
        }
    }
}
