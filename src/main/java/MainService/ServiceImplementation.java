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
    private Map<String, ArrayList<PublisherInterface>> Subscriptions = new HashMap<>(); // Subscriber -> (Publisher1, Publisher2)
    private Map<String, ArrayList<SubscriberInterface>> PublisherSubscribers = new HashMap<>(); // Publisher1 -> (Ahmed, Khaled)

    public ServiceImplementation() throws RemoteException {
        super();
    }

    public String getSubscriberKey(SubscriberInterface Sub) throws RemoteException {
        return Sub.getName() + "#" + Sub.getId();
    }

    public String getPublisherKey(PublisherInterface Pub) throws RemoteException {
        return Pub.getName() + "#";
    }

    @Override
    public ArrayList<PublisherInterface> getSubscriptions(SubscriberInterface Sub) throws RemoteException {
        String keySub = getSubscriberKey(Sub);
        if (Subscriptions.containsKey(keySub)) {
            return Subscriptions.get(keySub);
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ArrayList<SubscriberInterface> getPublisherSubscribers(PublisherInterface Pub) throws RemoteException {
        String keyPub = getPublisherKey(Pub);
        if (PublisherSubscribers.containsKey(keyPub)) {
            return PublisherSubscribers.get(keyPub);
        } else {
            return new ArrayList<>();
        }
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
        if (!Publishers.contains(Pub)) {
            this.Publishers.add(Pub);
        }
    }

    @Override
    public void subscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException {

        String keySub = getSubscriberKey(Sub);
        String keyPub = getPublisherKey(Pub);

        if (!Subscriptions.containsKey(keySub)) {
            this.Subscriptions.put(keySub, new ArrayList<>());
        }
        this.Subscriptions.get(keySub).add(Pub);

        if (!PublisherSubscribers.containsKey(keyPub)) {
            this.PublisherSubscribers.put(keyPub, new ArrayList<>());
        }
        this.PublisherSubscribers.get(keyPub).add(Sub);
    }

    @Override
    public void unsubscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException {
        String keySub = getSubscriberKey(Sub);
        if (Subscriptions.containsKey(keySub)) {
            if (Subscriptions.get(keySub).contains(Pub)) {
                this.Subscriptions.get(keySub).remove(Pub);
            }
        }
    }

    @Override
    public void sendNotification(PublisherInterface Pub, String notification) throws RemoteException {
        String keyPub = getPublisherKey(Pub);

        for (int i = 0; i < PublisherSubscribers.get(keyPub).size(); i++) {
            PublisherSubscribers.get(keyPub).get(i).receiveNotification("[" + Pub.getName() + "]" + notification);
        }

    }

}
