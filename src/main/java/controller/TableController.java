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
        //this.tableView.getjButton1().addActionListener(this);
        this.l = l;
        this.tableView.setjLabel1(l.getName());
        this.setTableData();
    }
    @Override public void actionPerformed (ActionEvent ae){
        switch(ae.getActionCommand()){
            case "test":
                System.out.println("Table Controller Button/ Aktion erfolgreich");
                System.out.println("Gezeigte Liga: " + this.l.getName());
                break;
        }
    }
    private void setTableData(){
        //Neues TableModel erstellen je nach Liga
        //Aufrufen der SetTableContentMethode der Tabelle 
        DefaultTableModel tbm = (DefaultTableModel)this.tableView.getjTable1().getModel();
        //Sample Data
        String [] data = new String[8];
        data[0] = "1";
        data [1] = "FC Bayern";
        data[2] = "7";
        data[3] = "18";
        data[4] = "6";
        data[5] = "0";
        data[6] ="1";
        data[7] = "27:11";
        tbm.addRow(data);
        this.tableView.setTableContent(tbm);
    }
    
    
    
  

    
    
    
}
