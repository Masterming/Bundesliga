/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author z003ywys
 */
public class GameHistoryView extends JPanel {
    public GameHistoryView() {
        initComponents();
    }
     private void initComponents() {
       jScrollPane1 = new javax.swing.JScrollPane();
        historyTable = new javax.swing.JTable();
        backToPlanBtn = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(541, 350));
        setPreferredSize(new java.awt.Dimension(541, 350));

        historyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "Heimteam", "Tore Heim", "Tore Gast", "Gastteam", "Austragungsort"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(historyTable);

        backToPlanBtn.setText("Zurück zum Spielplan");
        backToPlanBtn.setActionCommand("backToPlan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backToPlanBtn)
                .addContainerGap(410, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backToPlanBtn)
                .addContainerGap())
        );
    }
    private javax.swing.JButton backToPlanBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable historyTable;// </editor-fold>   

    public JTable getHistoryTable() {
        return historyTable;
    }
        public JButton getBackToPlanBtn() {
        return backToPlanBtn;
    }
        public void setTableContent(TableModel tbm){
            this.historyTable.setModel(tbm);
        }
}
