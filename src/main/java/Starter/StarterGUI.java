package Starter;

import Publisher.PublisherWelcomeGUI;
import Subscriber.SubscriberWelcomeGUI;

public class StarterGUI extends javax.swing.JFrame {

    public StarterGUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        UserButton = new javax.swing.JButton();
        PublisherButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PublisherButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Title)))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void PublisherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublisherButtonActionPerformed
        PublisherWelcomeGUI PWGUI = new PublisherWelcomeGUI();
        PWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_PublisherButtonActionPerformed

    private void UserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserButtonActionPerformed
        SubscriberWelcomeGUI SWGUI = new SubscriberWelcomeGUI();
        SWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UserButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StarterGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PublisherButton;
    private javax.swing.JLabel Title;
    private javax.swing.JButton UserButton;
    // End of variables declaration//GEN-END:variables
}
