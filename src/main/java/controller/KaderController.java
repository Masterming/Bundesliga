/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.table.DefaultTableModel;
import view.KaderView;

/**
 *
 * @author z003ywys
 */
public class KaderController {
    private KaderView kdV;
    private String team;

    public KaderController(KaderView kdV, String team) {
        this.kdV = kdV;
        this.team = team;
        this.setTableData();
    }
    private void setTableData(){
        DefaultTableModel tbm = (DefaultTableModel)this.kdV.getPlayerTable().getModel();
        String [][] data = getData();
        for(String[] d : data){
             tbm.addRow(d);
        }
       
        this.kdV.setPlayerTableContent(tbm);
    }
    private String[][] getData(){
        //daten holen 
        String[][] data = new String[0][]; 
        data = new String[2][];
        String temp [] = new String[2];
        temp[0] = "Thomas Müller";
        temp[1] = "1123";
        data[0]=temp;
        
        temp=new String[2];
        temp[0] = "Max Mustermann";
        temp[1] = "900";
        data[1] = temp;
        return data;
    }
    
}
