/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Liga;
import model.PlanModel;
import view.ErgebnisInputView;

/**
 *
 * @author z003ywys
 */
public class ErgebnisInputController implements ActionListener {

    private ErgebnisInputView ergDialog;
    private PlanModel plm;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = this.ergDialog.getErg1().getText();
        String b = this.ergDialog.getErg2().getText();
        int ergA=-1;
        int ergB=-1;
        boolean inputOk = true;
        try{
            ergA = Integer.parseInt(a);
            ergB = Integer.parseInt(b);
        }
        catch (Exception ex){
            System.out.println("Es wurden keine ganzen Zahlen einegeben");
            JFrame f=new JFrame();  
            JOptionPane.showMessageDialog(f,"Es wurden keine ganzen Zahlen einegeben! Bitte Versucen sie es erneut");  
            inputOk = false;
        }
        System.out.println(ergA + " " + ergB);
        
        //Speichern in der DB erfolgen
        //Updaten des Models --> dafür Muss Model von Observable Eextenden 
        if(inputOk){
        this.plm.setlM(new Liga("Test"));
        this.ergDialog.dispose();
        }
    }

    public ErgebnisInputController(ErgebnisInputView ergDialog, String teamA, String teamB, PlanModel plmEx) {
        this.ergDialog = ergDialog;
        this.ergDialog.setTeamALbl(teamA);
        this.ergDialog.setTeamBLbl(teamB);
        this.plm = plmEx;
        this.ergDialog.getSaveBtn().addActionListener(this);
    }
    
    
    
}
