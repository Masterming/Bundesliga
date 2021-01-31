/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JScrollPane;
import java.util.logging.*;

import model.Liga;
import model.LigaDBMapper;
import model.PlanModel;
import view.ClubView;
import view.MainView;
import view.PlanView;
import view.TableView;

/**
 *
 * @author z003ywys
 */
public class MainController implements ActionListener, Observer {

    private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());

    // Es wird 3 Ligen Model geben jeweils eins pro Liga
    // --> werden beim ersten klick auf LigaButtons gesetzt
    private static Map<Integer, Liga> ligas;
    private static LigaDBMapper dao;

    private static MainView view;
    private static int ligaId = 1;
    private static int selection = 1;

    public MainController(MainView view) {
        LOGGER.log(Level.INFO, "Adding Ligas");
        dao = new LigaDBMapper();
        ligas = new HashMap<>();

        for (int i = 1; i <= 3; i++) {
            ligas.put(i, dao.getLiga(i));
            ligas.get(i).addObserver(this);
        }

        view.getLiga1Btn().addActionListener(this);
        view.getLiga2Btn().addActionListener(this);
        view.getLiga3Btn().addActionListener(this);
        view.getClubsBtn().addActionListener(this);
        view.getPlanBtn().addActionListener(this);
        view.getTableBtn().addActionListener(this);
        view.setVisible(true);
        this.view = view;
        renderView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "liga1":
                ligaId = 1;
                break;
            case "liga2":
                ligaId = 2;
                break;
            case "liga3":
                ligaId = 3;
                break;
            case "table":
                selection = 1;
                break;
            case "plan":
                selection = 2;
                break;
            case "clubs":
                selection = 3;
                break;
        }
        renderView();

    }

    private static void renderView() {
        view.getLiga1Btn().setBackground(Color.lightGray);
        view.getLiga2Btn().setBackground(Color.lightGray);
        view.getLiga3Btn().setBackground(Color.lightGray);
        view.getTableBtn().setBackground(Color.lightGray);
        view.getPlanBtn().setBackground(Color.lightGray);
        view.getClubsBtn().setBackground(Color.lightGray);

        switch (ligaId) {
            case 1:
                view.getLiga1Btn().setBackground(Color.white);
                break;
            case 2:
                view.getLiga2Btn().setBackground(Color.white);
                break;
            case 3:
                view.getLiga3Btn().setBackground(Color.white);
                break;
        }

        // Anzeige anpassen + Controller erstellen
        switch (selection) {
            case 1:
                TableView tv = new TableView();
                TableController tbc = new TableController(tv, ligas.get(ligaId));

                view.getTableBtn().setBackground(Color.white);
                view.getContentView().removeAll();
                view.getContentView().add(tv);
                break;
            case 2:
                PlanView plv = new PlanView(view);
                PlanModel plm = new PlanModel(ligas.get(ligaId));
                PlanController plc = new PlanController(view, plv, plm);
                JScrollPane scroll = new JScrollPane(plv);

                view.getPlanBtn().setBackground(Color.white);
                view.getContentView().removeAll();
                view.getContentView().add(scroll);
                break;
            case 3:
                ClubView cv = new ClubView(view);
                ClubController clc = new ClubController(view, cv, ligas.get(ligaId));

                view.getClubsBtn().setBackground(Color.white);
                view.getContentView().removeAll();
                view.getContentView().add(cv);
                break;
        }
        view.getContentView().repaint();
        view.getContentView().revalidate();
    }

    @Override
    public void update(Observable o, Object arg1) {
        if (o instanceof Liga) {
            Liga temp = (Liga) o;
            dao.updateLiga(temp);
            ligas.put(temp.getId(), temp);

            renderView();
        }
    }
    
    public static void reloadFromDB(){
        for (int i = 1; i <= 3; i++) {
            ligas.get(i).clone(dao.getLiga(i));
        }
        renderView();
    }
}
