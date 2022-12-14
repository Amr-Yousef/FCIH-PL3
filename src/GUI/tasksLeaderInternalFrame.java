/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author Moaaz Mostafa
 */
public class tasksLeaderInternalFrame extends javax.swing.JInternalFrame {


    GridBagLayout layout = new GridBagLayout();
    addTaskLeaderPanel addTaskPnl;
    updateDeleteTaskPanel upDelTaskPnl;
    showTasksLeaderAdminInternalFrame showPnl;
    public tasksLeaderInternalFrame() {
        initComponents();
        addTaskPnl = new addTaskLeaderPanel();
        upDelTaskPnl = new updateDeleteTaskPanel();
        showPnl = new showTasksLeaderAdminInternalFrame();
        DynamicPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        DynamicPanel.add(addTaskPnl , c);
        DynamicPanel.add(upDelTaskPnl , c);
        DynamicPanel.add(showPnl , c);
        addTaskPnl.setVisible(false);
        upDelTaskPnl.setVisible(false);
        showPnl.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showTasksButton = new javax.swing.JButton();
        addTaskButton = new javax.swing.JButton();
        upDelTaskButton = new javax.swing.JButton();
        DynamicPanel = new javax.swing.JPanel();

        setClosable(true);
        setTitle("Tasks Management");

        showTasksButton.setText("Show Tasks");
        showTasksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTasksButtonActionPerformed(evt);
            }
        });

        addTaskButton.setText("Add Task");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        upDelTaskButton.setText("U&D Task");
        upDelTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upDelTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(upDelTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(showTasksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showTasksButton)
                    .addComponent(addTaskButton)
                    .addComponent(upDelTaskButton))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        DynamicPanel.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout DynamicPanelLayout = new javax.swing.GroupLayout(DynamicPanel);
        DynamicPanel.setLayout(DynamicPanelLayout);
        DynamicPanelLayout.setHorizontalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );
        DynamicPanelLayout.setVerticalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        getContentPane().add(DynamicPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showTasksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTasksButtonActionPerformed
        addTaskPnl.setVisible(false);
        upDelTaskPnl.setVisible(false);
        showPnl.setVisible(true);
    }//GEN-LAST:event_showTasksButtonActionPerformed

    private void upDelTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upDelTaskButtonActionPerformed
        addTaskPnl.setVisible(false);
        upDelTaskPnl.setVisible(true);
        showPnl.setVisible(false);
    }//GEN-LAST:event_upDelTaskButtonActionPerformed

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        addTaskPnl.setVisible(true);
        upDelTaskPnl.setVisible(false);
        showPnl.setVisible(false);
    }//GEN-LAST:event_addTaskButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JButton addTaskButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showTasksButton;
    private javax.swing.JButton upDelTaskButton;
    // End of variables declaration//GEN-END:variables
}
