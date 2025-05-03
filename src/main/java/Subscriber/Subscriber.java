package Subscriber;

import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Subscriber extends UnicastRemoteObject implements SubscriberInterface {

    //Instance variables - Subscriber's name and ID
    //ArrayList - List to store received notifications
    private int id;
    private String name;
    private ArrayList<String> notifications = new ArrayList<>();
    private transient SubscriberNotificationListener Listener;

    //Loaded Constructor - Initializes subscriber with their name and ID
    public Subscriber(String name, int id) throws RemoteException {
        this.id = id;
        this.name = name;
    }
    
    public void setListener(SubscriberNotificationListener Listener){
        this.Listener = Listener;
    }

    //getID - returns the id of the subscriber 
    @Override
    public int getId() throws RemoteException {
        return id;
    }
    
    //getName - returns the name of the subscriber 
    @Override
    public String getName() throws RemoteException {
        return name;
    }
    
    //getNotifications - returns a list of all recevied notifications
    @Override
    public ArrayList<String> getNotifications() throws RemoteException {
        return notifications;
    }
    
    //receiveNotification - Called remotely by the Service when a new notification is sent
    //                      to a subscriber, then the notification is stored in 'notifications'
    @Override
    public void receiveNotification(String notification) throws RemoteException {
        notifications.add(notification);
        if (Listener != null){
            Listener.onNotification();
        }
    }
}
