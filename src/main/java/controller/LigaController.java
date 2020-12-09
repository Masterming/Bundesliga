package controller;

import model.Liga;
import view.LigaView;

/**
 * @author Rene
 */
public class LigaController {
    
    private Liga liga;
    private LigaView view;

    public LigaController(Liga liga, LigaView view) {
        this.liga = liga;
        this.view = view;
    }

    public void updateView() {
        view.printSortedClubs(liga.getClubs());
    }
}
