package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.AncestorListener;
import model.Club;
import model.Liga;
import view.ClubView;

/**
 * @author Rene
 */
public class ClubController implements MouseListener {
    private Club model;
    private ClubView view;
    private Liga l;

    public ClubController(Club model, ClubView view) {
        this.model = model;
        this.view = view;
    }
    public ClubController(ClubView view, Liga l){
        this.view=view;
        this.l = l;
        this.view.getClubTable().addMouseListener(this);
    }
    public void updateView() {
        view.printOverview(model);
    }

    public void addPlayer(String player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(evt.getClickCount()==2){
            System.out.println("Tabelle wurde 2 mal geklcikt im ClubController");
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
