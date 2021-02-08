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
public class PlanModel extends Observable implements Serializable {

    private static final long serialVersionUID = 4L;

    // die Liaga als Model dient als Grundlage fuer die Erstellung des PlanModels
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int planModelID;
    private Liga liga;
    private int test;

    public PlanModel() {
        this.planModelID = -1;
    }

    // private String[][]
    public PlanModel(Liga liga) {
        this.planModelID = -1;
        this.liga = liga;
        setChanged();
    }
    // DatenStruktur ueberlegen --> Aus DB holen

    public void setLiga(Liga liga) {
        this.liga = liga;
        // Holt sich Liste mit Gameobjekten die muessen durchsortiert werden
        // GameTabelle: alles Games von allen Ligen zukunft und vergangenheit
        // Spiel noch nicht gespielt:boolean = false
        setChanged();
        notifyObservers(liga);
    }

    public Liga getLiga() {
        return liga;
    }

    public void setTest(int test) {
        this.test = test;
        setChanged();
        notifyObservers(liga);
    }

    public int getTest() {
        return test;
    }

    public int getPlanModelID() {
        return planModelID;
    }
}
