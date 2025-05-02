package MainService;

import Subscriber.*;
import Publisher.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceImplementation extends UnicastRemoteObject implements ServiceInterface {

    private ArrayList<Subscriber> Subscribers = new ArrayList<>();
    private ArrayList<Publisher> Publishers = new ArrayList<>();
    private Map<Subscriber, ArrayList<Publisher>> Subscriptions = new HashMap<>(); // Subscriber -> (Publisher1, Publisher2)
    private Map<Publisher, ArrayList<Subscriber>> PublisherSubscribers = new HashMap<>(); // Publisher1 -> (Ahmed, Khaled)

    public ServiceImplementation() throws RemoteException {
        super();
    }

    @Override
    public void registerSubscriber(Subscriber Sub) throws RemoteException {
        this.Subscribers.add(Sub);
    }

    @Override
    public void registerPublisher(Publisher Pub) throws RemoteException {
        this.Publishers.add(Pub);
    }

    @Override
    public void subscribe(Subscriber Sub, Publisher Pub) throws RemoteException {
        if (!Subscriptions.containsKey(Sub)) {
            this.Subscriptions.put(Sub, new ArrayList<>());
        }
        this.Subscriptions.get(Sub).add(Pub);

        if (!PublisherSubscribers.containsKey(Pub)) {
            this.PublisherSubscribers.put(Pub, new ArrayList<>());
        }
        this.PublisherSubscribers.get(Pub).add(Sub);
    }

    @Override
    public void unsubscribe(Subscriber Sub, Publisher Pub) throws RemoteException {
        if (Subscriptions.containsKey(Sub)) {
            if (Subscriptions.get(Sub).contains(Pub)) {
                this.Subscriptions.get(Sub).remove(Pub);
            }
        }
    }

    @Override
    public void sendNotification(Publisher Pub, String notification) throws RemoteException {
        for (int i = 0; i < PublisherSubscribers.get(Pub).size(); i++) {
            PublisherSubscribers.get(Pub).get(i).receiveNotification(notification, Pub);
        }
    }

}
