package MainService;

import java.util.ArrayList;
import java.rmi.RemoteException;
import Publisher.PublisherInterface;
import javax.swing.table.DefaultTableModel;

public class SubscriberDetailsGUI extends javax.swing.JFrame {

    //Instance variables - gives easier access to important variables across all the functions
    private int id;
    private String name;
    private ServiceImplementation ServiceImp;
    private ArrayList<PublisherInterface> Publishers;

    //Loaded Constructor - Initializes the GUI with required components
    //initComponents() - Generates GUI component's code and properties
    //setLocationRelativeTo(null) - Center the GUI on the screen
    //setResizable(false) - Disable resizing of the GUI
    //javax.swing.UIManager.setLookAndFeel() - Improves the UI of the GUI components by matching the system's UI
    //setText() - Initializes the text field responsle for the subscriber's name and id
    //updateGUI() - Initializes the instance variables and updates the GUI
    public SubscriberDetailsGUI(ServiceImplementation obj, String subscriberName, int subscriberID) throws RemoteException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        this.ServiceImp = obj;
        this.name = subscriberName;
        this.id = subscriberID;

        Name.setText("Subscriber Name: " + name);
        ID.setText("Subscriber ID: " + id);

        updatePublishers();
    }

    //updatePublishers - This function updates the table of the publishers that
    //                   this subscriber is subscribed to
    //getSubscriptions - Gets the list of all subscribed to publishers
    //DefaultTableModel - Gets the current table model from the GUI
    //model.setRowCount() - Clear all the existing rows from the table
    //for-loop block - Iteraters over all the publishers and gets their name and
    //                 number of subscribers
    //model.addRow() - Adds a new row to the table with the publisher's name and
    //                 number of subscribers
    public void updatePublishers() throws RemoteException {
        this.Publishers = ServiceImp.getSubscriptions(ServiceImp.getSubscriber(name, id));

        DefaultTableModel model = (DefaultTableModel) PublishersList.getModel();
        model.setRowCount(0);

        for (int i = 0; i < Publishers.size(); i++) {
            String Name = Publishers.get(i).getName();
            int NumberOfSubscribers = ServiceImp.getNumberOfSubscribers(Publishers.get(i).getName());

            model.addRow(new Object[]{Name, NumberOfSubscribers});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        ListOfPublishers = new javax.swing.JScrollPane();
        PublishersList = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        TableTitle = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PublishersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "NumberOfSubscribers"
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
        ListOfPublishers.setViewportView(PublishersList);
        if (PublishersList.getColumnModel().getColumnCount() > 0) {
            PublishersList.getColumnModel().getColumn(0).setResizable(false);
            PublishersList.getColumnModel().getColumn(1).setResizable(false);
        }

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Subscriber Details");

        Name.setText("Subscriber Name: ");

        ID.setText("Subscribers ID:");

        TableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TableTitle.setText("List of all publishers this user is subscribed to");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TableTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                .addComponent(ListOfPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Name)
                                .addComponent(ID))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(ExitButton)
                        .addGap(86, 86, 86)))
                .addContainerGap(34, Short.MAX_VALUE))
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
                .addComponent(ID)
                .addGap(18, 18, 18)
                .addComponent(TableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListOfPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel ID;
    private javax.swing.JScrollPane ListOfPublishers;
    private javax.swing.JLabel Name;
    private javax.swing.JTable PublishersList;
    private javax.swing.JLabel TableTitle;
    private javax.swing.JLabel Title;
    private javax.swing.JInternalFrame jInternalFrame1;
    // End of variables declaration//GEN-END:variables
}