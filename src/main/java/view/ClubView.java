package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;


/**
 * @author Rene
 */
public class ClubView extends javax.swing.JPanel implements Observer{
    private static final long serialVersionUID = 8L;
    private javax.swing.JButton addClubBtn;
    private javax.swing.JButton addExistingClubBtn;
    private javax.swing.JTable clubTable;
    private javax.swing.JScrollPane jScrollPane1;
    private JFrame mainView; 

    
    private void initComponents(){
        addClubBtn = new javax.swing.JButton();
        addExistingClubBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubTable = new javax.swing.JTable();

        addClubBtn.setText("Neuen Club Hinzufügen");
        addClubBtn.setActionCommand("addClub");

        addExistingClubBtn.setText("Vorhandenen Club Hinzufügen");
        addExistingClubBtn.setActionCommand("addExistClub");

        clubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Club", "Stadion"
            }
        ) {

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
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addClubBtn)
                        .addGap(18, 18, 18)
                        .addComponent(addExistingClubBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addClubBtn)
                    .addComponent(addExistingClubBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
    }

    public JTable getClubTable() {
        return clubTable;
    }
    public void setTableContent (TableModel tbm){
        this.clubTable.setModel(tbm);
    }
    
    
    public ClubView(JFrame MainView){
        initComponents();
        this.mainView=MainView;
    }

    public JFrame getMainView() {
        return mainView;
    }

    public JButton getAddClubBtn() {
        return addClubBtn;
    }

    public JButton getAddExistingClubBtn() {
        return addExistingClubBtn;
    }
    
    
    

    @Override
    public void update(Observable arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
