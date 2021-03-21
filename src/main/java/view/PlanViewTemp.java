/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author z003ywys
 */
public class PlanViewTemp extends javax.swing.JPanel {

    /**
     * Creates new form PlanViewTemp
     */
    public PlanViewTemp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        planContent = new javax.swing.JPanel();
        addSpielBtn = new javax.swing.JButton();
        createGames = new javax.swing.JButton();
        setResult = new javax.swing.JButton();
        restartSeasonBtn = new javax.swing.JButton();
        gameHistory = new javax.swing.JButton();

        planContent.setLayout(new javax.swing.BoxLayout(planContent, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(planContent);

        addSpielBtn.setText("Spiel hinzufügen");
        addSpielBtn.setActionCommand("addSpiel");

        createGames.setText("Spiele automatisch erstellen");
        createGames.setActionCommand("addSpielAuto");

        setResult.setText("Ergebnisse automatisch setzen");
        setResult.setActionCommand("setResultAuto");
        setResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setResultActionPerformed(evt);
            }
        });

        restartSeasonBtn.setText("Saison neustarten");
        restartSeasonBtn.setActionCommand("restartSeason");

        gameHistory.setText("Spielhistorie");
        gameHistory.setActionCommand("gamesHistory");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addSpielBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setResult, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createGames, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(restartSeasonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(gameHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(gameHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gameHistory.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void setResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setResultActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addSpielBtn;
    public javax.swing.JButton createGames;
    private javax.swing.JButton gameHistory;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel planContent;
    private javax.swing.JButton restartSeasonBtn;
    public javax.swing.JButton setResult;
    // End of variables declaration//GEN-END:variables
}
