package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Rene
 */
public class ClubView extends JPanel {

    private static final long serialVersionUID = 8L;
    private javax.swing.JButton addClubBtn;
    private javax.swing.JButton addExistingClubBtn;
    private javax.swing.JTable clubTable;
    private javax.swing.JScrollPane jScrollPane1;
    private JFrame master;

    private void initComponents() {
        addClubBtn = new JButton();
        addExistingClubBtn = new JButton();
        jScrollPane1 = new JScrollPane();
        clubTable = new JTable();

        addClubBtn.setText("Neuen Club hinzufügen");
        addClubBtn.setActionCommand("addClub");

        addExistingClubBtn.setText("Vorhandenen Club hinzufügen");
        addExistingClubBtn.setActionCommand("addExistClub");

        clubTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Club", "stadion" }) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        clubTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(clubTable);
        clubTable.setRowSelectionAllowed(true);
        clubTable.setColumnSelectionAllowed(true);
        clubTable.setAutoCreateRowSorter(true);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup().addComponent(addClubBtn).addGap(18, 18, 18)
                                        .addComponent(addExistingClubBtn).addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addClubBtn).addComponent(addExistingClubBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addContainerGap()));
    }

    public JTable getClubTable() {
        return clubTable;
    }

    public void setTableContent(TableModel tbm) {
        this.clubTable.setModel(tbm);
    }

    public ClubView(JFrame master) {
        initComponents();
        this.master = master;
    }

    public JFrame getMaster() {
        return master;
    }

    public JButton getAddClubBtn() {
        return addClubBtn;
    }

    public JButton getAddExistingClubBtn() {
        return addExistingClubBtn;
    }
}
