package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.System.in;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Club;
import model.Game;
import model.Liga;
import view.ClubAddExistingView;

/**
 * @author z003ywys
 */
public class ClubAddExistingController implements ActionListener, MouseListener, ItemListener {

    private final static Logger LOGGER = Logger.getLogger(ClubAddExistingController.class.getName());
    private ClubAddExistingView view;
    private JFrame master;
    private Liga liga;
    private String selectedClub;
    private DefaultListModel<String> clubList;
    private Map<Integer, Liga> ligas;
    private int targetLigaId;

    public ClubAddExistingController(JFrame master, ClubAddExistingView view, Liga liga) {
        this.view = view;
        this.master = master;
        this.liga = liga;
        clubList = new DefaultListModel<>();
        this.view.getLigaClubList().setModel(clubList);
        this.ligas = MainController.getLigas();
        this.view.getAdClubToLigaBtn().addActionListener(this);
        this.view.getSelectedLiga().addItemListener(this);
        this.view.getLigaClubList().addMouseListener(this);
        adaptViewToLiga();
    }

    private void adaptViewToLiga() {
        String[] ligen;
        DefaultComboBoxModel<String> dfC;
        switch (liga.getId()) {
            case 1:
                ligen = new String[1];
                ligen[0] = "Liga 2";
                dfC = new DefaultComboBoxModel<>(ligen);
                view.setLigaComboModel(dfC);
                populateComboBox();
                break;

            case 2:
                ligen = new String[2];
                ligen[0] = "Liga 1";
                ligen[1] = "Liga 3";
                dfC = new DefaultComboBoxModel<>(ligen);
                view.setLigaComboModel(dfC);
                populateComboBox();
                break;

            case 3:
                ligen = new String[1];
                ligen[0] = "Liga 2";
                dfC = new DefaultComboBoxModel<>(ligen);
                view.setLigaComboModel(dfC);
                populateComboBox();
                break;

        }
        view.repaint();
        view.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case "clubAddLiga":
                int confirm = JOptionPane.showConfirmDialog(master, "Wollen Sie den Club zur Liga hinzufuegen ?",
                        "Club Hinzufuegen", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION && selectedClub != null) {
                    LOGGER.log(Level.INFO, "Club: {0} zur Liga hinzugefuegt", selectedClub);
                    //TODO: Check if club has any games left to play

                    Liga origin = ligas.get(this.targetLigaId);
                    Club temp = origin.getClub(selectedClub);
                    if(origin.getGames().isEmpty()){
                        System.out.println("Club kann erst bewebt werden nachdem gespielt wurde");
                    }
                    boolean hasClubAnyGamesLeft = false;
                    for (Game g : origin.getGames()) {
                        if (g.isFinished() == false) {
                            if (g.getClub1() != temp && g.getClub2() != temp) {
                               hasClubAnyGamesLeft = false;
                            }
                            else{
                                hasClubAnyGamesLeft = true;
                            }

                        }
                        if(g.isFinished() == true){
                            hasClubAnyGamesLeft = false;
                        }

                    }
                    if(!hasClubAnyGamesLeft){
                        //remove Club
                        removeClub(origin);
                    }
                    else{
                        JOptionPane.showMessageDialog(master, "Club kann nicht zur neuen Liga hinzugefügt werden, da noch spiele in der aktuellen Liga ausstehen");
                    }
                    
                    break;
                }
        }
    }

        @Override
        public void mouseClicked
        (MouseEvent evt
        
            ) {
        // 1. Liga auswahl
        if (evt.getClickCount() == 1) {
                try {
                    selectedClub = view.getLigaClubList().getSelectedValue();
                    if (selectedClub != null) {
                        view.getToAddClubLbl().setText(selectedClub);

                    } else {
                        view.getToAddClubLbl().setText("");
                    }
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
                    view.getToAddClubLbl().setText("");
                }

            }
        }

        @Override
        public void mousePressed
        (MouseEvent arg0
        
        
        ) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
        public void mouseReleased
        (MouseEvent arg0
        
        
        ) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
        public void mouseEntered
        (MouseEvent arg0
        
        
        ) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
        public void mouseExited
        (MouseEvent arg0
        
        
        ) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
    }

    @Override
        public void itemStateChanged
        (ItemEvent evt
        
            ) {
        populateComboBox();
        }

    

    private void populateComboBox() {
        String ligStr = view.getSelectedLiga().getSelectedItem().toString();
        clubList.removeAllElements();
        if (ligStr.contains("1")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : ligas.get(1).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.targetLigaId = 1;

        }
        if (ligStr.contains("2")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : ligas.get(2).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.targetLigaId = 2;

        }
        if (ligStr.contains("3")) {
            // TODO Clubs Aufzaehlen aus der Liga
            for (Club c : ligas.get(3).getClubs()) {
                clubList.addElement(c.getName());
            }
            this.targetLigaId = 3;
        }
    }
    
    private void removeClub(Liga origin){
        Club remClub = origin.removeClub(selectedClub);
        Liga target = ligas.get(liga.getId());

        target.addClub(remClub);

        JOptionPane.showMessageDialog(master, "Transfer war erfolgreich");
        LOGGER.log(Level.INFO, "Club Transfer finished successful");

        view.dispose();
    }
   

}
