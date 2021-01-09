/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author z003ywys
 */
public class ClubEditView extends javax.swing.JDialog  {
    public ClubEditView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private javax.swing.JPanel clubEditContent;
    private javax.swing.JLabel clubName;
    private javax.swing.JButton kaderBtn;
    private javax.swing.JButton transBtn;
    private void initComponents() {

      
          kaderBtn = new javax.swing.JButton();
        clubName = new javax.swing.JLabel();
        transBtn = new javax.swing.JButton();
        clubEditContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(472, 337));

        kaderBtn.setText("Kader");
        kaderBtn.setActionCommand("kader");

        clubName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubName.setText("ClubName");

        transBtn.setText("Transaktion");
        transBtn.setToolTipText("");
        transBtn.setActionCommand("trans");

        clubEditContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kaderBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                        .addComponent(transBtn)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(clubName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kaderBtn)
                    .addComponent(transBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                           
    public JLabel getClubName() {
        return this.clubName;
    }

    public JPanel getClubEditContent() {
        return clubEditContent;
    }

    public void setClubEditContent(JPanel clubEditContent) {
        this.clubEditContent = clubEditContent;
    }

    public void setClubName(String clubName) {
        this.clubName.setText(clubName); 
    }

    public JButton getKaderBtn() {
        return kaderBtn;
    }

    public JButton getTransBtn() {
        return transBtn;
    }
    
}
