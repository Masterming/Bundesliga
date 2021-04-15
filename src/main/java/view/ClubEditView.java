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
 * @author z003ywys
 */
public class ClubEditView extends javax.swing.JDialog {

    private static final long serialVersionUID = 7L;

    public ClubEditView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private javax.swing.JButton addSpielerBtn;
    private javax.swing.JPanel clubEditContent;
    private javax.swing.JLabel clubName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kaderBtn;
    private javax.swing.JButton transBtn;

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        kaderBtn = new javax.swing.JButton();
        addSpielerBtn = new javax.swing.JButton();
        transBtn = new javax.swing.JButton();
        clubName = new javax.swing.JLabel();
        clubEditContent = new javax.swing.JPanel();
        this.setTitle("Club");

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 450));

        kaderBtn.setText("Kader");
        kaderBtn.setActionCommand("kader");

        addSpielerBtn.setText("Spieler Hinzufuegen");
        addSpielerBtn.setActionCommand("spieler");

        transBtn.setText("Transaktion");
        transBtn.setActionCommand("trans");

        clubName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubName.setText("Clubname");
        clubEditContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout clubEditContentLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(clubEditContentLayout);

        clubEditContentLayout.setHorizontalGroup(clubEditContentLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        clubEditContentLayout.setVerticalGroup(clubEditContentLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 208, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup().addComponent(kaderBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clubName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(addSpielerBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(44, 44, 44).addComponent(transBtn)))
                .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(6, 6, 6)
                        .addComponent(clubName, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kaderBtn).addComponent(addSpielerBtn).addComponent(transBtn))
                        .addGap(18, 18, 18).addComponent(clubEditContent, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()));

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

    public JButton getAddSpielerBtn() {
        return addSpielerBtn;
    }

}
