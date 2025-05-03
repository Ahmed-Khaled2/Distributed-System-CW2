package Publisher;

import java.util.ArrayList;
import java.rmi.RemoteException;
import MainService.ServiceInterface;
import Subscriber.SubscriberInterface;

public class PublisherMainGUI extends javax.swing.JFrame {

    //Instance variables - gives easier access to important variables across all the functions
    private PublisherInterface pub;
    private ServiceInterface serviceImp;
    private String selectedTopic = "General";
    private ArrayList<String> notifications = new ArrayList<>();
    private ArrayList<SubscriberInterface> subscribers = new ArrayList<>();

    //Loaded Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    //setText() - Initializes the text field responsle for the [Thank you message]
    //updateGUI() - Initializes the instance variables and updates the GUI
    public PublisherMainGUI(ServiceInterface serviceImp, PublisherInterface pub) throws RemoteException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        this.pub = pub;
        this.serviceImp = serviceImp;
        ThankYouMessage.setText("Thank you for using our notification system, " + pub.getName() + "!");

        updateGUI();
    }

    //updateGUI - Is responsible for calling [updateSubscribersList and updateNotifications]
    //            functions which update the entire GUI
    public void updateGUI() throws RemoteException {
        updateNotifications();
        updateSubscribersList();
    }

    //updateNotifications - This functions updates the list of sent notifications,
    //                      first getNotifications is called to fetch the latest 
    //                      notifications then displayed by creating a StringBuilder
    //                      which helps format the string then a for-loop is called
    //for-loop block - Iteraters over all the notifications and append them to the 'sb'
    //                 string followed by a new line
    //setText() - This function passes the created string to the component on the GUI
    public void updateNotifications() throws RemoteException {
        notifications = pub.getNotifications(selectedTopic);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < notifications.size(); i++) {
            sb.append(notifications.get(i)).append("\n");
        }

        NotificationsArea.setText(sb.toString());
    }

    //updateSubscribersList - This functions updates the list of the users
    //                        who are subscribed to this publisher, first
    //                        getPublisherSubscribers is called to fetch the
    //                        latest list of subscribers then displayed by
    //                        creating a list of String with similar size
    //                        as 'subscribers', then a for-loop is called
    //for-loop block - Iteraters over all the subscribed subscribers and gets 
    //                 their name, then these names are stored in the String list
    //setListData() - This function passes the created list to the component on the GUI
    public void updateSubscribersList() throws RemoteException {
        this.subscribers = serviceImp.getPublisherSubscribers(pub);

        String[] subscribersList = new String[subscribers.size()];

        for (int i = 0; i < subscribers.size(); i++) {
            subscribersList[i] = subscribers.get(i).getName();
        }

        SubscribersList.setListData(subscribersList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioButtonGroup = new javax.swing.ButtonGroup();
        NotificationTitle = new javax.swing.JLabel();
        SubscribersSubTitle = new javax.swing.JLabel();
        SubscribersListScroll = new javax.swing.JScrollPane();
        SubscribersList = new javax.swing.JList<>();
        HorizontalLine = new javax.swing.JSeparator();
        SubscribersTitle = new javax.swing.JLabel();
        VerticalLine = new javax.swing.JSeparator();
        NotificationsAreaScroll = new javax.swing.JScrollPane();
        NotificationsArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        ChatAreaScroll = new javax.swing.JScrollPane();
        ChatArea = new javax.swing.JTextArea();
        SendButton = new javax.swing.JButton();
        ThankYouMessage = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        Exams = new javax.swing.JRadioButton();
        Events = new javax.swing.JRadioButton();
        General = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NotificationTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NotificationTitle.setText("Notifications");

        SubscribersSubTitle.setText("This is a list of all subscribers");

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

        SubscribersTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SubscribersTitle.setText("Subscribers");

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

        RefreshButton.setText("Refresh List");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(Exams);
        Exams.setText("Exams");
        Exams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExamsActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(Events);
        Events.setText("Events");
        Events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventsActionPerformed(evt);
            }
        });

        RadioButtonGroup.add(General);
        General.setText("General");
        General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(SubscribersListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SubscribersSubTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RefreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3))
                    .addComponent(SubscribersTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VerticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ThankYouMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(ChatAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(HorizontalLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(NotificationTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Exams)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Events)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(General)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NotificationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubscribersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubscribersSubTitle)
                    .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubscribersListScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Exams)
                            .addComponent(Events)
                            .addComponent(General))
                        .addGap(5, 5, 5)
                        .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ChatAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThankYouMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VerticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Send Button - After clicking, the message wrote in the 'ChartArea' is fetched
    //              and stored in the publisher's arraylist of notifications, after
    //              that sendNotification function is called to send the notificaion
    //              to all the subscribers who are subscribed to this publisher. Lastly,
    //              updateNotifications is called
    //setText() - Clears the 'ChatArea' for easier usage after sending
    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        try {
            pub.saveNotification(selectedTopic, ChatArea.getText());
            serviceImp.sendNotification(pub, selectedTopic, ChatArea.getText());

            updateNotifications();
            ChatArea.setText(null);
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_SendButtonActionPerformed

    //Back Button - After clicking, this GUI gets closed and the previous GUI
    //              is opened again via a new instance
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        PublisherWelcomeGUI PWGUI = new PublisherWelcomeGUI();
        PWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    //Refresh Button - After clicking, updateSubscribersList() function is called 
    //                 which updates the list of subscribers in the GUI including
    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        try {
            updateSubscribersList();
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void ExamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExamsActionPerformed

        if (Exams.isSelected()) {
            selectedTopic = Exams.getText();
        }
    }//GEN-LAST:event_ExamsActionPerformed

    private void EventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EventsActionPerformed
        // TODO add your handling code here:
        if (Events.isSelected()) {
            selectedTopic = Events.getText();
        }
    }//GEN-LAST:event_EventsActionPerformed

    private void GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneralActionPerformed
        if (General.isSelected()) {
            selectedTopic = General.getText();
        }
    }//GEN-LAST:event_GeneralActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTextArea ChatArea;
    private javax.swing.JScrollPane ChatAreaScroll;
    private javax.swing.JRadioButton Events;
    private javax.swing.JRadioButton Exams;
    private javax.swing.JRadioButton General;
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel NotificationTitle;
    private javax.swing.JTextArea NotificationsArea;
    private javax.swing.JScrollPane NotificationsAreaScroll;
    private javax.swing.ButtonGroup RadioButtonGroup;
    private javax.swing.JButton RefreshButton;
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
