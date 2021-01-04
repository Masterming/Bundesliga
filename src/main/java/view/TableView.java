/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author z003ywys
 */
public class TableView extends javax.swing.JPanel {
    JLabel test1;
    JButton jButton1;
    private  void initComponents() {
        test1 = new javax.swing.JLabel();
        jButton1= new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 255, 51));
        setPreferredSize(new java.awt.Dimension(0, 261));
        setRequestFocusEnabled(false);

        test1.setText("Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(test1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(test1)
                    .addComponent(jButton1))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        
        jButton1.setText("TestAction Table neu");
        jButton1.setActionCommand("test");
        jButton1.getAccessibleContext().setAccessibleName("testBtn");
    }

    public TableView() {
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
    

    public JLabel getTest1() {
        return test1;
    }

    public void setTest1(String name) {
        String a = this.test1.getText();
        this.test1.setText(a + " " +name);
    }

    public JButton getjButton1() {
        return jButton1;
    }
    
    
    
}
