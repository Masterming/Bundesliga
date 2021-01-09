/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author z003ywys
 */
public class ErgebnisInputView extends javax.swing.JDialog {
    private static final long serialVersionUID = 9L;
    public ErgebnisInputView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        erg1 = new javax.swing.JTextField();
        erg2 = new javax.swing.JTextField();
        dateLbl = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        teamALbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        teamBLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText(":");

        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setText("Datum");

        saveBtn.setText("Speichern");
        saveBtn.setActionCommand("save");


        teamALbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamALbl.setText("Team A");
        teamALbl.setName("teamALbl"); // NOI18N

        jLabel2.setText("-");

        teamBLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamBLbl.setText("Team B");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erg1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erg2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(teamBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamALbl)
                    .addComponent(jLabel2)
                    .addComponent(teamBLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(erg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn)
                .addContainerGap())
        );

        teamALbl.getAccessibleContext().setAccessibleName("teamA");

        pack();
    }// </editor-fold>    
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextField erg1;
    private javax.swing.JTextField erg2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel teamALbl;
    private javax.swing.JLabel teamBLbl;

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JTextField getErg1() {
        return erg1;
    }

    public JTextField getErg2() {
        return erg2;
    }

    public void setTeamALbl(String teamALbl) {
        this.teamALbl.setText(teamALbl);
    }

    public void setTeamBLbl(String teamBLbl) {
        this.teamBLbl.setText(teamBLbl);
    }

    
    
    
}
