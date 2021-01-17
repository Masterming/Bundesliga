/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author z003ywys
 */
public class ClubAddExistingView extends javax.swing.JDialog {
    public ClubAddExistingView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        selectedLiga = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ligaClubList = new javax.swing.JList<>();
        toAddClubLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adClubToLigaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        selectedLiga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Liga 1", "Liga 2", "Liga 3" }));

        ligaClubList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Leipzig", "Bayern", "Hamburg" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(ligaClubList);

        jLabel2.setText("Der hinzuzufügende Club:");

        adClubToLigaBtn.setText("Club zur Liga hinzufügen");
        adClubToLigaBtn.setActionCommand("clubAddLiga");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectedLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(toAddClubLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 135,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(adClubToLigaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 260,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addComponent(selectedLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(toAddClubLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18).addComponent(adClubToLigaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE)));

        pack();
    }

    private javax.swing.JButton adClubToLigaBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> ligaClubList;
    private javax.swing.JComboBox<String> selectedLiga;
    private javax.swing.JLabel toAddClubLbl;

    public JButton getAdClubToLigaBtn() {
        return adClubToLigaBtn;
    }

    public JList<String> getLigaClubList() {
        return ligaClubList;
    }

    public JComboBox<String> getSelectedLiga() {
        return selectedLiga;
    }

    public JLabel getToAddClubLbl() {
        return toAddClubLbl;
    }

    public void setLigaComboModel(DefaultComboBoxModel dCM) {
        this.selectedLiga.setModel(dCM);
    }

}
