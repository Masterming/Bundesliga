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
import javax.swing.JTextField;

/**
 *
 * @author z003ywys
 */
public class PlanAddGameView extends javax.swing.JDialog {
        /**
         *
         */
        private static final long serialVersionUID = 104L;

        public PlanAddGameView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateInputTxt = new javax.swing.JTextField();
        addSpielBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        teamALigaList = new javax.swing.JComboBox<>();
        teamBLigaList = new javax.swing.JComboBox<>();
        teamAList = new javax.swing.JComboBox<>();
        teamBList = new javax.swing.JComboBox<>();
        teamALbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        teamBLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Datum: ");

        jLabel1.setText("Team B:");

        jLabel3.setText("Liga");

        addSpielBtn.setText("Spiel Hinzufügen");
        addSpielBtn.setActionCommand("addGame");

        jLabel4.setText("Format: dd.MM.yyyy HH:mm");

        jLabel5.setText("Team A:");

        jLabel6.setText("Liga: ");

        teamALigaList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teamBLigaList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teamAList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teamBList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        teamALbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamALbl.setText("TeamA");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");

        teamBLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamBLbl.setText("TeamA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addContainerGap(53, Short.MAX_VALUE).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                        layout.createSequentialGroup()
                                                .addComponent(teamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(teamBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addSpielBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                                                                        jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(
                                                                        dateInputTxt,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup().addComponent(
                                                                jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(teamALigaList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup().addComponent(
                                                                jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(teamBLigaList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(33, 33, 33)
                                                        .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jLabel5))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(teamAList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(teamBList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(48, 48, 48)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(teamALigaList, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(teamBLigaList)))
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(teamAList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(teamBList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
                        .addComponent(teamBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(teamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateInputTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(addSpielBtn)
                .addGap(19, 19, 19)));

        pack();
    }

    private javax.swing.JButton addSpielBtn;
    private javax.swing.JTextField dateInputTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel teamALbl;
    private javax.swing.JComboBox<String> teamALigaList;
    private javax.swing.JComboBox<String> teamAList;
    private javax.swing.JLabel teamBLbl;
    private javax.swing.JComboBox<String> teamBLigaList;
    private javax.swing.JComboBox<String> teamBList;

    public JTextField getDateInputTxt() {
        return dateInputTxt;
    }

    public JButton getAddSpielBtn() {
        return addSpielBtn;
    }

    public JLabel getTeamALbl() {
        return teamALbl;
    }

    public JComboBox<String> getTeamALigaList() {
        return teamALigaList;
    }

    public JComboBox<String> getTeamAList() {
        return teamAList;
    }

    public JLabel getTeamBLbl() {
        return teamBLbl;
    }

    public JComboBox<String> getTeamBLigaList() {
        return teamBLigaList;
    }

    public JComboBox<String> getTeamBList() {
        return teamBList;
    }

    public void setTeamALigaList(DefaultComboBoxModel<String> teamALigaList) {
        this.teamALigaList.setModel(teamALigaList);
    }

    public void setTeamAList(DefaultComboBoxModel<String> teamAList) {
        this.teamAList.setModel(teamAList);
    }

    public void setTeamBLigaList(DefaultComboBoxModel<String> teamBLigaList) {
        this.teamBLigaList.setModel(teamBLigaList);
    }

    public void setTeamBList(DefaultComboBoxModel<String> teamBList) {
        this.teamBList.setModel(teamBList);
    }

    public void setTeamALbl(String teamALbl) {
        this.teamALbl.setText(teamALbl);
    }

    public void setTeamBLbl(String teamBLbl) {
        this.teamBLbl.setText(teamBLbl);
    }

}
