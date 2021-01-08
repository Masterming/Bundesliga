package view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Club;

/**
 * @author Rene
 */
public class ClubView extends javax.swing.JPanel implements Observer{
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable clubTable;
    private JFrame mainView; 
    public void printOverview(Club model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void initComponents(){
        jScrollPane1 = new javax.swing.JScrollPane();
        clubTable = new javax.swing.JTable(){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
            return false;
         }
        };

        clubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
//                {"FC Bayern", "Allianz Arena"},
//                {"RB Leipzig", "Red Bull Arena"},
//                {"Borussia Dortmund", "Signal Iduna Park"},
            },
            new String [] {
                "Club", "Stadion"
            }
        ));
        
        clubTable.setAutoCreateRowSorter(true);
        clubTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        clubTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        clubTable.setShowVerticalLines(false);
        clubTable.getTableHeader().setReorderingAllowed(false);
//        clubTable.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTable1MouseClicked(evt);
//            }
//            public void mousePressed(java.awt.event.MouseEvent evt) {
//                jTable1MousePressed(evt);
//            }
//        });
        jScrollPane1.setViewportView(clubTable);
        clubTable.getAccessibleContext().setAccessibleName("clubTable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
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
    

    @Override
    public void update(Observable arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
