package controller;

import model.Player;
import view.PlayerView;

/**
 * @author Rene
 */
public class PlayerController {
    private Player model;
    private PlayerView view;

    public PlayerController(Player model, PlayerView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.printOverview(model);
    }

    public void incrementGoals() {
        model.increaseGoals();
    }
}
