package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import java.awt.Frame;

/**
 * @author z003ywys
 */
public class ClubAddExistingView extends JDialog {

    private static final long serialVersionUID = 22L;

    public ClubAddExistingView(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Bereits vorhandenen Club hinzufügen");
        selectedLiga = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        ligaClubList = new JList<>();
        toAddClubLbl = new JLabel();
        jLabel2 = new JLabel();
        adClubToLigaBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        selectedLiga.setModel(new DefaultComboBoxModel<>(new String[] { "Liga 1", "Liga 2", "Liga 3" }));

        ligaClubList.setModel(new AbstractListModel<String>() {
            String[] strings = { "Leipzig", "Bayern", "Hamburg" };

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane1.setViewportView(ligaClubList);

        jLabel2.setText("Der hinzuzufuegende Club:");

        adClubToLigaBtn.setText("Club zur Liga hinzufuegen");
        adClubToLigaBtn.setActionCommand("clubAddLiga");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 361,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(selectedLiga, GroupLayout.PREFERRED_SIZE, 134,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(toAddClubLbl, GroupLayout.PREFERRED_SIZE, 135,
                                                GroupLayout.PREFERRED_SIZE))
                                .addComponent(adClubToLigaBtn, GroupLayout.PREFERRED_SIZE, 260,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addContainerGap()
                .addComponent(selectedLiga, GroupLayout.PREFERRED_SIZE, 29,
                        GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 86,
                        GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(toAddClubLbl, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18).addComponent(adClubToLigaBtn, GroupLayout.PREFERRED_SIZE, 30,
                        GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE)));

        pack();
    }

    private JButton adClubToLigaBtn;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private JList<String> ligaClubList;
    private JComboBox<String> selectedLiga;
    private JLabel toAddClubLbl;

    public JButton getAdClubToLigaBtn() {
        return adClubToLigaBtn;
    }

    public JList<String> getLigaClubList() {
        return ligaClubList;
    }

    public JComboBox<String> getSelectedLiga() {
        return selectedLiga;
    }

    public JLabel getToAddClubLbl() {
        return toAddClubLbl;
    }

    public void setLigaComboModel(DefaultComboBoxModel<String> dCM) {
        this.selectedLiga.setModel(dCM);
    }

}
