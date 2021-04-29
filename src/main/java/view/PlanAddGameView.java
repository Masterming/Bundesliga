package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author z003ywys
 */
public class PlanAddGameView extends javax.swing.JDialog {

    private static final long serialVersionUID = 14L;

    public PlanAddGameView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateInputTxt = new javax.swing.JTextField();
        addSpielBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clubALigaList = new javax.swing.JComboBox<>();
        clubBLigaList = new javax.swing.JComboBox<>();
        clubAList = new javax.swing.JComboBox<>();
        clubBList = new javax.swing.JComboBox<>();
        clubALbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        clubBLbl = new javax.swing.JLabel();
        this.setTitle("Neues spiel hinzufügen");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Datum: ");

        jLabel1.setText("Gastteam:");

        jLabel3.setText("Liga");

        addSpielBtn.setText("Spiel hinzufügen");
        addSpielBtn.setActionCommand("addGame");

        jLabel4.setText("Format: dd.MM.yyyy HH:mm");

        jLabel5.setText("Heimteam:");

        jLabel6.setText("Liga: ");

        clubALigaList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        clubBLigaList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        clubAList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        clubBList.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        clubALbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubALbl.setText("ClubA");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(":");

        clubBLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clubBLbl.setText("ClubA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        layout.createSequentialGroup().addContainerGap(53, Short.MAX_VALUE).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                        layout.createSequentialGroup()
                                                .addComponent(clubALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 162,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(
                                                        jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clubBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(addSpielBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                                                                        jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(
                                                                        dateInputTxt,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 291,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup().addComponent(
                                                                jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(clubALigaList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup().addComponent(
                                                                jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(clubBLigaList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 92,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(33, 33, 33)
                                                        .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jLabel5))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(clubAList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(clubBList,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(48, 48, 48)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                        .createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(clubALigaList, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(clubBLigaList)))
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(clubAList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(clubBList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7)
                        .addComponent(clubBLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clubALbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateInputTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(addSpielBtn)
                .addGap(19, 19, 19)));

        pack();
    }

    private javax.swing.JButton addSpielBtn;
    private javax.swing.JTextField dateInputTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel clubALbl;
    private javax.swing.JComboBox<String> clubALigaList;
    private javax.swing.JComboBox<String> clubAList;
    private javax.swing.JLabel clubBLbl;
    private javax.swing.JComboBox<String> clubBLigaList;
    private javax.swing.JComboBox<String> clubBList;

    public JTextField getDateInputTxt() {
        return dateInputTxt;
    }

    public JButton getAddSpielBtn() {
        return addSpielBtn;
    }

    public JLabel getClubALbl() {
        return clubALbl;
    }

    public JComboBox<String> getClubALigaList() {
        return clubALigaList;
    }

    public JComboBox<String> getClubAList() {
        return clubAList;
    }

    public JLabel getClubBLbl() {
        return clubBLbl;
    }

    public JComboBox<String> getClubBLigaList() {
        return clubBLigaList;
    }

    public JComboBox<String> getClubBList() {
        return clubBList;
    }

    public void setClubALigaList(DefaultComboBoxModel<String> clubALigaList) {
        this.clubALigaList.setModel(clubALigaList);
    }

    public void setClubAList(DefaultComboBoxModel<String> clubAList) {
        this.clubAList.setModel(clubAList);
    }

    public void setClubBLigaList(DefaultComboBoxModel<String> clubBLigaList) {
        this.clubBLigaList.setModel(clubBLigaList);
    }

    public void setClubBList(DefaultComboBoxModel<String> clubBList) {
        this.clubBList.setModel(clubBList);
    }

    public void setClubALbl(String clubALbl) {
        this.clubALbl.setText(clubALbl);
    }

    public void setClubBLbl(String clubBLbl) {
        this.clubBLbl.setText(clubBLbl);
    }

}
