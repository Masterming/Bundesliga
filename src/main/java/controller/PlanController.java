/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import model.PlanModel;
import view.PlanView;

/**
 *
 * @author z003ywys
 */
public class PlanController implements ActionListener {
    private PlanModel plm;
    private PlanView plv;
    
   public PlanController(PlanView plx, PlanModel plmx){
       this.plm = plmx;
       this.plv = plx;
       this.plm.addObserver(this.plv);
       this.plv.getjButton1().addActionListener(this);
   }
   @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "test":
                this.plm.setTest(this.plm.getTest()+1);
                break;
        }
    }
    //private PlanView;
    //private PlanModel;
}
