/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ErgebnisInputController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.PlanModel;

/**
 *
 * @author z003ywys
 */
public class PlanViewNeu extends JPanel implements Observer {

    @Override
    public void update(Observable o, Object arg1) {
        //Hier landet man wenn man im Model was verändert hat durch norifyObservers
        this.planContent.setLayout(new BoxLayout(this.planContent,BoxLayout.Y_AXIS));
        if(o instanceof PlanModel){
            //To change body of generated methods, choose Tools | Templates.
            //javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            //this.setLayout(layout);
            this.planContent.removeAll();
            this.plm =(PlanModel)o;
            int count =1;
            if(this.plm.getlM().getName().contains("1")){
                count = 5;
            }
            if(this.plm.getlM().getName().contains("2")){
                count = 10;
            }
            if(this.plm.getlM().getName().contains("3")){
                count = 15;
            }
            for(int i=0; i<count;i++){
                JLabel test = new JLabel(((PlanModel) o).getlM().getName());
                 JButton testBtn = new JButton("TestBTN " + i);
                 test.setBackground(java.awt.Color.lightGray);
                 test.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
                testBtn.setActionCommand(String.valueOf(i)+ "RB Leipzig");
                testBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action(evt);
            }
        });
            this.planContent.add(test);
            this.planContent.add(testBtn);
            }
            this.planContent.revalidate();
            this.planContent.repaint();
            this.planContent.setVisible(true);
           
            
    }
    }

    public PlanViewNeu(JFrame main) {
        initComponents();
        this.mainView = main;
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }
    private void initComponents() {

        planContent = new javax.swing.JPanel();
        btnContainer = new javax.swing.JPanel();
        addSpielBtn = new javax.swing.JButton();

        planContent.setLayout(new javax.swing.BoxLayout(planContent, javax.swing.BoxLayout.LINE_AXIS));

        addSpielBtn.setText("Spiel hinzufügen");
        addSpielBtn.setActionCommand("addSpiel");

        javax.swing.GroupLayout btnContainerLayout = new javax.swing.GroupLayout(btnContainer);
        btnContainer.setLayout(btnContainerLayout);
        btnContainerLayout.setHorizontalGroup(
            btnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnContainerLayout.createSequentialGroup()
                .addComponent(addSpielBtn)
                .addGap(0, 273, Short.MAX_VALUE))
        );
        btnContainerLayout.setVerticalGroup(
            btnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnContainerLayout.createSequentialGroup()
                .addComponent(addSpielBtn)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(planContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planContent, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
    
    private javax.swing.JButton addSpielBtn;
    private javax.swing.JPanel btnContainer;
    private javax.swing.JPanel planContent;
    private JFrame mainView;
    private PlanModel plm;

    public JButton getAddSpielBtn() {
        return addSpielBtn;
    }
    private void action (ActionEvent e){
        String a = e.getActionCommand();
        System.out.println("Das Action Command war: " + a);
        System.out.println("Button gesetzt durch model geklickt");
        //Neues Pop Up fenster + Controller --> bekommt z.B. Spiel Model mit
        ErgebnisInputView pop = new ErgebnisInputView(this.mainView,true);
        ErgebnisInputController con = new ErgebnisInputController(pop, a,a, this.plm);
        pop.setVisible(true);
    }
    
    
}
