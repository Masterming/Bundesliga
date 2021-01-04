/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        this.tableView.getjButton1().addActionListener(this);
        this.l = l;
        this.tableView.setTest1(l.getName());
    }
    @Override public void actionPerformed (ActionEvent ae){
        switch(ae.getActionCommand()){
            case "test":
                System.out.println("Table Controller Button/ Aktion erfolgreich");
                System.out.println("Gezeigte Liga: " + this.l.getName());
                break;
        }
    }
    
    
    
  

    
    
    
}
