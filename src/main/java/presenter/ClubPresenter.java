package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

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
public class ClubPresenter implements MouseListener, ActionListener {

    private final static Logger LOGGER = Logger.getLogger(ClubPresenter.class.getName());
    private ClubView view;
    private JFrame master;
    private Liga liga;
    private List<Liga> ligas;

    public ClubPresenter(JFrame master, ClubView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getClubTable().addMouseListener(this);
        this.view.getAddClubBtn().addActionListener(this);
        this.view.getAddExistingClubBtn().addActionListener(this);
        if (liga.getId() == 1 || liga.getId() == 2) {
            this.view.getAddClubBtn().setVisible(false);
            this.view.getAddExistingClubBtn().setVisible(true);
        } else {
            this.view.getAddClubBtn().setVisible(true);
            this.view.getAddExistingClubBtn().setVisible(true);
        }
        this.view.repaint();
        this.view.revalidate();
        this.setData();

    }

    public ClubPresenter(JFrame master, ClubView view, Liga liga, List ligas) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        this.view.getClubTable().addMouseListener(this);
        this.view.getAddClubBtn().addActionListener(this);
        this.view.getAddExistingClubBtn().addActionListener(this);
        if (liga.getId() == 1 || liga.getId() == 2) {
            this.view.getAddClubBtn().setVisible(false);
            this.view.getAddExistingClubBtn().setVisible(true);
        } else {
            this.view.getAddClubBtn().setVisible(true);
            this.view.getAddExistingClubBtn().setVisible(true);
        }
        this.view.repaint();
        this.view.revalidate();
        this.ligas = ligas;
        this.setData();

    }

    public void addPlayer(String player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
            // LOGGER.log(Level.INFO, "Tabelle wurde 2 mal geklcikt im ClubPresenter");
            // Neues Fenster geht auf --> Neuen Controller + View
            JTable temp = (JTable) evt.getSource();
            int row = temp.getSelectedRow();
            int column = 0;
            String club = temp.getValueAt(row, column).toString();

            Club c = liga.getClub(club);
            ClubEditView cbV = new ClubEditView(view.getmaster(), true);
            ClubEditPresenter clubEditController = new ClubEditPresenter(cbV, c, liga, master);
            cbV.setVisible(true);
        }
        if (SwingUtilities.isRightMouseButton(evt)) {
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item
            RowPopupClubView kontext = new RowPopupClubView();
            RowPopupClubPresenter rowPopupClubController = new RowPopupClubPresenter(master, kontext, liga,
                    view.getClubTable());
            kontext.show(view.getClubTable(), evt.getX(), evt.getY());
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = view.getClubTable().rowAtPoint(e.getPoint());
        int c = view.getClubTable().columnAtPoint(e.getPoint());
        if (r >= 0 && r < view.getClubTable().getRowCount()) {
            view.getClubTable().setRowSelectionInterval(r, r);
            view.getClubTable().setColumnSelectionInterval(c, c);
        } else {
            view.getClubTable().clearSelection();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int r = view.getClubTable().rowAtPoint(e.getPoint());
        int c = view.getClubTable().columnAtPoint(e.getPoint());
        if (r >= 0 && r < view.getClubTable().getRowCount()) {
            view.getClubTable().setRowSelectionInterval(r, r);
            view.getClubTable().setColumnSelectionInterval(c, c);
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
        String[][] data = new String[liga.getClubs().size()][];
        int count = 0;
        for (Club c : liga.getClubs()) {
            String[] temp = new String[2];
            temp[0] = c.getName();
            temp[1] = c.getStadion();
            data[count] = temp;
            count++;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case "addClub":
            LOGGER.log(Level.INFO, "Club Hinzufuegen button gedrueckt");
            ClubAddView caV = new ClubAddView(master, true);
            ClubAddPresenter clubAddController = new ClubAddPresenter(master, caV, liga);
            caV.setVisible(true);
            break;

        case "addExistClub":
            LOGGER.log(Level.INFO, "Vorhandenen Club zur Liga hinzufuegen");
            // Dialog box mit drop down menue ueber die 2 Ligen die nicht der aktuellen liga
            // entsprechen
            // auf grund der auswahl wird liste angapsst mit den clubs der liga, die im Drop
            // Down menue ausgewaehlt wurde
            // in Liste: mehrfach auswahl moeglich
            ClubAddExistingView caEV = new ClubAddExistingView(master, true);
            ClubAddExistingPresenter caEC = new ClubAddExistingPresenter(master, caEV, liga);
            caEV.setVisible(true);
            break;

        }
    }
}
