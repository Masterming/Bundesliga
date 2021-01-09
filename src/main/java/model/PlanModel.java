/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author z003ywys
 */
@Entity
@Table(name = "planmodels")
public class PlanModel extends Observable implements Serializable{
    
    private static final long serialVersionUID = 5L;
    
    //die Liaga als Model dient als Grundlage für die Erstellung des PlanModels
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int planModelID;
    private Liga lM;
    private int test;
    //private String[][] 
    public PlanModel() {
        this.planModelID = -1;
        setChanged();        
    }
    //DatenStruktur überlegen --> Aus DB holen

    public void setlM(Liga lM) {
        this.lM = lM;
        //Holt sich Liste mit Gameobjekten die müssen durchsortiert werden
        //GameTabelle: alles Games von allen Ligen zukunft und vergangenheit
        //Spiel noch nicht gespielt:boolean = false
        setChanged();
        notifyObservers(lM);
    }

    public Liga getlM() {
        return lM;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
        setChanged();
        notifyObservers(lM);
    }

    public int getPlanModelID() {
        return planModelID;
    }    
}
