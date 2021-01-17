/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

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
        teamBLbl = new javax.swing.JLabel();
        teamALbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamBPlayerList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        teamAPlayerList = new javax.swing.JList<>();
        teamBSubGoalForPlayer = new javax.swing.JButton();
        teamAAddGoalForPlayer = new javax.swing.JButton();
        teamBAddGoalForPlayer = new javax.swing.JButton();
        teamASubGoalForPlayer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ergTeamALbl = new javax.swing.JLabel();
        ergTeamBLbl1 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scoredPlayerTeamB = new javax.swing.JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        scoredPlayerTeamA = new javax.swing.JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        teamBLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamBLbl.setText("Team B");

        teamALbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teamALbl.setText("Team A");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":");

        teamBPlayerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3",
                    "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(teamBPlayerList);

        teamAPlayerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3",
                    "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(teamAPlayerList);

        teamBSubGoalForPlayer.setText("-");
        teamBSubGoalForPlayer.setActionCommand("descoreTeamB");

        teamAAddGoalForPlayer.setText("+");
        teamAAddGoalForPlayer.setActionCommand("scoreTeamA");

        teamBAddGoalForPlayer.setText("+");
        teamBAddGoalForPlayer.setActionCommand("scoreTeamB");

        teamASubGoalForPlayer.setText("-");
        teamASubGoalForPlayer.setActionCommand("descoreTeamA");

        jLabel2.setText("Kader:");

        jLabel3.setText("Kader:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(":");

        ergTeamALbl.setText("-1");

        ergTeamBLbl1.setText("-1");

        saveBtn.setText("Speichern");
        saveBtn.setActionCommand("save");

        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setText("Datum");

        scoredPlayerTeamB.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Spieler", "Toranzahl" }));
        jScrollPane3.setViewportView(scoredPlayerTeamB);

        scoredPlayerTeamA.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Spieler", "Toranzahl" }));
        jScrollPane4.setViewportView(scoredPlayerTeamA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(teamAAddGoalForPlayer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(teamASubGoalForPlayer))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(teamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup().addComponent(teamBAddGoalForPlayer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(teamBSubGoalForPlayer))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup().addGap(233, 233, 233).addComponent(saveBtn,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addGap(284, 284, 284)
                                .addComponent(ergTeamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33).addComponent(ergTeamBLbl1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup().addGap(306, 306, 306).addComponent(dateLbl,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(teamBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addComponent(dateLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(teamBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(teamALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(teamBAddGoalForPlayer).addComponent(teamBSubGoalForPlayer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(teamAAddGoalForPlayer)
                                                .addComponent(teamASubGoalForPlayer))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158,
                                                        Short.MAX_VALUE)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
                                                        Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4).addComponent(ergTeamALbl).addComponent(ergTeamBLbl1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(saveBtn,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)));

        pack();

    }// </editor-fold>

    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel ergTeamALbl;
    private javax.swing.JLabel ergTeamBLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable scoredPlayerTeamA;
    private javax.swing.JTable scoredPlayerTeamB;
    private javax.swing.JButton teamAAddGoalForPlayer;
    private javax.swing.JLabel teamALbl;
    private javax.swing.JList<String> teamAPlayerList;
    private javax.swing.JButton teamASubGoalForPlayer;
    private javax.swing.JButton teamBAddGoalForPlayer;
    private javax.swing.JLabel teamBLbl;
    private javax.swing.JList<String> teamBPlayerList;
    private javax.swing.JButton teamBSubGoalForPlayer;

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public void setTeamALbl(String teamALbl) {
        this.teamALbl.setText(teamALbl);
    }

    public void setTeamBLbl(String teamBLbl) {
        this.teamBLbl.setText(teamBLbl);
    }

    public JTable getScoredPlayerTeamA() {
        return scoredPlayerTeamA;
    }

    public void setScoredPlayerTeamA(TableModel scoredPlayerTeamA) {
        this.scoredPlayerTeamA.setModel(scoredPlayerTeamA);
    }

    public void setScoredPlayerTeamB(TableModel scoredPlayerTeamB) {
        this.scoredPlayerTeamB.setModel(scoredPlayerTeamB);
    }

    public JTable getScoredPlayerTeamB() {
        return scoredPlayerTeamB;
    }

    public JButton getTeamAAddGoalForPlayer() {
        return teamAAddGoalForPlayer;
    }

    public JList<String> getTeamAPlayerList() {
        return teamAPlayerList;
    }

    public JButton getTeamASubGoalForPlayer() {
        return teamASubGoalForPlayer;
    }

    public JButton getTeamBAddGoalForPlayer() {
        return teamBAddGoalForPlayer;
    }

    public JList<String> getTeamBPlayerList() {
        return teamBPlayerList;
    }

    public JButton getTeamBSubGoalForPlayer() {
        return teamBSubGoalForPlayer;
    }

    public void setTeamAPlayerList(AbstractListModel teamAPlayerList) {
        this.teamAPlayerList.setModel(teamAPlayerList);
    }

    public void setTeamBPlayerList(AbstractListModel teamBPlayerList) {
        this.teamBPlayerList.setModel(teamBPlayerList);
    }

    public void setErgTeamALbl(String ergTeamALbl) {
        this.ergTeamALbl.setText(ergTeamALbl);
    }

    public void setErgTeamBLbl1(String ergTeamBLbl1) {
        this.ergTeamBLbl1.setText(ergTeamBLbl1);
    }

}
