/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author z003ywys
 */
public class KaderView extends javax.swing.JPanel {
    private static final long serialVersionUID = 10L;
        public KaderView() {
        initComponents();
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable(){
        public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
        };

        playerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Spieler", "Tore",
            }
        ));
        jScrollPane1.setViewportView(playerTable);
        playerTable.setRowSelectionAllowed(false);
        playerTable.setColumnSelectionAllowed(false);
        playerTable.setAutoCreateRowSorter(true);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable playerTable;// </editor-fold>

    public void setPlayerTableContent(TableModel playerTable) {
        this.playerTable.setModel(playerTable);
    }

    public JTable getPlayerTable() {
        return playerTable;
    }
    
}