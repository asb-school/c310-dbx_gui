/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbx_gui;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jpa.Player;

/**
 *
 * @author asb
 */
public class LoginForm extends JPanel {
    
    public LoginForm() {
        initComponents();
        if (!Beans.isDesignTime()) {
           // Hide warning text
            errMsg.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("dbx_guiPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Player p");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        loginNameLabel = new javax.swing.JLabel();
        loginPasswordLabel = new javax.swing.JLabel();
        loginNameField = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        errMsg = new javax.swing.JLabel();
        loginPasswordField = new javax.swing.JPasswordField();

        FormListener formListener = new FormListener();

        loginNameLabel.setText("Login Name:");

        loginPasswordLabel.setText("Login Password:");

        loginNameField.addFocusListener(formListener);

        loginBtn.setText("Login");
        loginBtn.addActionListener(formListener);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Welcome to DBX GUI");

        jLabel2.setText("Please Login");

        errMsg.setForeground(new java.awt.Color(255, 0, 0));
        errMsg.setText("Access Denied! Please try again.");

        loginPasswordField.addFocusListener(formListener);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(loginNameLabel)
                                    .add(loginPasswordLabel))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(loginNameField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .add(loginPasswordField)))
                            .add(layout.createSequentialGroup()
                                .add(loginBtn)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(errMsg)))))
                .add(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 40, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loginNameLabel)
                    .add(loginNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loginPasswordLabel)
                    .add(loginPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(loginBtn)
                    .add(errMsg))
                .add(28, 28, 28))
        );
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.FocusListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == loginBtn) {
                LoginForm.this.loginBtnActionPerformed(evt);
            }
        }

        public void focusGained(java.awt.event.FocusEvent evt) {
            if (evt.getSource() == loginPasswordField) {
                LoginForm.this.changeErrorMsg(evt);
            }
            else if (evt.getSource() == loginNameField) {
                LoginForm.this.nameAction(evt);
            }
        }

        public void focusLost(java.awt.event.FocusEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    

           
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        // Get the username & pass from form
        String username = loginNameField.getText();
        String plainPassword = loginPasswordField.getText();
        
        // Being transaction
        entityManager.getTransaction().begin();
        
        // Query
        Query q = entityManager.createQuery("SELECT p FROM Player p WHERE p.loginName = :loginName");

        // Set params
        q.setParameter("loginName", username);
    
        // Create player object
        jpa.Player p = new jpa.Player();

        // Get query result, assign to player
        p = (jpa.Player) q.getSingleResult();

        // Get passwords
        String dbPassword = p.getLoginPassword();
        String hashedPassword = null;

        // Hash plain password
        try {
            hashedPassword = Global.hashMD5(plainPassword);
        } catch (Exception ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check if correct password
        if (hashedPassword.equals(dbPassword))
        {
            // Player is authenticated
            Global.is_player_authn = true;

            // Set globals
            Global.authn_player_id = p.getId();

            // Route to menu
            dbx_gui.WindowHandler.showMenuDialog();
        }
        else
        {
            errMsg.setVisible(true);
            System.out.println("Access denied");
            
        }

        // End transaction
        entityManager.getTransaction().commit();
        
        
    }//GEN-LAST:event_loginBtnActionPerformed

    private void changeErrorMsg(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_changeErrorMsg
        errMsg.setVisible(false);
    }//GEN-LAST:event_changeErrorMsg

    private void nameAction(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameAction
        errMsg.setVisible(false);
    }//GEN-LAST:event_nameAction

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel errMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.util.List<jpa.Player> list;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField loginNameField;
    private javax.swing.JLabel loginNameLabel;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JLabel loginPasswordLabel;
    private javax.persistence.Query query;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new LoginForm());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}