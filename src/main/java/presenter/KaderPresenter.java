package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import model.Club;
import model.Liga;
import model.Player;
import view.KaderView;
import view.RowPopupPlayerView;

/**
 * @author z003ywys
 */
public class KaderPresenter implements ActionListener, MouseListener {

    private KaderView view;
    private JFrame master;
    private Liga liga;
    private Club club;

    public KaderPresenter(KaderView view, Club club, JFrame mas, Liga liga) {
        this.view = view;
        this.master = mas;
        this.liga = liga;
        this.club = club;
        this.view.getPlayerTable().addMouseListener(this);
        this.setTableData();
    }

    private void setTableData() {
        DefaultTableModel tbm = (DefaultTableModel) view.getPlayerTable().getModel();
        String[][] data = getData();
        for (String[] d : data) {
            tbm.addRow(d);
        }

        view.setPlayerTableContent(tbm);
    }

    private String[][] getData() {
        String[][] data = new String[club.getPlayers().size()][];
        int count = 0;

        for (Player p : club.getPlayers()) {
            String[] temp = new String[2];
            temp[0] = p.getName();
            temp[1] = String.valueOf(p.getGoals());
            data[count] = temp;
            count++;
        }
        return data;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e)) {
            // Kontext Menue mit Spieler Loeschen und name aendern ueber Pop up Item

            RowPopupPlayerView kontext = new RowPopupPlayerView(view.getPlayerTable());
            RowPopupPlayerPresenter rPoPPlC = new RowPopupPlayerPresenter(kontext, this.club,
                    this.view.getPlayerTable(), master, this.liga);
            kontext.show(view.getPlayerTable(), e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = view.getPlayerTable().rowAtPoint(e.getPoint());
        int c = view.getPlayerTable().columnAtPoint(e.getPoint());
        if (r >= 0 && r < view.getPlayerTable().getRowCount()) {
            view.getPlayerTable().setRowSelectionInterval(r, r);
            view.getPlayerTable().setColumnSelectionInterval(c, c);
        } else {
            view.getPlayerTable().clearSelection();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int r = view.getPlayerTable().rowAtPoint(e.getPoint());
        int c = view.getPlayerTable().columnAtPoint(e.getPoint());
        if (r >= 0 && r < view.getPlayerTable().getRowCount()) {
            view.getPlayerTable().setRowSelectionInterval(r, r);
            view.getPlayerTable().setColumnSelectionInterval(c, c);
        } else {
            view.getPlayerTable().clearSelection();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

}
