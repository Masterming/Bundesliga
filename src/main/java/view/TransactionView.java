package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * @author z003ywys
 */
public class TransactionView extends javax.swing.JPanel {

    private static final long serialVersionUID = 21L;
    private javax.swing.JButton addToTransBtn;
    private javax.swing.JList<String> ergListClub;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listEigenerKader;
    private javax.swing.JList<String> listeTransKader;
    private javax.swing.JLabel receiveClubLbl;
    private javax.swing.JTextField receivingClubInput;
    private javax.swing.JButton removeFromTransBtn;
    private javax.swing.JLabel selectedClub;
    private javax.swing.JButton suchenBtn;
    private javax.swing.JButton transFinishBtn;

    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        receivingClubInput = new javax.swing.JTextField();
        suchenBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ergListClub = new javax.swing.JList<>();
        selectedClub = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEigenerKader = new javax.swing.JList<>();
        transFinishBtn = new javax.swing.JButton();
        addToTransBtn = new javax.swing.JButton();
        removeFromTransBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listeTransKader = new javax.swing.JList<>();
        receiveClubLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setPreferredSize(new java.awt.Dimension(0, 258));

        receivingClubInput.setForeground(java.awt.Color.lightGray);
        receivingClubInput.setText("Erhaltendes Club");
        receivingClubInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receivingClubInputFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                receivingClubInputFocusLost(evt);
            }
        });

        suchenBtn.setText("Suchen");
        suchenBtn.setActionCommand("suchen");

        ergListClub.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        ergListClub.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ergListClub);

        selectedClub.setText("Empfaengerclub:");

        listEigenerKader.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", " " };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(listEigenerKader);

        transFinishBtn.setText("Transaktionen bestaetigen");
        transFinishBtn.setActionCommand("trans_finish");

        addToTransBtn.setText(">");
        addToTransBtn.setActionCommand("add");

        removeFromTransBtn.setText("<");
        removeFromTransBtn.setActionCommand("rem");

        listeTransKader.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", " " };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane3.setViewportView(listeTransKader);

        receiveClubLbl.setText("RB Leipzig");

        jLabel1.setText("Eigene Spieler");

        jLabel2.setText("Zu sende Spieler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup().addComponent(selectedClub)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(receiveClubLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(transFinishBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(
                                                receivingClubInput, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18).addComponent(suchenBtn))
                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addToTransBtn).addComponent(removeFromTransBtn)))
                                        .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2).addComponent(jScrollPane3,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 134,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(29, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(receivingClubInput))
                        .addComponent(suchenBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectedClub, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(receiveClubLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                        .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup().addComponent(addToTransBtn).addGap(18, 18, 18)
                                .addComponent(removeFromTransBtn))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(transFinishBtn,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));
    }// </editor-fold>

    private void receivingClubInputFocusGained(java.awt.event.FocusEvent evt) {
        if (this.receivingClubInput.getText().equals("Erhaltendes Club")) {
            this.receivingClubInput.setText("");
            this.receivingClubInput.setForeground(Color.BLACK);
        }
    }

    private void receivingClubInputFocusLost(java.awt.event.FocusEvent evt) {
        if (this.receivingClubInput.getText().isBlank()) {
            this.receivingClubInput.setText("Erhaltendes Club");
            this.receivingClubInput.setForeground(Color.lightGray);
        }
    }

    public TransactionView() {
        initComponents();
    }

    public JTextField getReceivingClubInput() {
        return receivingClubInput;
    }

    public JList<String> getErgListClub() {
        return ergListClub;
    }

    public void setErgListClub(JList<String> ergListClub) {
        this.ergListClub = ergListClub;
    }

    public JList<String> getListEigenerKader() {
        return listEigenerKader;
    }

    public void setListEigenerKader(JList<String> listEigenerKader) {
        this.listEigenerKader = listEigenerKader;
    }

    public JList<String> getListeTransKader() {
        return listeTransKader;
    }

    public void setListeTransKader(JList<String> listeTransKader) {
        this.listeTransKader = listeTransKader;
    }

    public JLabel getReceiveClubLbl() {
        return receiveClubLbl;
    }

    public void setReceiveClubLbl(String receiveClubLbl) {
        this.receiveClubLbl.setText(receiveClubLbl);
    }

    public JButton getAddToTransBtn() {
        return addToTransBtn;
    }

    public JButton getRemoveFromTransBtn() {
        return removeFromTransBtn;
    }

    public JButton getSuchenBtn() {
        return suchenBtn;
    }

    public JButton getTransFinishBtn() {
        return transFinishBtn;
    }
}
