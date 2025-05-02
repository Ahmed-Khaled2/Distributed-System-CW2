package Subscriber;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Subscriber extends UnicastRemoteObject implements SubscriberInterface {

    private String name;
    private int id;
    private ArrayList<String> notifications = new ArrayList<>();

    public Subscriber(String name, int id) throws RemoteException {
        this.name = name;
        this.id = id;
    }
    
    @Override
    public ArrayList<String> getNotifications() throws RemoteException {
        return notifications;
    }
    
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public int getId() throws RemoteException {
        return id;
    }

    @Override
    public void receiveNotification(String notification) throws RemoteException {
        notifications.add(notification);
        System.out.println(notification);
    }
}
