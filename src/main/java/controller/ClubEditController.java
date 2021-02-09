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
    private ClubEditView view;
    private Club club;
    private JFrame master;
    private Liga liga;

    public ClubEditController(ClubEditView view, Club club, Liga liga, JFrame master) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.club = club;
        this.view.setClubName(club.getName());
        this.view.getKaderBtn().addActionListener(this);
        this.view.getTransBtn().addActionListener(this);
        this.view.getAddSpielerBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // LOGGER.log(Level.INFO, "Button wurde gedrueckt");
        if ("kader".equals(evt.getActionCommand())) {
            view.getKaderBtn().setBackground(Color.white);
            view.getTransBtn().setBackground(Color.lightGray);
            view.getAddSpielerBtn().setBackground(Color.lightGray);
            // cev.getClubName().setText("Button Kader wurde geklickt");
            // LOGGER.log(Level.INFO, "Kader");
            view.getClubEditContent().removeAll();
            view.getClubEditContent().repaint();
            view.getClubEditContent().revalidate();

            KaderView kdw2 = new KaderView();
            KaderController kDc = new KaderController(kdw2, club, this.master, this.liga);
            view.getClubEditContent().add(kdw2);
            view.getClubEditContent().repaint();
            view.getClubEditContent().revalidate();

        }
        if ("trans".equals(evt.getActionCommand())) {
            LOGGER.log(Level.INFO, "Trans");
            view.getTransBtn().setBackground(Color.white);
            view.getKaderBtn().setBackground(Color.lightGray);
            view.getAddSpielerBtn().setBackground(Color.lightGray);
            TransactionView tranView = new TransactionView();
            TransactionController tr = new TransactionController(tranView, club);
            // Layout setzen ?
            view.getClubEditContent().removeAll();
            view.getClubEditContent().add(tranView);
            // LOGGER.log(Level.INFO, "Content hizugefuegt");
            view.getClubEditContent().repaint();
            // LOGGER.log(Level.INFO, "Repaint()");
            view.getClubEditContent().revalidate();
            // LOGGER.log(Level.INFO, "Revalidate()");

        }
        if ("spieler".equals(evt.getActionCommand())) {
            // LOGGER.log(Level.INFO, "Spieler");
            view.getTransBtn().setBackground(Color.lightGray);
            view.getKaderBtn().setBackground(Color.lightGray);
            view.getAddSpielerBtn().setBackground(Color.white);
            view.getClubEditContent().removeAll();
            view.getClubEditContent().repaint();
            view.getClubEditContent().revalidate();
            SpielerAddView spV = new SpielerAddView();
            SpielerAddController spAC = new SpielerAddController(spV, club, liga);
            view.getClubEditContent().add(spV);
            view.getClubEditContent().repaint();
            view.getClubEditContent().revalidate();
        }
    }
}
