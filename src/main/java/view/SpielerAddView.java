/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author z003ywys
 */
public class SpielerAddView extends javax.swing.JPanel  {

    public SpielerAddView() {
        initComponents();
    }
    private void initComponents(){
       jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        playerNameTxt = new javax.swing.JTextField();
        anzToreTxt = new javax.swing.JTextField();
        addSpielerBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 450));

        jLabel1.setText("Name                ");

        jLabel2.setText("Bisherige Toranzahl");

        playerNameTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        playerNameTxt.setPreferredSize(new java.awt.Dimension(127, 19));

        anzToreTxt.setMargin(new java.awt.Insets(0, 0, 0, 0));
        anzToreTxt.setMinimumSize(new java.awt.Dimension(3, 15));
        anzToreTxt.setPreferredSize(new java.awt.Dimension(127, 19));

        addSpielerBtn.setText("Spieler hinzufügen");
        addSpielerBtn.setActionCommand("addSpieler");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addSpielerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anzToreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(playerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(anzToreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(addSpielerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }

    public JButton getAddSpielerBtn() {
        return addSpielerBtn;
    }

    public JTextField getAnzToreTxt() {
        return anzToreTxt;
    }

    public JTextField getPlayerNameTxt() {
        return playerNameTxt;
    }
    private javax.swing.JButton addSpielerBtn;
    private javax.swing.JTextField anzToreTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField playerNameTxt;
    
    
}
