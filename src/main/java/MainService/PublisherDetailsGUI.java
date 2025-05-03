package MainService;

import java.util.ArrayList;
import java.rmi.RemoteException;
import Subscriber.SubscriberInterface;
import javax.swing.table.DefaultTableModel;

public class PublisherDetailsGUI extends javax.swing.JFrame {

    //Instance variables - gives easier access to important variables across all the functions
    private String publisherName;
    private ServiceImplementation serviceImp;
    private ArrayList<SubscriberInterface> subscribers;

    //Loaded Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    //setText() - Initializes the text field responsle for the publishers's name and number of subscribers
    //updateGUI() - Initializes the instance variables and updates the GUI
    public PublisherDetailsGUI(ServiceImplementation serviceImp, String publisherName, int numberOfSubscribres) throws RemoteException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        this.serviceImp = serviceImp;
        this.publisherName = publisherName;

        Name.setText("Publisher Name: " + publisherName);
        NumberOfSubscribers.setText("Number of Subscribers: " + numberOfSubscribres);

        updateSubscribers();
    }

    //updateSubscribers - This function updates the table of the subscribers that
    //                    are subscribered to this publisher
    //getPublisherSubscribers - Gets the list of all subscribers that are subscribered
    //                          to this publisher
    //DefaultTableModel - Gets the current table model from the GUI
    //model.setRowCount() - Clear all the existing rows from the table
    //for-loop block - Iteraters over all the subscribers and gets their name and id
    //model.addRow() - Adds a new row to the table with the subscriber's name and id
    public void updateSubscribers() throws RemoteException {
        this.subscribers = serviceImp.getPublisherSubscribers(serviceImp.getPublisher(publisherName));

        DefaultTableModel model = (DefaultTableModel) ListOfSubscribers.getModel();
        model.setRowCount(0);

        for (int i = 0; i < subscribers.size(); i++) {
            String Name = subscribers.get(i).getName();
            int ID = subscribers.get(i).getId();

            model.addRow(new Object[]{Name, ID});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListOfSubscribersScroll = new javax.swing.JScrollPane();
        ListOfSubscribers = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        NumberOfSubscribers = new javax.swing.JLabel();
        TableTitle = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ListOfSubscribers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
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
        ListOfSubscribersScroll.setViewportView(ListOfSubscribers);
        if (ListOfSubscribers.getColumnModel().getColumnCount() > 0) {
            ListOfSubscribers.getColumnModel().getColumn(0).setResizable(false);
            ListOfSubscribers.getColumnModel().getColumn(1).setResizable(false);
        }

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Publisher Details");

        Name.setText("Publisher Name: ");

        NumberOfSubscribers.setText("Number of Subscribers:");

        TableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TableTitle.setText("List of all users who are subscribed to this publisher");

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumberOfSubscribers)
                            .addComponent(Name)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(ExitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ListOfSubscribersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(TableTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Title)
                .addGap(18, 18, 18)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumberOfSubscribers)
                .addGap(18, 18, 18)
                .addComponent(TableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListOfSubscribersScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
//Exit Button - After clicking, this GUI gets closed
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JTable ListOfSubscribers;
    private javax.swing.JScrollPane ListOfSubscribersScroll;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel NumberOfSubscribers;
    private javax.swing.JLabel TableTitle;
    private javax.swing.JLabel Title;
    // End of variables declaration//GEN-END:variables
}
