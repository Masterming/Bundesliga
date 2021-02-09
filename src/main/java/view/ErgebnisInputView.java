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
import javax.swing.table.TableModel;

/**
 *
 * @author z003ywys
 */
public class ErgebnisInputView extends javax.swing.JDialog {

    private static final long serialVersionUID = 10L;

    public ErgebnisInputView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        clubBLbl = new javax.swing.JLabel();
        clubALbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubBPlayerList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        clubAPlayerList = new javax.swing.JList<>();
        clubBSubGoalForPlayer = new javax.swing.JButton();
        clubAAddGoalForPlayer = new javax.swing.JButton();
        clubBAddGoalForPlayer = new javax.swing.JButton();
        clubASubGoalForPlayer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        ergClubALbl = new javax.swing.JLabel() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        ergClubBLbl1 = new javax.swing.JLabel() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        saveBtn = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scoredPlayerClubB = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        scoredPlayerClubA = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        clubBLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubBLbl.setText("Club B");

        clubALbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubALbl.setText("Club A");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":");

        clubBPlayerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(clubBPlayerList);

        clubAPlayerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(clubAPlayerList);

        clubBSubGoalForPlayer.setText("-");
        clubBSubGoalForPlayer.setActionCommand("descoreClubB");

        clubAAddGoalForPlayer.setText("+");
        clubAAddGoalForPlayer.setActionCommand("scoreClubA");

        clubBAddGoalForPlayer.setText("+");
        clubBAddGoalForPlayer.setActionCommand("scoreClubB");

        clubASubGoalForPlayer.setText("-");
        clubASubGoalForPlayer.setActionCommand("descoreClubA");

        jLabel2.setText("Spielerliste:");

        jLabel3.setText("Spielerliste:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText(":");

        ergClubALbl.setText("0");

        ergClubBLbl1.setText("0");

        saveBtn.setText("Speichern");
        saveBtn.setActionCommand("save");

        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLbl.setText("Datum");

        scoredPlayerClubB.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Spieler", "Toranzahl" }));
        jScrollPane3.setViewportView(scoredPlayerClubB);

        scoredPlayerClubA.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "Spieler", "Toranzahl" }));
        jScrollPane4.setViewportView(scoredPlayerClubA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(233, 233, 233).addComponent(saveBtn,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(clubAAddGoalForPlayer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clubASubGoalForPlayer))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup().addComponent(clubBAddGoalForPlayer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clubBSubGoalForPlayer))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(jScrollPane3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup().addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addGap(284, 284, 284)
                                        .addComponent(ergClubALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        layout.createSequentialGroup().addContainerGap()
                                                .addComponent(clubALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 187,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33).addComponent(ergClubBLbl1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(113, 113, 113).addComponent(clubBLbl,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup().addGap(249, 249, 249).addComponent(dateLbl,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 13,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(clubBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(clubALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(clubBAddGoalForPlayer).addComponent(clubBSubGoalForPlayer))
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
                                                .addComponent(clubAAddGoalForPlayer)
                                                .addComponent(clubASubGoalForPlayer))
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
                                .addComponent(jLabel4).addComponent(ergClubALbl).addComponent(ergClubBLbl1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(saveBtn,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)));

        pack();

    }// </editor-fold>

    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel ergClubALbl;
    private javax.swing.JLabel ergClubBLbl1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable scoredPlayerClubA;
    private javax.swing.JTable scoredPlayerClubB;
    private javax.swing.JButton clubAAddGoalForPlayer;
    private javax.swing.JLabel clubALbl;
    private javax.swing.JList<String> clubAPlayerList;
    private javax.swing.JButton clubASubGoalForPlayer;
    private javax.swing.JButton clubBAddGoalForPlayer;
    private javax.swing.JLabel clubBLbl;
    private javax.swing.JList<String> clubBPlayerList;
    private javax.swing.JButton clubBSubGoalForPlayer;

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public void setClubALbl(String clubALbl) {
        this.clubALbl.setText(clubALbl);
    }

    public void setClubBLbl(String clubBLbl) {
        this.clubBLbl.setText(clubBLbl);
    }

    public JTable getScoredPlayerClubA() {
        return scoredPlayerClubA;
    }

    public void setScoredPlayerClubA(TableModel scoredPlayerClubA) {
        this.scoredPlayerClubA.setModel(scoredPlayerClubA);
    }

    public void setScoredPlayerClubB(TableModel scoredPlayerClubB) {
        this.scoredPlayerClubB.setModel(scoredPlayerClubB);
    }

    public JTable getScoredPlayerClubB() {
        return scoredPlayerClubB;
    }

    public JButton getClubAAddGoalForPlayer() {
        return clubAAddGoalForPlayer;
    }

    public JList<String> getClubAPlayerList() {
        return clubAPlayerList;
    }

    public JButton getClubASubGoalForPlayer() {
        return clubASubGoalForPlayer;
    }

    public JButton getClubBAddGoalForPlayer() {
        return clubBAddGoalForPlayer;
    }

    public JList<String> getClubBPlayerList() {
        return clubBPlayerList;
    }

    public JButton getClubBSubGoalForPlayer() {
        return clubBSubGoalForPlayer;
    }

    public void setClubAPlayerList(AbstractListModel<String> clubAPlayerList) {
        this.clubAPlayerList.setModel(clubAPlayerList);
    }

    public void setClubBPlayerList(AbstractListModel<String> clubBPlayerList) {
        this.clubBPlayerList.setModel(clubBPlayerList);
    }

    public void setErgClubALbl(String ergClubALbl) {
        this.ergClubALbl.setText(ergClubALbl);
    }

    public void setErgClubBLbl1(String ergClubBLbl1) {
        this.ergClubBLbl1.setText(ergClubBLbl1);
    }

    public void setDateLbl(String date) {
        this.dateLbl.setText(date);

    }

}
