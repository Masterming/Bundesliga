package controller;

import model.Club;
import model.Liga;
import model.LigaDBMapper;
import view.LigaView;

/**
 * @author Rene
 */
public class LigaController {

    private Liga model;
    private LigaView view;
    private LigaDBMapper ligaDAO;

    public LigaController(Liga model, LigaView view) {
        this.model = model;
        this.view = view;
        ligaDAO = new LigaDBMapper();
    }

    public void updateView() {
        view.printOverview(model);
    }

    public void addClub(Club club) {
        model.addClub(club);
    }
}
