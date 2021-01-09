package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javassist.bytecode.SignatureAttribute.ObjectType;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import model.Club;
import model.Liga;
import view.ClubEditView;
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
        this.setData();
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
            //Neues Fenster geht auf --> Neuen Controller + View
            JTable temp = (JTable)evt.getSource();
            int row = temp.getSelectedRow();
            int column = 0;
            String team =temp.getValueAt(row, column).toString();
            ClubEditView cbV = new ClubEditView(this.view.getMainView(),true);
            ClubEditController cbC = new ClubEditController(cbV, team);
            cbV.setVisible(true);
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
    
    private void setData(){
        DefaultTableModel tbm = (DefaultTableModel)this.view.getClubTable().getModel();
        String data[][] = getData();
                for(String[] d : data){
             tbm.addRow(d);
        }
       
        this.view.setTableContent(tbm);
    }
    private String[][] getData(){
        String[][] data = new String[0][]; 
        if(this.l.getName()=="Liga 1"){
            data = new String[2][];
            String [] temp = new String[8];
            temp [0] = "FC Bayern";
            temp[1] = "Alianz Arena";
            
            data[0] = temp;
            temp = new String[8];
            temp[0] = "RB Leipzig";
            temp [1] = "Red Bull Arena";
            data[1] = temp;
        }
        if(this.l.getName()=="Liga 2"){
            data = new String[1][];
            String [] temp = new String[8];
            temp[0] = "FC Erzgebirge Aue";
            temp [1] = "Erzgebirge Stadio";
            data[0] = temp;
        }
        if(this.l.getName()=="Liga 3"){
            
        }
        return data;
    }
}
