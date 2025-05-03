package Starter;

import Publisher.PublisherWelcomeGUI;
import Subscriber.SubscriberWelcomeGUI;

public class StarterGUI extends javax.swing.JFrame {

    //Default Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    public StarterGUI() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        UserButton = new javax.swing.JButton();
        PublisherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Notification System");

        UserButton.setText("User");
        UserButton.setMaximumSize(new java.awt.Dimension(100, 100));
        UserButton.setMinimumSize(new java.awt.Dimension(100, 100));
        UserButton.setPreferredSize(new java.awt.Dimension(100, 100));
        UserButton.setRolloverEnabled(false);
        UserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserButtonActionPerformed(evt);
            }
        });

        PublisherButton.setText("Publisher");
        PublisherButton.setMaximumSize(new java.awt.Dimension(100, 100));
        PublisherButton.setMinimumSize(new java.awt.Dimension(100, 100));
        PublisherButton.setPreferredSize(new java.awt.Dimension(100, 100));
        PublisherButton.setRolloverEnabled(false);
        PublisherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
            .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Publisher Button - After clicking, this GUI gets closed and a new instance 
    //                   of PulisherWelcomeGUI is opened [login page for publishers]
    private void PublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherButtonActionPerformed
        PublisherWelcomeGUI PWGUI = new PublisherWelcomeGUI();
        PWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PublisherButtonActionPerformed

    //User Button - After clicking, this GUI gets closed and a new instance 
    //              of SubscriberWelcomeGUI is opened [login page for users]
    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        SubscriberWelcomeGUI SWGUI = new SubscriberWelcomeGUI();
        SWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PublisherButton;
    private javax.swing.JLabel Title;
    private javax.swing.JButton UserButton;
    // End of variables declaration//GEN-END:variables
}
