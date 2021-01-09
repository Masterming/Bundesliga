/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import view.TransView;

/**
 *
 * @author z003ywys
 */
public class TransController implements ActionListener, MouseListener {
    private TransView trV;
    private String selectedTeam;
    private DefaultListModel listModelUrsprung;
    private DefaultListModel listModelSend;

    public TransController(TransView trV) {
        this.trV = trV;
        this.trV.getAddToTransBtn().addActionListener(this);
        this.trV.getRemoveFromTransBtn().addActionListener(this);
        this.trV.getSuchenBtn().addActionListener(this);
        this.trV.getTransFinishBtn().addActionListener(this);
        this.trV.getErgListTeam().addMouseListener(this);
        listModelUrsprung = new DefaultListModel();
        this.trV.getListEigenerKader().setModel(listModelUrsprung);
        listModelSend =  new DefaultListModel();
        this.trV.getListeTransKader().setModel(listModelSend);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String command = evt.getActionCommand();
        switch(command){
            case "suchen":
                System.out.println("suchen");
                suchen();
                break;
            case "trans_finish":
                System.out.println("trans_finish");
                transFinish();
                break;
            case "add":
                System.out.println("add");
                add();
                break;
            case "rem":
                System.out.println("rem");
                remove();
                break;
        }
    }
    
    private void suchen(){
        this.trV.getErgListTeam().removeAll();
        String suchAnfrage = this.trV.getReceivingTeamInput().getText();
        //Such ergebnisse als Liste o.Ä. engezigt bekommen
        DefaultListModel listModel = new DefaultListModel();
        this.trV.getErgListTeam().setModel(listModel);
        listModel.addElement(suchAnfrage);

        
        this.trV.repaint();
        this.trV.revalidate();
    }
    
    private void add(){
        String eigenerK = this.trV.getListEigenerKader().getSelectedValue();
        
        listModelUrsprung.removeElement(eigenerK);
        
       
        listModelSend.addElement(eigenerK);
        
        this.trV.repaint();
        this.trV.revalidate();
        
    }
    
    private void remove(){
        String eigenerK = this.trV.getListeTransKader().getSelectedValue();
        
        listModelSend.removeElement(eigenerK);
        
       
        listModelUrsprung.addElement(eigenerK);
        
        this.trV.repaint();
        this.trV.revalidate();
    }
    
    private void transFinish(){
        int best = JOptionPane.showConfirmDialog(null, "Wollen Sie die Transaktion abschließen");
        if(best ==0){
            System.out.println("True");
            List<String>transferPlayer = new ArrayList();
        for(int i=0; i<listModelSend.getSize();i++){
            transferPlayer.add(listModelSend.getElementAt(i).toString());
        }
        //Transaktion mit den Spielern passieren 
        System.out.println("trans Finish");
        for(String st : transferPlayer){
            System.out.println(st);
        }
            
        }
        else{
            System.out.println("False");
        }
        
        
        

        
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if(evt.getClickCount()==1){
            System.out.println("Item in Liste geklickt");
            selectedTeam = this.trV.getErgListTeam().getSelectedValue();
            this.trV.setReceiveTeamLbl(selectedTeam);
            listModelUrsprung.removeAllElements();
            listModelSend.removeAllElements();
            
            
            //Eigenen Kader Anpassen
            listModelUrsprung.addElement("Item 1");
            listModelUrsprung.addElement("Item 2");
            
            
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
