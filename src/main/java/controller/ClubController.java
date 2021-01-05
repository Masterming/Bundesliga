package controller;

import model.Club;
import view.ClubView;

/**
 * @author Rene
 */
public class ClubController {
    private Club model;
    private ClubView view;

    public ClubController(Club model, ClubView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printOverview(model);
    }

    public void addPlayer(String player) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
