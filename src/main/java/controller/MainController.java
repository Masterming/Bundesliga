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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

import model.Liga;
import model.LigaDBMapper;
import model.PlanModel;
import view.ClubView;
import view.MainView;
import view.PlanViewNeu;
import view.TableView;

/**
 *
 * @author z003ywys
 */
public class MainController implements ActionListener, Observer {

    private final static Logger LOGGER = Logger.getLogger(MainController.class.getName());

    // Es wird 3 Ligen Model geben jeweils eins pro Liga
    // --> werden beim ersten klick auf LigaButtons gesetzt
    private Map<Integer, Liga> ligas;
    private LigaDBMapper dao;

    private MainView view;
    private ClubView clV;
    private int ligaId = 1;
    private int selection = 1;

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

    public void setView(MainView view) {
        this.view = view;
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

    private void renderView() {
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

        switch (selection) {
            case 1:
                view.getTableBtn().setBackground(Color.white);
                // Aktiv die anzeige anpassen
                // view.setContentView(new TableView());
                view.getContentView().removeAll();
                TableController tbc;
                TableView tb1;

                tb1 = new TableView();
                view.getContentView().add(tb1);
                tbc = new TableController(tb1, ligas.get(ligaId));
                break;
            case 2:
                view.getPlanBtn().setBackground(Color.white);
                view.getContentView().removeAll();

                // Plan View erstellen
                // Plan Controller erstellen
                PlanViewNeu plv = new PlanViewNeu(view);
                PlanModel plm = new PlanModel();

                PlanController plc = new PlanController(plv, plm, view);
                plm.setlM(ligas.get(ligaId));
                // Ding Soll Scrollable sein
                JScrollPane scroll = new JScrollPane(plv);
                view.getContentView().add(scroll);
                break;
            case 3:
                view.getClubsBtn().setBackground(Color.white);
                view.getContentView().removeAll();

                clV = new ClubView(view);
                ClubController cCl = new ClubController(clV, ligas.get(ligaId), view);
                view.getContentView().add(clV);
                break;
        }
        view.getContentView().repaint();
        view.getContentView().revalidate();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("Main Controller benachrichtigt");
        if (arg0 instanceof Liga) {
            Liga temp = (Liga) arg0;
            dao.updateLiga(temp);
            ligas.put(temp.getId(), temp);

            renderView();
            clV.repaint();
            clV.revalidate();
        }
    }
}
