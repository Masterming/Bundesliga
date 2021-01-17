/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author z003ywys
 */
public class ClubAddView extends javax.swing.JDialog {

    public ClubAddView(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clubNameTxt = new javax.swing.JTextField();
        clubStadionTxt = new javax.swing.JTextField();
        clubAddBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 250));
        // setPreferredSize(new java.awt.Dimension(204, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Club Hinzufuegen");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 184, 33));

        jLabel2.setText("Clubname");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 55, 30));

        jLabel3.setText("Stadion");
        jLabel3.setPreferredSize(new java.awt.Dimension(46, 13));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 55, 28));
        getContentPane().add(clubNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 50, 130, 30));
        getContentPane().add(clubStadionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 87, 130, 30));

        clubAddBtn.setText("Club Hinzufuegen");
        clubAddBtn.setActionCommand("clubAdd");
        getContentPane().add(clubAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 190, -1));

        pack();
    }// </editor-fold>

    private javax.swing.JButton clubAddBtn;
    private javax.swing.JTextField clubNameTxt;
    private javax.swing.JTextField clubStadionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;

    public JTextField getClubNameTxt() {
        return clubNameTxt;
    }

    public JTextField getClubStadionTxt() {
        return clubStadionTxt;
    }

    public JButton getClubAddBtn() {
        return clubAddBtn;
    }

}
