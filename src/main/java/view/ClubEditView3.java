/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author z003ywys
 */
public class ClubEditView3 extends javax.swing.JDialog {
    private static final long serialVersionUID = 6L;
    public ClubEditView3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private void initComponents(){
         jLabel1 = new javax.swing.JLabel();
        kaderBtn = new javax.swing.JButton();
        addSpielerBtn = new javax.swing.JButton();
        transBtn = new javax.swing.JButton();
        clubName = new javax.swing.JLabel();
        clubEditContent = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        kaderBtn.setText("Kader");
        kaderBtn.setActionCommand("kader");

        addSpielerBtn.setText("Spieler Hinzufügen");
        addSpielerBtn.setActionCommand("spieler");

        transBtn.setText("Transaktion");
        transBtn.setActionCommand("trans");

        clubName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubName.setText("Clubname");

        javax.swing.GroupLayout clubEditContentLayout = new javax.swing.GroupLayout(clubEditContent);
        clubEditContent.setLayout(clubEditContentLayout);
        clubEditContentLayout.setHorizontalGroup(
            clubEditContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        clubEditContentLayout.setVerticalGroup(
            clubEditContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clubName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addSpielerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addComponent(transBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kaderBtn)
                    .addComponent(addSpielerBtn)
                    .addComponent(transBtn))
                .addGap(18, 18, 18)
                .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    private javax.swing.JButton addSpielerBtn;
    private javax.swing.JPanel clubEditContent;
    private javax.swing.JLabel clubName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kaderBtn;
    private javax.swing.JButton transBtn;

    public JPanel getClubEditContent() {
        return clubEditContent;
    }
    public void setClubName(String clubName) {
        this.clubName.setText(clubName); 
    }

    public JButton getAddSpielerBtn() {
        return addSpielerBtn;
    }

    public JButton getKaderBtn() {
        return kaderBtn;
    }

    public JButton getTransBtn() {
        return transBtn;
    }
    
    
}
