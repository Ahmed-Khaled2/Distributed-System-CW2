package Subscriber;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Subscriber extends UnicastRemoteObject implements SubscriberInterface {

    //Instance variables - Subscriber's name and ID
    //ArrayList - List to store received notifications
    private String name;
    private int id;
    private ArrayList<String> notifications = new ArrayList<>();

    //Loaded Constructor - Initializes subscriber with name and ID
    public Subscriber(String name, int id) throws RemoteException {
        this.name = name;
        this.id = id;
    }

    //receiveNotification - Called remotely by the Service when a new notification is sent
    //                      to a subscriber, then the notification is stored in 'notifications'
    @Override
    public void receiveNotification(String notification) throws RemoteException {
        notifications.add(notification);
    }

    //getNotifications - returns a list of all recevied notifications
    @Override
    public ArrayList<String> getNotifications() throws RemoteException {
        return notifications;
    }

    //getName - returns the name of the subscriber 
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    //getID - returns the id of the subscriber 
    @Override
    public int getId() throws RemoteException {
        return id;
    }
}
