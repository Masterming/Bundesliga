package view;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * @author z003ywys
 */
public class RowPopupClubView extends JPopupMenu {

    private static final long serialVersionUID = 17L;

    private JMenuItem loeschen;
    private JMenuItem bearbeiten;

    public RowPopupClubView() {
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
