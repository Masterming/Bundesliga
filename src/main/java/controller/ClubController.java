package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.stream.Collectors;

import javassist.bytecode.SignatureAttribute.ObjectType;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import model.Club;
import model.Liga;
import model.LigaDBMapper;
import view.ClubAddExistingView;
import view.ClubAddView;
import view.ClubEditView;
import view.ClubView;
import view.RowPopupClubView;
import view.RowPopupPlayerView;

/**
 * @author Rene
 */
public class ClubController implements MouseListener, ActionListener {
    private Club model;
    private ClubView view;
    private Liga l;
    private JFrame mainView;

    public ClubController(Club model, ClubView view, JFrame main) {
        this.model = model;
        this.view = view;
        this.view.getClubTable().addMouseListener(this);
        this.view.getAddClubBtn().addActionListener(this);
        this.view.getAddExistingClubBtn().addActionListener(this);
        this.mainView = main;
        this.setData();
    }

    public ClubController(ClubView view, Liga l, JFrame main) {
        this.view = view;
        this.l = l;
        this.view.getClubTable().addMouseListener(this);
        this.view.getAddClubBtn().addActionListener(this);
        this.view.getAddExistingClubBtn().addActionListener(this);
        this.mainView = main;
        // ueberlegen ob man Buttons ausgraut
        if (l.getName().contains("1") || l.getName().contains("2")) {
            this.view.getAddClubBtn().setVisible(false);
            this.view.getAddExistingClubBtn().setVisible(true);
            this.view.repaint();
            this.view.revalidate();
        } else {
            this.view.getAddClubBtn().setVisible(true);
            this.view.getAddExistingClubBtn().setVisible(true);
            this.view.repaint();
            this.view.revalidate();
        }

        this.setData();
    }

    public void addPlayer(String player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            System.out.println("Tabelle wurde 2 mal geklcikt im ClubController");
            // Neues Fenster geht auf --> Neuen Controller + View
            JTable temp = (JTable) evt.getSource();
            int row = temp.getSelectedRow();
            int column = 0;
            String team = temp.getValueAt(row, column).toString();
            ClubEditView cbV = new ClubEditView(this.view.getMainView(), true);
            ClubEditController cbC = new ClubEditController(cbV, team);
            cbV.setVisible(true);
        }
        if (SwingUtilities.isRightMouseButton(evt)) {
            System.out.println("kontext Menue");
            System.out.println("Rechts klick");
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item
            RowPopupClubView kontext = new RowPopupClubView(this.view.getClubTable());
            kontext.show(this.view.getClubTable(), evt.getX(), evt.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    private void setData() {
        DefaultTableModel tbm = (DefaultTableModel) this.view.getClubTable().getModel();
        String data[][] = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        this.view.setTableContent(tbm);
    }

    private String[][] getData() {
        // TODO Get Data 
        // WTF do you want here???
        LigaDBMapper dao = new LigaDBMapper();
        
        String[][] data = new String[0][];
        if (this.l.getName() == "Liga 1") {
            Liga model = dao.getLiga(1);
            List<Club> clubs_list = model.getClubs();
            String[] clubs_array = clubs_list.stream().map(Club::getName).collect(Collectors.toList()).toArray(new String[0]);
            data = new String[2][];
            String[] temp = new String[8];
            temp[0] = "FC Bayern";
            temp[1] = "Alianz Arena";

            data[0] = temp;
            temp = new String[8];
            temp[0] = "RB Leipzig";
            temp[1] = "Red Bull Arena";
            data[1] = temp;
        }
        if (this.l.getName() == "Liga 2") {
            Liga model = dao.getLiga(2);
            data = new String[1][];
            String[] temp = new String[8];
            temp[0] = "FC Erzgebirge Aue";
            temp[1] = "Erzgebirge Stadio";
            data[0] = temp;
        }
        if (this.l.getName() == "Liga 3") {
            Liga model = dao.getLiga(3);

        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "addClub":
                System.out.println("Club Hinzufuegen button gedrueckt");
                ClubAddView caV = new ClubAddView(this.mainView, true);
                ClubAddController cbAC = new ClubAddController(this.mainView, caV);
                caV.setVisible(true);
                break;
            case "addExistClub":
                System.out.println("Vorhandenen Club zur Liga hinzufuegen");
                // Dialog box mit drop down menue ueber die 2 Ligen die nicht der aktuellen liga
                // entsprechen
                // auf grund der auswahl wird liste angapsst mit den clubs der liga, die im Drop
                // Down menue ausgewaehlt wurde
                // in Liste: mehrfach auswahl moeglich
                ClubAddExistingView caEV = new ClubAddExistingView(this.mainView, true);
                ClubAddExistingController caEC = new ClubAddExistingController(caEV, this.l);
                caEV.setVisible(true);
                break;

        }
    }
}
