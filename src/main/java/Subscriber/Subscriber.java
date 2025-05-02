package Subscriber;

import Publisher.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Subscriber extends UnicastRemoteObject implements SubscriberInterface {

    private String name;
    private int id;
    private Map<Publisher, ArrayList<String>> PublisherNotifications = new HashMap<>();

    public Subscriber(String name, int id) throws RemoteException {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void receiveNotification(String notification, Publisher Pub) throws RemoteException {
        if (!PublisherNotifications.containsKey(Pub)){
            PublisherNotifications.put(Pub, new ArrayList<>());
        }
        PublisherNotifications.get(Pub).add(notification);
        System.out.println(notification);
    }
}
