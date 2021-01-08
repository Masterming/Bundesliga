/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author z003ywys
 */
public class TableView extends javax.swing.JPanel {
    JScrollPane  jScrollPane1;
    JTable table;
    JLabel jLabel1;
    private  void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
        };
        jLabel1 = new javax.swing.JLabel();

        //ggf. extra Tabellen Modell als extra Klasse erstellen erstellen in dem man Eigenschaften wie Editable relaisiert 
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Platz", "Team", "Spiele", "Punkte", "Siege", "Unentschieden", "Niederlagen", "Torverhältnisse"
            }
                
        )     
        );
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setAutoCreateRowSorter(true);
        Color backGround = new Color(240,240,240);
        this.setBackground(backGround);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );
        
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTable1() {
        return table;
    }

    public void setjTable1(JTable jTable1) {
        this.table = jTable1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(String liga) {
        this.jLabel1.setText(liga);
    }
    
    public void setTableContent (TableModel tbm){
        this.table.setModel(tbm);
    }
    

    public TableView() {
        initComponents();
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }
    
    
    
}
