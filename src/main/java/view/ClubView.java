package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Club;

/**
 * @author Rene
 */
public class ClubView extends javax.swing.JPanel implements Observer{
    private static final long serialVersionUID = 8L;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable clubTable;
    private javax.swing.JButton addClubBtn;
    private JFrame mainView; 
    public void printOverview(Club model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void initComponents(){
       addClubBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubTable = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
        };

        addClubBtn.setText("Club Hinzufügen");
        addClubBtn.setActionCommand("addClub");

        clubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Club", "Stadion"
            }
        ));
        jScrollPane1.setViewportView(clubTable);
        clubTable.setAutoCreateRowSorter(true);
        clubTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        clubTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        clubTable.setShowVerticalLines(false);
        clubTable.getTableHeader().setReorderingAllowed(false);
        clubTable.getAccessibleContext().setAccessibleName("clubTable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addClubBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addClubBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    

    @Override
    public void update(Observable arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
