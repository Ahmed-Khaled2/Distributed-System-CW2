package Publisher;

import MainService.ServiceInterface;
import Subscriber.SubscriberInterface;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class PublisherMainGUI extends javax.swing.JFrame {

    private ServiceInterface obj;
    private Publisher Pub;
    private ArrayList<String> notifications = new ArrayList<>();
    private ArrayList<SubscriberInterface> subscribers = new ArrayList<>();

    public PublisherMainGUI() {
        initComponents();
    }

    public PublisherMainGUI(ServiceInterface obj, Publisher Pub) throws RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        this.obj = obj;
        this.Pub = Pub;
        ThankYouMessage.setText("Thank you for using our notification system, " + Pub.getName() + "!");
        updateGUI();
    }

    public void updateGUI() throws RemoteException {
        updateNotifications();
        updateSubscribersList();
    }

    public void updateNotifications() {
        notifications = Pub.getNotifications();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notifications.size(); i++) {
            sb.append(notifications.get(i)).append("\n");
        }
        NotificationsArea.setText(sb.toString());
    }

    public void updateSubscribersList() throws RemoteException {
        String[] subscribersList = new String[subscribers.size()];
        for (int i = 0; i < subscribers.size(); i++) {
            subscribersList[i] = subscribers.get(i).getName();
        }
        SubscribersList.setListData(subscribersList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubscribersTitle = new javax.swing.JLabel();
        NotificationTitle = new javax.swing.JLabel();
        SubscribersSubTitle = new javax.swing.JLabel();
        SubscribersListScroll = new javax.swing.JScrollPane();
        SubscribersList = new javax.swing.JList<>();
        HorizontalLine = new javax.swing.JSeparator();
        VerticalLine = new javax.swing.JSeparator();
        NotificationsAreaScroll = new javax.swing.JScrollPane();
        NotificationsArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        ChatAreaScroll = new javax.swing.JScrollPane();
        ChatArea = new javax.swing.JTextArea();
        SendButton = new javax.swing.JButton();
        ThankYouMessage = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SubscribersTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SubscribersTitle.setText("Subscribers");

        NotificationTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NotificationTitle.setText("Notifications");

        SubscribersSubTitle.setText("This is a list of all current subscribers");

        SubscribersList.setBorder(null);
        SubscribersList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SubscribersListScroll.setViewportView(SubscribersList);

        HorizontalLine.setToolTipText("");
        HorizontalLine.setAlignmentX(2.0F);
        HorizontalLine.setAlignmentY(2.0F);
        HorizontalLine.setAutoscrolls(true);
        HorizontalLine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        VerticalLine.setOrientation(javax.swing.SwingConstants.VERTICAL);
        VerticalLine.setToolTipText("");
        VerticalLine.setAlignmentX(2.0F);
        VerticalLine.setAlignmentY(2.0F);
        VerticalLine.setAutoscrolls(true);
        VerticalLine.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        NotificationsArea.setEditable(false);
        NotificationsArea.setColumns(20);
        NotificationsArea.setRows(5);
        NotificationsAreaScroll.setViewportView(NotificationsArea);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ChatAreaScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ChatArea.setColumns(20);
        ChatArea.setRows(5);
        ChatArea.setAutoscrolls(false);
        ChatAreaScroll.setViewportView(ChatArea);

        SendButton.setText("Send");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        ThankYouMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThankYouMessage.setText("Thank you for using our notification system, Ahmed!");

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SubscribersSubTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(SubscribersTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(SubscribersListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NotificationTitle)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ChatAreaScroll)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(ThankYouMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SendButton)
                                        .addComponent(BackButton)))))
                        .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(211, 211, 211)
                    .addComponent(VerticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubscribersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NotificationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubscribersSubTitle)
                        .addGap(18, 18, 18)
                        .addComponent(SubscribersListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ChatAreaScroll)
                            .addComponent(SendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ThankYouMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(VerticalLine, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        try {
            Pub.saveNotification(ChatArea.getText());
            obj.sendNotification(Pub, ChatArea.getText());
            updateNotifications();
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_SendButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        PublisherWelcomeGUI PWGUI = new PublisherWelcomeGUI();
        PWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PublisherMainGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTextArea ChatArea;
    private javax.swing.JScrollPane ChatAreaScroll;
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel NotificationTitle;
    private javax.swing.JTextArea NotificationsArea;
    private javax.swing.JScrollPane NotificationsAreaScroll;
    private javax.swing.JButton SendButton;
    private javax.swing.JList<String> SubscribersList;
    private javax.swing.JScrollPane SubscribersListScroll;
    private javax.swing.JLabel SubscribersSubTitle;
    private javax.swing.JLabel SubscribersTitle;
    private javax.swing.JLabel ThankYouMessage;
    private javax.swing.JSeparator VerticalLine;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
