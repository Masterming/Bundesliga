package view;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDialog;

/**
 * @author z003ywys
 */
public class ClubAddView extends JDialog {

    private static final long serialVersionUID = 23L;

    public ClubAddView(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Neuen Club hinzuüfgen");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clubNameTxt = new javax.swing.JTextField();
        clubstadionTxt = new javax.swing.JTextField();
        clubAddBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(250, 250));
        // setPreferredSize(new java.awt.Dimension(204, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Club hinzufügen");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 184, 33));

        jLabel2.setText("Clubname");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 55, 30));

        jLabel3.setText("Stadion");
        jLabel3.setPreferredSize(new java.awt.Dimension(46, 13));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 55, 28));
        getContentPane().add(clubNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 50, 130, 30));
        getContentPane().add(clubstadionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 87, 130, 30));

        clubAddBtn.setText("Club hinzufügen");
        clubAddBtn.setActionCommand("clubAdd");
        getContentPane().add(clubAddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 190, -1));

        pack();
    }// </editor-fold>

    private javax.swing.JButton clubAddBtn;
    private javax.swing.JTextField clubNameTxt;
    private javax.swing.JTextField clubstadionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;

    public JTextField getClubNameTxt() {
        return clubNameTxt;
    }

    public JTextField getClubstadionTxt() {
        return clubstadionTxt;
    }

    public JButton getClubAddBtn() {
        return clubAddBtn;
    }

}
