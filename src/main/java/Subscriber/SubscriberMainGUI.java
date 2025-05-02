package Subscriber;

import MainService.ServiceInterface;
import Publisher.PublisherInterface;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SubscriberMainGUI extends javax.swing.JFrame {

    //Instance variables - gives easier access to important variables across all the functions
    private SubscriberInterface Sub;
    private ServiceInterface obj;
    private ArrayList<String> notifications = new ArrayList<>();
    private ArrayList<PublisherInterface> availablePublishers = new ArrayList<>();
    private ArrayList<PublisherInterface> currentPublishers = new ArrayList<>();

    //Loaded Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    //setText() - Initializes the text field responsle for the [Thank you message]
    //UpdateGUI() - Initializes the instance variables and updates the GUI
    public SubscriberMainGUI(ServiceInterface obj, SubscriberInterface Sub) throws RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        this.obj = obj;
        this.Sub = Sub;
        ThankYouMessage.setText("Thank you for using our notification system, " + Sub.getName() + " !");

        updateGUI();
    }

    //UpdateGUI - Is responsible for calling [updateCurrentPublishers, updateAvailablePublishers,
    //            and updateNotifications] functions which update the entire GUI
    public void updateGUI() throws RemoteException {
        updateLists();
        updateCurrentPublishers();
        updateAvailablePublishers();
        updateNotifications();
    }

    //updateNotifications - This functions updates the list of available publishers 
    //                      by creating a StringBuilder with which helps format the
    //                      string then a for-loop is called
    //for-loop block - Iteraters over all the notifications and append them to the 'sb'
    //                 string followed by a new line
    //setText() - This function passes the created string to the component on the GUI
    public void updateNotifications() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < notifications.size(); i++) {
            sb.append(notifications.get(i)).append("\n");
        }

        NotificationsArea.setText(sb.toString());
    }

    //updateNotifications - Initializes [availablePublishers, notifications, and
    //                      currentPublishers] by using [getPublishers, getNotifications,
    //                      and getSubscriptions functions via the remote object
    //removeAll() - This function removes the current publishers from the available publishers
    //              basically, getting the difference between them
    public void updateLists() throws RemoteException {
        this.availablePublishers = obj.getPublishers();
        this.notifications = Sub.getNotifications();
        this.currentPublishers = obj.getSubscriptions((SubscriberInterface) Sub);

        availablePublishers.removeAll(currentPublishers);
    }

    //Updates available publishers list - This functions updates the list of available
    //                                    publishers by creating a list of String with
    //                                    similar size as 'availablePublishers', then a
    //                                    for-loop is called
    //for-loop block - Iteraters over all the available publishers and gets their name
    //                 then these names are stored in the String list
    //setListData() - This function passes the created list to the component on the GUI
    public void updateAvailablePublishers() throws RemoteException {
        String[] availablePublisherList = new String[availablePublishers.size()];

        for (int i = 0; i < availablePublishers.size(); i++) {
            availablePublisherList[i] = availablePublishers.get(i).getName();
        }

        AvailablePublishers.setListData(availablePublisherList);
    }

    //Updates current publishers list - This functions updates the list of current
    //                                  publishers by creating a list of String with
    //                                  similar size as 'currentPublishers', then a
    //                                  for-loop is called
    //for-loop block - Iteraters over all the current publishers and gets their name
    //                 then these names are stored in the String list
    //setListData() - This function passes the created list to the component on the GUI
    public void updateCurrentPublishers() throws RemoteException {
        String[] currentPublisherList = new String[currentPublishers.size()];

        for (int i = 0; i < currentPublishers.size(); i++) {
            currentPublisherList[i] = currentPublishers.get(i).getName();
        }

        CurrentPublishers.setListData(currentPublisherList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PublishersTitle = new javax.swing.JLabel();
        NotificationTitle = new javax.swing.JLabel();
        PublishersSubTitle = new javax.swing.JLabel();
        AvaliablePublishersTitle = new javax.swing.JLabel();
        AvaliablePublishersSubTitle = new javax.swing.JLabel();
        CurrentPublishersScroll = new javax.swing.JScrollPane();
        CurrentPublishers = new javax.swing.JList<>();
        HorizontalLine = new javax.swing.JSeparator();
        VerticalLine = new javax.swing.JSeparator();
        NotificationsAreaScroll = new javax.swing.JScrollPane();
        NotificationsArea = new javax.swing.JTextArea();
        BackButton = new javax.swing.JButton();
        ThankYouMessage = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AvailablePublishers = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PublishersTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PublishersTitle.setText("Publishers");

        NotificationTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NotificationTitle.setText("Notifications");

        PublishersSubTitle.setText("Publishers you are subscribed to");

        AvaliablePublishersTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AvaliablePublishersTitle.setText("Avaliable Publishers");

        AvaliablePublishersSubTitle.setText("Click on a publisher to subscribe to");

        CurrentPublishers.setBorder(null);
        CurrentPublishers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        CurrentPublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CurrentPublishersMouseClicked(evt);
            }
        });
        CurrentPublishersScroll.setViewportView(CurrentPublishers);

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

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ThankYouMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ThankYouMessage.setText("Thank you for using our notification system, Ahmed!");

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        AvailablePublishers.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        AvailablePublishers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AvailablePublishersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(AvailablePublishers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(PublishersTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(CurrentPublishersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AvaliablePublishersSubTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PublishersSubTitle)
                                    .addComponent(AvaliablePublishersTitle)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NotificationTitle)
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ThankYouMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(HorizontalLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(211, 211, 211)
                    .addComponent(VerticalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(343, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PublishersTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NotificationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PublishersSubTitle)
                        .addGap(18, 18, 18)
                        .addComponent(CurrentPublishersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvaliablePublishersTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AvaliablePublishersSubTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HorizontalLine, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NotificationsAreaScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ThankYouMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(VerticalLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Back Button - After clicking, this GUI gets closed and the previous GUI
    //              is opened again via a new instance
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        SubscriberWelcomeGUI SWGUI = new SubscriberWelcomeGUI();
        SWGUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    //Unsubscribing from a publisher - After clicking on a publisher via a mouse click
    //                                 the name of the publisher is retrived and stored
    //                                 in 'Selected', and a pop-up message appears to
    //                                 confirm the unsubscription. After clicking 'Yes'
    //                                 a for-loop is called.
    //for-loop block - Iteraters over all the avaliable publishers to find the publisher
    //                 with the same name as 'Selected', after it's found another pop-up
    //                 message apears to confirm the unsubscription. Then, unsubscribe()
    //                 function is called to remove from the Service that this user was
    //                 subscribed to the selected publisher. At last, UpdateGUI function
    //                 is called to update the GUI
    private void CurrentPublishersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CurrentPublishersMouseClicked
        String selected = CurrentPublishers.getSelectedValue();
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to unsubscribe from " + selected + "?", "Confirm Subscription", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            for (int i = 0; i < currentPublishers.size(); i++) {
                try {
                    if (currentPublishers.get(i).getName().equals(selected)) {
                        obj.unsubscribe(Sub, currentPublishers.get(i));
                        JOptionPane.showMessageDialog(this, "You have unsubscribed from " + selected);
                        updateGUI();
                        break;
                    }
                } catch (RemoteException ex) {
                }
            }
        }
    }//GEN-LAST:event_CurrentPublishersMouseClicked

    //Subscribing to a publisher - After clicking on a publisher via a mouse click
    //                             the name of the publisher is retrived and stored
    //                             in 'Selected', and a pop-up message appears to
    //                             confirm the subscription. After clicking 'Yes'
    //                             a for-loop is called.
    //for-loop block - Iteraters over all the avaliable publishers to find the publisher
    //                 with the same name as 'Selected', after it's found another pop-up
    //                 message apears to confirm the subscription. Then, subscribe()
    //                 function is called to store in the Service that this user
    //                 subscribed to the selected publisher. At last, UpdateGUI function
    //                 is called to update the GUI
    private void AvailablePublishersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AvailablePublishersMouseClicked
        String selected = AvailablePublishers.getSelectedValue();
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to subscribe to " + selected + "?", "Confirm Subscription", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            for (int i = 0; i < availablePublishers.size(); i++) {
                try {
                    if (availablePublishers.get(i).getName().equals(selected)) {
                        obj.subscribe(Sub, availablePublishers.get(i));
                        JOptionPane.showMessageDialog(this, "You are now subscribed to " + selected);
                        updateGUI();
                        break;
                    }
                } catch (RemoteException ex) {
                }
            }
        }
    }//GEN-LAST:event_AvailablePublishersMouseClicked

    //Refresh Button - After clicking, UpdateGUI() function is called which
    //                 updates everything in the GUI including [Notifications,
    //                 Avaliable Publishers, and Current Publishers]
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        try {
            updateGUI();
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_RefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AvailablePublishers;
    private javax.swing.JLabel AvaliablePublishersSubTitle;
    private javax.swing.JLabel AvaliablePublishersTitle;
    private javax.swing.JButton BackButton;
    private javax.swing.JList<String> CurrentPublishers;
    private javax.swing.JScrollPane CurrentPublishersScroll;
    private javax.swing.JSeparator HorizontalLine;
    private javax.swing.JLabel NotificationTitle;
    private javax.swing.JTextArea NotificationsArea;
    private javax.swing.JScrollPane NotificationsAreaScroll;
    private javax.swing.JLabel PublishersSubTitle;
    private javax.swing.JLabel PublishersTitle;
    private javax.swing.JButton Refresh;
    private javax.swing.JLabel ThankYouMessage;
    private javax.swing.JSeparator VerticalLine;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
