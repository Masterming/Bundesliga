/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import model.Club;
import model.Liga;
import view.TableView;

/**
 *
 * @author z003ywys
 */
public class TableController implements ActionListener {

    private TableView tableView;
    private Liga l;

    public TableController(TableView tbv, Liga l) {
        this.tableView = tbv;
        // this.tableView.getjButton1().addActionListener(this);
        this.l = l;
        // this.tableView.setjLabel1(l.getName());
        this.setTableData();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "test":
                System.out.println("Table Controller Button/ Aktion erfolgreich");
                System.out.println("Gezeigte Liga: " + this.l.getName());
                break;
        }
    }

    private void setTableData() {
        // Neues TableModel erstellen je nach Liga
        // Aufrufen der SetTableContentMethode der Tabelle
        DefaultTableModel tbm = (DefaultTableModel) this.tableView.getjTable1().getModel();

        // Bekomme list mit CLub Objkete mit Daten
        // Sample Data
        String[][] data = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        this.tableView.setTableContent(tbm);
    }

    private String[][] getData() {
        // TODO Daten Holen
        String[][] data = new String[l.getClubs().size()][];
        int count = 0;

        for (Club c : l.getClubs()) {
            String[] temp = new String[8];
            temp[0] = "1";
            temp[1] = c.getName();
            temp[2] = String.valueOf(c.getGamesCount());
            temp[3] = String.valueOf(c.getPoints());
            temp[4] = String.valueOf(c.getWins());
            temp[5] = String.valueOf(c.getDraw());
            temp[6] = String.valueOf(c.getLosses());
            temp[7] = String.valueOf(c.getMadeGoals()) + " : " + String.valueOf(c.getReceivedGoals());
            data[count] = temp;
            count++;
        }
        return data;
    }

}
