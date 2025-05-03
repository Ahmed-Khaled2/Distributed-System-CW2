package Publisher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Publisher extends UnicastRemoteObject implements PublisherInterface {

    //Instance variables - Publisher's name
    //ArrayList - List to store sent notifications
    private String name;
    private ArrayList<String> notifications = new ArrayList<>();

    //Loaded Constructor - Initializes publisher their name 
    public Publisher(String name) throws RemoteException {
        super();
        this.name = name;
    }

    //getName - returns the name of the publisher 
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    //getNotifications - returns a list of all sent notifications
    @Override
    public ArrayList<String> getNotifications() throws RemoteException {
        return notifications;
    }

    //saveNotification - Called remotely by the Service when a new notification is sent
    //                   by a publisher, then the notification is stored in 'notifications'
    @Override
    public void saveNotification(String notification) throws RemoteException {
        notifications.add(notification);
    }
}
