package view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.logging.*;

/**
 * @author z003ywys
 */
public class TableView extends JPanel {

    private final static Logger LOGGER = Logger.getLogger(TableView.class.getName());
    private static final long serialVersionUID = 20L;
    JScrollPane jScrollPane1;
    JTable table;

    // JLabel jLabel1;
    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        table = new JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        // jLabel1 = new JLabel();

        // ggf. extra Tabellen Modell als extra Klasse erstellen erstellen in dem man
        // Eigenschaften wie Editable relaisiert
        table.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Platz", "Club",
            "Spiele", "Punkte", "Siege", "Unentschieden", "Niederlagen", "Torverhaeltnis"}
        ));
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        table.setAutoCreateRowSorter(true);
        Color backGround = new Color(240, 240, 240);
        this.setBackground(backGround);
        jScrollPane1.setViewportView(table);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addComponent(jScrollPane1,
                        GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));

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

    // public JLabel getjLabel1() {
    // return jLabel1;
    // }
    // public void setjLabel1(String liga) {
    // this.jLabel1.setText(liga);
    // }
    public void setTableContent(TableModel tbm) {
        this.table.setModel(tbm);
    }

    public TableView() {
        initComponents();
        try {

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException
                | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage());
            this.setVisible(true);
        }
    }

}
