package view;

import controller.ErgebnisInputController;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author z003ywys
 */
public class PlanView extends JPanel {

    private final static Logger LOGGER = Logger.getLogger(PlanView.class.getName());

    private static final long serialVersionUID = 16L;

    public javax.swing.JButton addSpielBtn;
    public javax.swing.JButton createGames;
    private javax.swing.JButton gameHistory;
    public javax.swing.JPanel planContent;
    private javax.swing.JButton restartSeasonBtn;
    public javax.swing.JButton setResult;
    private JFrame master;

    public PlanView(JFrame master) {
        initComponents();
        this.master = master;
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getLocalizedMessage());
        }
        this.setVisible(true);
    }

    private void initComponents() {
               planContent = new javax.swing.JPanel();
        addSpielBtn = new javax.swing.JButton();
        createGames = new javax.swing.JButton();
        setResult = new javax.swing.JButton();
        restartSeasonBtn = new javax.swing.JButton();
        gameHistory= new javax.swing.JButton(); 
        //restartSeasonBtn.setMinimumSize(new java.awt.Dimension(150, 21));
        restartSeasonBtn.setMinimumSize(new java.awt.Dimension(150, 21));


        planContent.setLayout(new javax.swing.BoxLayout(planContent, javax.swing.BoxLayout.LINE_AXIS));

        addSpielBtn.setText("Spiel hinzufügen");
        addSpielBtn.setActionCommand("addSpiel");
        //addSpielBtn.setMaximumSize(new java.awt.Dimension(150, 21));
        addSpielBtn.setMinimumSize(new java.awt.Dimension(150, 21));

        createGames.setText("Spiele automatisch erstellen");
        createGames.setActionCommand("addSpielAuto");
        //createGames.setMaximumSize(new java.awt.Dimension(150, 21));
        FontMetrics metrics = getFontMetrics(getFont()); 
        int width = metrics.stringWidth("Spiele automatisch erstellen");
        createGames.setMinimumSize(new java.awt.Dimension(350,21));

        setResult.setText("Ergebnisse automatisch setzen");
        setResult.setActionCommand("setResultAuto");
        //setResult.setMaximumSize(new java.awt.Dimension(150, 21));
        setResult.setMinimumSize(new java.awt.Dimension(350, 21));

        restartSeasonBtn.setText("Saison neu starten");
        restartSeasonBtn.setActionCommand("restartSeason");
        metrics = getFontMetrics(getFont()); 
        width = metrics.stringWidth("Saison neustarten");
        //restartSeasonBtn.setMaximumSize(new java.awt.Dimension(150, 21));
        restartSeasonBtn.setMinimumSize(new java.awt.Dimension(350, 21));
        
        gameHistory.setText("Spielhistorie");
        gameHistory.setActionCommand("gamesHistory");
        //gameHistory.setMinimumSize(new java.awt.Dimension(150, 21));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(planContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addSpielBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setResult, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createGames, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(restartSeasonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(gameHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, 33)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(restartSeasonBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(setResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addSpielBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(gameHistory, javax.swing.GroupLayout.PREFERRED_SIZE,21, javax.swing.GroupLayout.DEFAULT_SIZE))
                .addGap(18, 18, 18)
                .addComponent(planContent, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    public JButton getAddSpielBtn() {
        return addSpielBtn;
    }

    public JButton getCreateGames() {
        return createGames;
    }

    public JPanel getPlanContent() {
        return planContent;
    }

    public JButton getSetResult() {
        return setResult;
    }

//    @Override
//    public void update(Observable o, Object arg1) {
//        // Hier landet man wenn man im Model was veraendert hat durch norifyObservers
//        this.planContent.setLayout(new BoxLayout(this.planContent, BoxLayout.Y_AXIS));
//        if (o instanceof PlanModel) {
//            // To change body of generated methods, choose Tools | Templates.
//            // javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//            // this.setLayout(layout);
//            planContent.removeAll();
//            plm = (PlanModel) o;
//            int count = 1;
//            if (plm.getLiga().getId() == 1) {
//                count = 5;
//            }
//            if (plm.getLiga().getId() == 2) {
//                count = 10;
//            }
//            if (plm.getLiga().getId() == 3) {
//                count = 15;
//            }
//            for (int i = 0; i < count; i++) {
//                JLabel test = new JLabel(plm.getLiga().getName());
//                JButton testBtn = new JButton("TestBTN " + i);
//                test.setBackground(java.awt.Color.lightGray);
//                test.setAlignmentX(Component.CENTER_ALIGNMENT);
//                testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
//                testBtn.setActionCommand(String.valueOf(i) + "RB Leipzig");
//                testBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
//                    action(evt);
//                });
//                this.planContent.add(test);
//                this.planContent.add(testBtn);
//            }
//            this.planContent.revalidate();
//            this.planContent.repaint();
//            this.planContent.setVisible(true);
//
//        }
//    }

    public JButton getRestartSeasonBtn() {
        return restartSeasonBtn;
    }


    
}
