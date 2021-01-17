/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
        String[][] data = new String[0][];
        if (this.l.getName() == "Liga 1") {
            data = new String[2][];
            String[] temp = new String[8];
            temp[0] = "1";
            temp[1] = "FC Bayern";
            temp[2] = "7";
            temp[3] = "18";
            temp[4] = "6";
            temp[5] = "0";
            temp[6] = "1";
            temp[7] = "27:11";

            data[0] = temp;
            temp = new String[8];
            temp[0] = "2";
            temp[1] = "RB Leipzig";
            temp[2] = "7";
            temp[3] = "16";
            temp[4] = "5";
            temp[5] = "1";
            temp[6] = "1";
            temp[7] = "15:11";
            data[1] = temp;
        }
        if (this.l.getName() == "Liga 2") {
            data = new String[1][];
            String[] temp = new String[8];
            temp[0] = "1";
            temp[1] = "Hamburger SV";
            temp[2] = "14";
            temp[3] = "29";
            temp[4] = "9";
            temp[5] = "2";
            temp[6] = "3";
            temp[7] = "30:18";
            data[0] = temp;
        }
        if (this.l.getName() == "Liga 3") {

        }
        return data;
    }

}
