/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.util.logging.*;

/**
 *
 * @author z003ywys
 */
public class MainView extends javax.swing.JFrame {

    private final static Logger LOGGER = Logger.getLogger(MainView.class.getName());
    private static final long serialVersionUID = 13L;
    javax.swing.JButton liga1Btn;
    JButton liga2Btn;
    JButton liga3Btn;
    JButton tableBtn;
    JButton planBtn;
    JButton clubsBtn;
    JPanel contentView;

    private void initComponents() {
        Dimension preferredSize = new Dimension(900, 600);
        this.setPreferredSize(preferredSize);
        liga1Btn = new javax.swing.JButton();
        liga2Btn = new javax.swing.JButton();
        liga3Btn = new javax.swing.JButton();
        tableBtn = new javax.swing.JButton();
        planBtn = new javax.swing.JButton();
        clubsBtn = new javax.swing.JButton();
        contentView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        liga1Btn.setBackground(java.awt.Color.lightGray);
        liga1Btn.setText("Liga 1");
        liga1Btn.setActionCommand("liga1");
        liga1Btn.setMaximumSize(new java.awt.Dimension(90, 21));
        liga1Btn.setMinimumSize(new java.awt.Dimension(90, 21));

        liga2Btn.setBackground(java.awt.Color.lightGray);
        liga2Btn.setText("Liga 2");
        liga2Btn.setActionCommand("liga2");
        liga2Btn.setMaximumSize(new java.awt.Dimension(90, 21));
        liga2Btn.setMinimumSize(new java.awt.Dimension(90, 21));

        liga3Btn.setBackground(java.awt.Color.lightGray);
        liga3Btn.setActionCommand("liga3");
        liga3Btn.setText("Liga 3");
        liga3Btn.setMaximumSize(new java.awt.Dimension(90, 21));
        liga3Btn.setMinimumSize(new java.awt.Dimension(90, 21));

        tableBtn.setBackground(java.awt.Color.lightGray);
        tableBtn.setText("Tabelle");
        tableBtn.setActionCommand("table");
        tableBtn.setMaximumSize(new java.awt.Dimension(90, 21));
        tableBtn.setMinimumSize(new java.awt.Dimension(90, 21));
        // tableBtn.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // tableBtnClicked(evt);
        // }
        // });

        planBtn.setBackground(java.awt.Color.lightGray);
        planBtn.setText("Spielplan");
        planBtn.setActionCommand("plan");
        planBtn.setMaximumSize(new java.awt.Dimension(90, 21));
        planBtn.setMinimumSize(new java.awt.Dimension(90, 21));
        // planBtn.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // planBtnClicked(evt);
        // }
        // });

        clubsBtn.setBackground(java.awt.Color.lightGray);
        clubsBtn.setText("Clubs");
        clubsBtn.setActionCommand("clubs");
        clubsBtn.setMaximumSize(new java.awt.Dimension(90, 21));
        clubsBtn.setMinimumSize(new java.awt.Dimension(90, 21));
        // clubsBtn.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // clubBtnClicked(evt);
        // }
        // });
        contentView.setMinimumSize(new java.awt.Dimension(800, 400));
        //contentView.setPreferredSize(new java.awt.Dimension(800, 400));
        javax.swing.GroupLayout contentViewLayout = new javax.swing.GroupLayout(contentView);
        contentView.setLayout(contentViewLayout);
        contentViewLayout.setHorizontalGroup(
                contentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));
        contentViewLayout.setVerticalGroup(
                contentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 209, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(contentView, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup().addGroup(layout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        false)
                                .addComponent(liga1Btn,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(tableBtn,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        75, Short.MAX_VALUE))
                                .addGap(250, 250, 250)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(liga2Btn,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        75,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        228,
                                                        Short.MAX_VALUE)
                                                .addComponent(liga3Btn,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        75,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(planBtn)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(clubsBtn,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        75,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(liga1Btn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(liga2Btn, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(liga3Btn)).addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tableBtn,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(planBtn).addComponent(clubsBtn))
                        .addGap(18, 18, 18)
                        .addComponent(contentView, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()));

        liga1Btn.getAccessibleContext().setAccessibleName("liga1btn");
        liga2Btn.getAccessibleContext().setAccessibleName("liga2btn");
        liga3Btn.getAccessibleContext().setAccessibleName("liga3btn");
        tableBtn.getAccessibleContext().setAccessibleName("tableBtn");
        planBtn.getAccessibleContext().setAccessibleName("planBtn");
        contentView.getAccessibleContext().setAccessibleName("contentView");
        contentView.setLayout(new java.awt.BorderLayout()); // Wichtig fuer Darstellung

        this.pack();
    }// </editor-fold>

    public MainView() {
        // GroupLayout layout = new GroupLayout(this.contentView);
        // this.contentView.setLayout(layout);
        initComponents();
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getLocalizedMessage());
        } catch (InstantiationException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getLocalizedMessage());
        } catch (IllegalAccessException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getLocalizedMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(java.util.logging.Level.SEVERE, ex.getLocalizedMessage());
        }
        this.setVisible(true);

    }

    public JButton getLiga1Btn() {
        return liga1Btn;
    }

    public JButton getLiga2Btn() {
        return liga2Btn;
    }

    public JButton getLiga3Btn() {
        return liga3Btn;
    }

    public JButton getTableBtn() {
        return tableBtn;
    }

    public JButton getPlanBtn() {
        return planBtn;
    }

    public JButton getClubsBtn() {
        return clubsBtn;
    }

    public JPanel getContentView() {
        return contentView;
    }

    public void setContentView(JPanel contentView) {
        this.contentView = contentView;
    }

}
