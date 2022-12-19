package GUI;
import classes.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        textFieldUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(500, 190));
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Username");

        buttonLogin.setBackground(new java.awt.Color(0, 51, 51));
        buttonLogin.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin.setText("Login");
        buttonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(0, 51, 51));
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setText("Reset");
        buttonReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        textFieldUsername.setBackground(new java.awt.Color(0, 102, 102));
        textFieldUsername.setForeground(new java.awt.Color(255, 255, 255));
        textFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldUsernameActionPerformed(evt);
            }
        });
        textFieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textFieldUsernameKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Password");

        buttonPass.setBackground(new java.awt.Color(0, 102, 102));
        buttonPass.setForeground(new java.awt.Color(255, 255, 255));
        buttonPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonPassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 2, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonPass, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        adminClass x = new adminClass();
        employee y = new employee();
        leader z = new leader();

        if (x.login(textFieldUsername.getText(), buttonPass.getText())){
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, " Logged in successfully",null, JOptionPane.INFORMATION_MESSAGE);
            new AdminForm().setVisible(true);
        }

        if(y.logIn(textFieldUsername.getText(), buttonPass.getText())) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, " Logged in successfully ","Error", JOptionPane.INFORMATION_MESSAGE);
            new employeeForm().setVisible(true);
        }


        else if(z.login(textFieldUsername.getText(), buttonPass.getText())) {
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, " Logged in successfully ",null, JOptionPane.INFORMATION_MESSAGE);
            new leaderForm().setVisible(true);
        }

        else {
            JOptionPane.showMessageDialog(null, "invalid information", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void textFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {
        textFieldUsername.setText(null);
        buttonPass.setText(null);
    }

    private void buttonPassKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            adminClass x = new adminClass();
            employee y = new employee();
            leader z = new leader();

            if (x.login(textFieldUsername.getText(), buttonPass.getText())){
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, " Logged in successfully",null, JOptionPane.INFORMATION_MESSAGE);
                new AdminForm().setVisible(true);
            }

            else if(y.logIn(textFieldUsername.getText(), buttonPass.getText())) {
                this.setVisible(false);

                JOptionPane.showMessageDialog(null, " Logged in successfully ",null, JOptionPane.INFORMATION_MESSAGE);
                new employeeForm().setVisible(true);

            }

            else if(z.login(textFieldUsername.getText(), buttonPass.getText())) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, " Logged in successfully ",null, JOptionPane.INFORMATION_MESSAGE);
                new leaderForm().setVisible(true);
            }

            else {
                JOptionPane.showMessageDialog(null, "invalid information", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void textFieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            adminClass x = new adminClass();
            employee y = new employee();
            leader z = new leader();

            if (x.login(textFieldUsername.getText(), buttonPass.getText())){
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, " Logged in successfully",null, JOptionPane.INFORMATION_MESSAGE);
                new AdminForm().setVisible(true);
            }

            else if(y.logIn(textFieldUsername.getText(), buttonPass.getText())) {
                this.setVisible(false);

                JOptionPane.showMessageDialog(null, " Logged in successfully ",null, JOptionPane.INFORMATION_MESSAGE);
                new employeeForm().setVisible(true);

            }

            else if(z.login(textFieldUsername.getText(), buttonPass.getText())) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, " Logged in successfully ",null, JOptionPane.INFORMATION_MESSAGE);
                new leaderForm().setVisible(true);
            }

            else {
                JOptionPane.showMessageDialog(null, "invalid information", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton buttonLogin;
    private javax.swing.JPasswordField buttonPass;
    private javax.swing.JButton buttonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textFieldUsername;
    // End of variables declaration
}
