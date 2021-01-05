/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;

/**
 *
 * @author z003ywys
 */
public class PlanModel extends Observable {
    //die Liaga als Model dient als Grundlage für die Erstellung des PlanModels
    private Liga lM;
    private int test;
    public PlanModel() {
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
    
    

    
    
}
