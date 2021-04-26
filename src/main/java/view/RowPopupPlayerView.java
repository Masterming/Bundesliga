package view;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 * @author z003ywys
 */
public class RowPopupPlayerView extends JPopupMenu {

    private static final long serialVersionUID = 18L;

    private JMenuItem loeschen;
    private JMenuItem bearbeiten;

    public RowPopupPlayerView(JTable table) {
        loeschen = new JMenuItem("Loeschen");
        loeschen.setActionCommand("loeschen");
        bearbeiten = new JMenuItem("Bearbeiten");
        bearbeiten.setActionCommand("bearbeiten");
        add(loeschen);
        add(bearbeiten);
    }

    public JMenuItem getLoeschen() {
        return loeschen;
    }

    public JMenuItem getBearbeiten() {
        return bearbeiten;
    }

}
