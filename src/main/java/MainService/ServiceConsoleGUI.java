package MainService;

import java.util.ArrayList;
import java.rmi.RemoteException;
import Publisher.PublisherInterface;
import Subscriber.SubscriberInterface;
import javax.swing.table.DefaultTableModel;

public class ServiceConsoleGUI extends javax.swing.JFrame {

    //Instance variables - gives easier access to important variables across all the functions
    private ServiceImplementation serviceImp;
    private ArrayList<PublisherInterface> publishers;
    private ArrayList<SubscriberInterface> subscribers;

    //Loaded Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    //updateGUI() - Initializes the instance variables and updates the GUI
    public ServiceConsoleGUI(ServiceImplementation serviceImp) throws RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }
        
        this.serviceImp = serviceImp;
        
        updateGUI();
    }
    
    //updateGUI - Is responsible for calling [updateList, updateUserTable,
    //            and updatePublisherTable] functions which update the entire
    //            GUI and necessary variables 
    public void updateGUI() throws RemoteException {
        updateList();
        updateUserTable();
        updatePublisherTable();
    }

    //updateLists - Initializes [subscribers and publishers] by using
    //              [getSubscribers, getPublishers] functions via the remote object
    public void updateList() throws RemoteException {
        this.subscribers = serviceImp.getSubscribers();
        this.publishers = serviceImp.getPublishers();
    }

    //updateUserTable - This function updates the table of the all the 
    //                  registered subscribers
    //DefaultTableModel - Gets the current table model from the GUI
    //model.setRowCount() - Clear all the existing rows from the table
    //for-loop block - Iteraters over all the registered subscribers and 
    //                 gets their name and id
    //model.addRow() - Adds a new row to the table with the subscriber's 
    //                 name and id
    public void updateUserTable() throws RemoteException {
        DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < subscribers.size(); i++) {
            String Name = subscribers.get(i).getName();
            int ID = subscribers.get(i).getId();
            
            model.addRow(new Object[]{Name, ID});
        }
    }

    //updatePublisherTable - This function updates the table of the all the 
    //                       registered publishers
    //DefaultTableModel - Gets the current table model from the GUI
    //model.setRowCount() - Clear all the existing rows from the table
    //for-loop block - Iteraters over all the registered publishers and 
    //                 gets their name
    //model.addRow() - Adds a new row to the table with the publishers's name
    public void updatePublisherTable() throws RemoteException {
        DefaultTableModel model = (DefaultTableModel) PublishersTable.getModel();
        model.setRowCount(0);

        for (int i = 0; i < publishers.size(); i++) {
            String Name = publishers.get(i).getName();
            int NumberOfSubscribers = serviceImp.getNumberOfSubscribers(publishers.get(i).getName());
            
            model.addRow(new Object[]{Name, NumberOfSubscribers});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PublishersTable = new javax.swing.JTable();
        UsersTableScroll = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        PublisherTitle = new javax.swing.JLabel();
        ServiceTitle = new javax.swing.JLabel();
        UsersTitle = new javax.swing.JLabel();
        UsersSubTitle = new javax.swing.JLabel();
        PublisherSubTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PublishersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Number of Subscribers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PublishersTable.setColumnSelectionAllowed(true);
        PublishersTable.getTableHeader().setReorderingAllowed(false);
        PublishersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PublishersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PublishersTable);
        PublishersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (PublishersTable.getColumnModel().getColumnCount() > 0) {
            PublishersTable.getColumnModel().getColumn(0).setResizable(false);
            PublishersTable.getColumnModel().getColumn(1).setResizable(false);
        }

        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        UsersTable.setColumnSelectionAllowed(true);
        UsersTable.getTableHeader().setReorderingAllowed(false);
        UsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersTableMouseClicked(evt);
            }
        });
        UsersTableScroll.setViewportView(UsersTable);
        UsersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (UsersTable.getColumnModel().getColumnCount() > 0) {
            UsersTable.getColumnModel().getColumn(0).setResizable(false);
            UsersTable.getColumnModel().getColumn(1).setResizable(false);
        }

        PublisherTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PublisherTitle.setText("Avaliable Publishers");

        ServiceTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ServiceTitle.setText("Service Console");

        UsersTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        UsersTitle.setText("Avaliable Users");

        UsersSubTitle.setText("Click on a user to get more details about them");

        PublisherSubTitle.setText("Click on a publisher to get more details about them");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UsersTableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(UsersTitle))
                            .addComponent(UsersSubTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PublisherTitle)
                                .addGap(16, 16, 16))
                            .addComponent(PublisherSubTitle, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(ServiceTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(ServiceTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UsersTitle)
                        .addGap(7, 7, 7)
                        .addComponent(UsersSubTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PublisherTitle)
                        .addGap(7, 7, 7)
                        .addComponent(PublisherSubTitle)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UsersTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Selecting A User - After clicking on a user, their name and id are fetched
    //                   from the table's row and stored in 'subName' and 'subID'
    //SubscriberDetailsGUI SDGUI - Opens the subscriber details GUI and passes the
    //                             remote object 'serviceImp', 'subName', and 'subID'
    private void UsersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersTableMouseClicked
        String subName = UsersTable.getValueAt(UsersTable.getSelectedRow(), 0).toString();
        int subID = (Integer) UsersTable.getValueAt(UsersTable.getSelectedRow(), 1);
        
        try {
            SubscriberDetailsGUI SDGUI = new SubscriberDetailsGUI(serviceImp, subName, subID);
            SDGUI.setVisible(true);
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_UsersTableMouseClicked

    //Selecting A Publisher - After clicking on a publisher, their name and number of
    //                        subscribers are fetched from the table's row and stored
    //                        in 'pubName' and 'numberOfSubscribers'
    //PublisherDetailsGUI PDGUI - Opens the publisher details GUI and passes the remote
    //                            object 'serviceImp', 'subName', and 'numberOfSubscribers'
    private void PublishersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PublishersTableMouseClicked
        String pubName = PublishersTable.getValueAt(PublishersTable.getSelectedRow(), 0).toString();
        int numberOfSubscribers = (Integer) PublishersTable.getValueAt(PublishersTable.getSelectedRow(), 1);
        
        try {
            PublisherDetailsGUI PDGUI = new PublisherDetailsGUI(serviceImp, pubName, numberOfSubscribers);
            PDGUI.setVisible(true);
        } catch (RemoteException ex) {
        }
    }//GEN-LAST:event_PublishersTableMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PublisherSubTitle;
    private javax.swing.JLabel PublisherTitle;
    private javax.swing.JTable PublishersTable;
    private javax.swing.JLabel ServiceTitle;
    private javax.swing.JLabel UsersSubTitle;
    private javax.swing.JTable UsersTable;
    private javax.swing.JScrollPane UsersTableScroll;
    private javax.swing.JLabel UsersTitle;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}