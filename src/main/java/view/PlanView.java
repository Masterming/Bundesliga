/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.PlanModel;

/**
 *
 * @author z003ywys
 */
public class PlanView extends JPanel implements Observer{
    
    @Override
    public void update(Observable o, Object arg1) {
        //Hier landet man wenn man im Model was verändert hat durch norifyObservers
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        if(o instanceof PlanModel){
            //To change body of generated methods, choose Tools | Templates.
            //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            //this.setLayout(layout);
            
            for(int i=0; i<10;i++){
            JLabel test = new JLabel(((PlanModel) o).getlM().getName());
            JButton testBtn = new JButton("TestBTN");
            test.setAlignmentX(Component.CENTER_ALIGNMENT);
            testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
            testBtn.setActionCommand(String.valueOf(i));
            testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action(evt);
            }
        });
            this.add(test);
            this.add(testBtn);
            }
            
            this.revalidate();
            this.repaint();
            this.setVisible(true);
           
            
    }
    }
    
    private void action (ActionEvent e){
        String a = e.getActionCommand();
        System.out.println("Das Action Command war: " + a);
        System.out.println("Button gesetzt durch model geklickt");
        //Neues Pop Up fenster
    }
    
    private void initComponents(){
        //Dynamisches Erstellen der View je nach Model machen
        
//        jLabel1 = new javax.swing.JLabel();
//        jButton1 = new javax.swing.JButton();
//        jLabel2 = new javax.swing.JLabel();
//
//        jLabel1.setText("jLabel1");
//
//        jButton1.setText("jButton1");
//        jButton1.setActionCommand("test");
//        
//        jLabel2.setText("jLabel2");
//
        //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        //this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(jLabel1)
//                .addGap(28, 28, 28)
//                .addComponent(jButton1)
//                .addGap(55, 55, 55)
//                .addComponent(jLabel2)
//                .addContainerGap(170, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(jLabel1)
//                    .addComponent(jButton1)
//                    .addComponent(jLabel2))
//                .addContainerGap(269, Short.MAX_VALUE))
//        );
        
    }

    
    

    public PlanView() {
        initComponents();
        
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }
    
    
}
