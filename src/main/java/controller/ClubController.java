package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.util.logging.*;

import model.Club;
import model.Liga;
import view.ClubAddExistingView;
import view.ClubAddView;
import view.ClubEditView;
import view.ClubView;
import view.RowPopupClubView;

/**
 * @author Rene
 */
public class ClubController implements MouseListener, ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ClubController.class.getName());

    private ClubView view;
    private Liga l;
    private JFrame master;

    public ClubController(JFrame master, ClubView view, Liga l) {
        view.getClubTable().addMouseListener(this);
        view.getAddClubBtn().addActionListener(this);
        view.getAddExistingClubBtn().addActionListener(this);
        // ueberlegen ob man Buttons ausgraut
        if (l.getId() == 1 || l.getId() == 2) {
            view.getAddClubBtn().setVisible(false);
            view.getAddExistingClubBtn().setVisible(true);
        } else {
            view.getAddClubBtn().setVisible(true);
            view.getAddExistingClubBtn().setVisible(true);
        }
        view.repaint();
        view.revalidate();
        this.master = master;
        this.l = l;
        this.setData();
        this.view = view;
    }

    public void addPlayer(String player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            LOGGER.log(Level.INFO, "Tabelle wurde 2 mal geklcikt im ClubController");
            // Neues Fenster geht auf --> Neuen Controller + View
            JTable temp = (JTable) evt.getSource();
            int row = temp.getSelectedRow();
            int column = 0;
            String team = temp.getValueAt(row, column).toString();
            ClubEditView cbV = new ClubEditView(view.getmaster(), true);
            new ClubEditController(cbV, team);
            cbV.setVisible(true);
        }
        if (SwingUtilities.isRightMouseButton(evt)) {
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item
            RowPopupClubView kontext = new RowPopupClubView();
            new RowPopupClubController(master, kontext, this.l, view.getClubTable());
            kontext.show(view.getClubTable(), evt.getX(), evt.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = view.getClubTable().rowAtPoint(e.getPoint());
        if (r >= 0 && r < view.getClubTable().getRowCount()) {
            view.getClubTable().setRowSelectionInterval(r, r);
        } else {
            view.getClubTable().clearSelection();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int r = view.getClubTable().rowAtPoint(e.getPoint());
        if (r >= 0 && r < view.getClubTable().getRowCount()) {
            view.getClubTable().setRowSelectionInterval(r, r);
        } else {
            view.getClubTable().clearSelection();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void setData() {
        DefaultTableModel tbm = (DefaultTableModel) view.getClubTable().getModel();
        String data[][] = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        view.setTableContent(tbm);
    }

    private String[][] getData() {
        String[][] data = new String[l.getClubs().size()][];
        int count = 0;
        for (Club c : l.getClubs()) {
            String[] temp = new String[2];
            temp[0] = c.getName();
            temp[1] = c.getStadion();
            data[count] = temp;
            count++;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "addClub":
                LOGGER.log(Level.INFO, "Club Hinzufuegen button gedrueckt");
                ClubAddView caV = new ClubAddView(this.master, true);
                new ClubAddController(this.master, caV, l);
                caV.setVisible(true);
                break;
            case "addExistClub":
                LOGGER.log(Level.INFO, "Vorhandenen Club zur Liga hinzufuegen");
                // Dialog box mit drop down menue ueber die 2 Ligen die nicht der aktuellen liga
                // entsprechen
                // auf grund der auswahl wird liste angapsst mit den clubs der liga, die im Drop
                // Down menue ausgewaehlt wurde
                // in Liste: mehrfach auswahl moeglich
                ClubAddExistingView caEV = new ClubAddExistingView(this.master, true);
                ClubAddExistingController caEC = new ClubAddExistingController(caEV, this.l);
                caEV.setVisible(true);
                break;

        }
    }
}
