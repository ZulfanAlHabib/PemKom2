/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.util.Locale;
import java.util.ResourceBundle;
import object.FontSetting;

/**
 *
 * @author Zulfan
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        applyFont();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChooseLanguage = new javax.swing.JPanel();
        cmbChooseLanguage = new javax.swing.JComboBox<>();
        ChooseLanguage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblForgot = new javax.swing.JLabel();
        txtUsername = new java.awt.TextField();
        txtPassword = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblChooseLanguage.setBackground(new java.awt.Color(102, 204, 255));
        lblChooseLanguage.setMinimumSize(new java.awt.Dimension(100, 45));

        cmbChooseLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indonesia", "English", "Latin", "Sansekerta", " " }));
        cmbChooseLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbChooseLanguageActionPerformed(evt);
            }
        });

        ChooseLanguage.setText("jLabel1");

        javax.swing.GroupLayout lblChooseLanguageLayout = new javax.swing.GroupLayout(lblChooseLanguage);
        lblChooseLanguage.setLayout(lblChooseLanguageLayout);
        lblChooseLanguageLayout.setHorizontalGroup(
            lblChooseLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblChooseLanguageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ChooseLanguage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbChooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lblChooseLanguageLayout.setVerticalGroup(
            lblChooseLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblChooseLanguageLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(lblChooseLanguageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbChooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooseLanguage))
                .addGap(11, 11, 11))
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        btnLogin.setText("Login");

        lblPassword.setText("Password");

        lblUsername.setText("Username");

        lblForgot.setText("Forgot Password");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addComponent(lblForgot))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(lblPassword))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addGap(22, 22, 22)
                .addComponent(lblForgot)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addComponent(lblChooseLanguage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblChooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbChooseLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbChooseLanguageActionPerformed
        applyLanguage();
    }//GEN-LAST:event_cmbChooseLanguageActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChooseLanguage;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbChooseLanguage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel lblChooseLanguage;
    private javax.swing.JLabel lblForgot;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private java.awt.TextField txtPassword;
    private java.awt.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
private void applyFont() {
        try {
            FontSetting fs = new FontSetting("Code2000", 1, 14);
            fs.selectContainer(getContentPane());
        } catch (Exception e) {
            System.err.println("" + e.getMessage());
        }
    }

    private void applyLanguage() {
        String language;
        String country;
        Locale locale;
        int lang = cmbChooseLanguage.getSelectedIndex();
        try {
            switch (lang) {
                case 0:
                    language = "en";
                    country = "US";
                    break;
                case 1:
                    language = "in";
                    country = "ID";
                    break;
                case 2:
                    language = "es";
                    country = "ESP";
                    break;
                case 3:
                    language = "pr";
                    country = "PRA";
                    break;
                default:
                    language = "en";
                    country = "US";
                    break;
            }

            locale = new Locale(language, country);
            ResourceBundle rb
                    = ResourceBundle.getBundle("localization/Bundle", locale);

            ChooseLanguage.setText(rb.getString("LoginPage.lblChooseLanguage.text"));
            lblUsername.setText(rb.getString("LoginPage.lblUsername.text"));
            lblPassword.setText(rb.getString("LoginPage.lblPassword.text"));
            btnLogin.setText(rb.getString("LoginPage.btnLogin.text"));
            lblForgot.setText(rb.getString("LoginPage.lblForgot.text"));
            int cmbLN = cmbChooseLanguage.getItemCount();
            cmbChooseLanguage.removeAllItems();
            for (int i = 0; i < cmbLN; i++) {
                cmbChooseLanguage.addItem(rb.getString("cmbChooseLanguage." + i));
            }
            cmbChooseLanguage.setSelectedIndex(lang);
            setTitle(rb.getString("LoginPage.title"));
        } catch (Exception e) {
        }

    }}



