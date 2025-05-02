package MainService;

import Subscriber.*;
import Publisher.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceImplementation extends UnicastRemoteObject implements ServiceInterface {

    private ArrayList<SubscriberInterface> Subscribers = new ArrayList<>();
    private ArrayList<PublisherInterface> Publishers = new ArrayList<>();
    private Map<SubscriberInterface, ArrayList<PublisherInterface>> Subscriptions = new HashMap<>(); // Subscriber -> (Publisher1, Publisher2)
    private Map<PublisherInterface, ArrayList<SubscriberInterface>> PublisherSubscribers = new HashMap<>(); // Publisher1 -> (Ahmed, Khaled)

    public ServiceImplementation() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<PublisherInterface> getSubscriptions(SubscriberInterface Sub) throws RemoteException {

        if (Subscriptions.containsKey(Sub)) {
            return Subscriptions.get(Sub);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<SubscriberInterface> getPublisherSubscribers(PublisherInterface Pub) throws RemoteException {
        return PublisherSubscribers.get(Pub);
    }

    @Override
    public ArrayList<SubscriberInterface> getSubscribers() throws RemoteException {
        return Subscribers;
    }

    @Override
    public ArrayList<PublisherInterface> getPublishers() throws RemoteException {
        return Publishers;
    }

    @Override
    public void registerSubscriber(SubscriberInterface Sub) throws RemoteException {
        if (!Subscribers.contains(Sub)) {
            this.Subscribers.add(Sub);
        }
    }

    @Override
    public void registerPublisher(PublisherInterface Pub) throws RemoteException {
        this.Publishers.add(Pub);
    }

    @Override
    public void subscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException {
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
    public void unsubscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException {
        if (Subscriptions.containsKey(Sub)) {
            if (Subscriptions.get(Sub).contains(Pub)) {
                this.Subscriptions.get(Sub).remove(Pub);
            }
        }
    }

    @Override
    public void sendNotification(PublisherInterface Pub, String notification) throws RemoteException {
        for (int i = 0; i < PublisherSubscribers.get(Pub).size(); i++) {
            PublisherSubscribers.get(Pub).get(i).receiveNotification("[" + Pub.getName() + "]" + notification);
        }

    }

}
