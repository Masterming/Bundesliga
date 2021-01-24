/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import model.Liga;
import model.LigaDBMapper;
import model.PlanModel;
import view.ClubView;
import view.MainView;
import view.MainView;
import view.PlanView;
import view.PlanViewNeu;
import view.TableView;

/**
 *
 * @author z003ywys
 */
public class MainController implements ActionListener {
    

    private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());
    
    private MainView view;
    private Liga ligaModel;
    // Es wird 3 Ligen Model geben jeweils eins pro Liga --> werden beim ersten
    // Klick auf LigaButtons gesetzt
    private Liga liga1Model;
    private Liga liga2Model;
    private Liga liga3Model;
    private LigaDBMapper dao;

    public void setView(MainView view) {
        this.view = view;
    }
    // Variable fuer angezeigtesn View
    // Variable fuer jeweils genutzten Controller

    boolean liga1 = false;
    boolean liga2 = false;
    boolean liga3 = false;
    boolean table = false;
    boolean spielplan = false;
    boolean clubs = false;

    public MainController(MainView view) {
        this.view = view;
        //this.ligaModel = ligaModel;
        this.view.getLiga1Btn().addActionListener(this);
        this.view.getLiga2Btn().addActionListener(this);
        this.view.getLiga3Btn().addActionListener(this);
        this.view.getClubsBtn().addActionListener(this);
        this.view.getPlanBtn().addActionListener(this);
        this.view.getTableBtn().addActionListener(this);
        this.view.setVisible(true);
        LOGGER.log(Level.INFO, "Adding Ligas");
        this.dao = new LigaDBMapper();
        this.liga1Model = this.dao.getLiga(1);
        this.liga2Model = this.dao.getLiga(2);
        this.liga3Model = this.dao.getLiga(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "liga1":
                liga1 = true;
                liga2 = false;
                liga3 = false;
                break;
            case "liga2":
                liga1 = false;
                liga2 = true;
                liga3 = false;
                break;
            case "liga3":
                liga1 = false;
                liga2 = false;
                liga3 = true;
                break;
            case "table":
                table = true;
                spielplan = false;
                clubs = false;
                break;
            case "plan":
                table = false;
                spielplan = true;
                clubs = false;
                break;
            case "clubs":
                table = false;
                spielplan = false;
                clubs = true;
                break;
        }
        renderView();

    }

    private void renderView() {
        if (liga1) {
            this.view.getLiga1Btn().setBackground(Color.white);
            // Datenkontext anpassen --> Model
            this.ligaModel = this.liga1Model;

        } else {
            this.view.getLiga1Btn().setBackground(Color.lightGray);
        }
        if (liga2) {
            this.view.getLiga2Btn().setBackground(Color.white);
            this.ligaModel = this.liga2Model;
            // Datenkontext anpassen --> Model
        } else {
            this.view.getLiga2Btn().setBackground(Color.lightGray);
        }
        if (liga3) {
            this.view.getLiga3Btn().setBackground(Color.white);
            this.ligaModel = this.liga3Model;
            // Datenkontext anpassen --> Model
        } else {
            this.view.getLiga3Btn().setBackground(Color.lightGray);
        }
        if (table) {
            this.view.getTableBtn().setBackground(Color.white);
            // Aktiv die anzeige anpassen
            // this.view.setContentView(new TableView());
            this.view.getContentView().removeAll();
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();
            TableController tbc;
            TableView tb1;

            tb1 = new TableView();
            this.view.getContentView().add(tb1);
            tbc = new TableController(tb1, this.ligaModel);
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();

        } else {
            this.view.getTableBtn().setBackground(Color.lightGray);

        }
        if (spielplan) {
            this.view.getPlanBtn().setBackground(Color.white);
            this.view.getContentView().removeAll();
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();

            // Plan View erstellen
            // Plan Controller erstellen
            PlanViewNeu plv = new PlanViewNeu(this.view);
            PlanModel plm = new PlanModel();

            PlanController plc = new PlanController(plv, plm, this.view);
            plm.setlM(this.ligaModel);
            // Ding Soll Scrollable sein
            JScrollPane scroll = new JScrollPane(plv);
            this.view.getContentView().add(scroll);
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();

        } else {
            this.view.getPlanBtn().setBackground(Color.lightGray);

        }
        if (clubs) {
            this.view.getClubsBtn().setBackground(Color.white);
            this.view.getContentView().removeAll();
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();

            ClubView clV = new ClubView(this.view);
            ClubController cCl = new ClubController(clV, this.ligaModel, this.view);
            this.view.getContentView().add(clV);
            this.view.getContentView().repaint();
            this.view.getContentView().revalidate();

        } else {
            this.view.getClubsBtn().setBackground(Color.lightGray);

        }
    }

}
