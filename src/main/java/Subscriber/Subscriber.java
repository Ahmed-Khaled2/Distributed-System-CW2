package Subscriber;

import Publisher.PublisherInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Subscriber extends UnicastRemoteObject implements SubscriberInterface {

    private String name;
    private int id;
    private ArrayList<PublisherInterface> subscribedPublishers = new ArrayList<>();
    private ArrayList<String> notifications = new ArrayList<>();

    public Subscriber(String name, int id) throws RemoteException {
        this.name = name;
        this.id = id;
    }

    public void subscribePublisher(PublisherInterface P) {
        if (!subscribedPublishers.contains(P)) {
            subscribedPublishers.add(P);
        }
    }

    public void unsubscribePublisher(PublisherInterface P) {
        if (subscribedPublishers.contains(P)) {
            subscribedPublishers.remove(P);
        }
    }

    @Override
    public void receiveNotification(String notification) throws RemoteException {
        System.out.println(notification);
        notifications.add(notification);
    }
}
