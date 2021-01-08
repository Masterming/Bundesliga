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

        kaderBtn.setText("Kader");
        kaderBtn.setActionCommand("kader");

        clubName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubName.setText("ClubName");

        transBtn.setText("Transaktion");
        transBtn.setToolTipText("");
        transBtn.setActionCommand("trans");

        javax.swing.GroupLayout clubEditContentLayout = new javax.swing.GroupLayout(clubEditContent);
        clubEditContent.setLayout(clubEditContentLayout);
        clubEditContentLayout.setHorizontalGroup(
            clubEditContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        clubEditContentLayout.setVerticalGroup(
            clubEditContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kaderBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transBtn))
                    .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(clubName)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kaderBtn)
                    .addComponent(transBtn))
                .addGap(18, 18, 18)
                .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
