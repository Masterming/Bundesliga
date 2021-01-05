package controller;

import model.Game;
import view.GameView;

/**
 * @author Rene
 */
public class GameController {

    private Game model;
    private GameView view;

    public GameController(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printOverview(model);
    }

    public void addClub(String club) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
