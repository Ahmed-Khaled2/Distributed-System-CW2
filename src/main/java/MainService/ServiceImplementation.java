package MainService;

import Subscriber.*;
import Publisher.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceImplementation extends UnicastRemoteObject implements ServiceInterface {

    private Map<String, SubscriberInterface> Subscribers = new HashMap<>();
    private Map<String, PublisherInterface> Publishers = new HashMap<>();
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
    public boolean hasSubscriber(String name, int id) throws RemoteException {
        String keySub = name + "#" + id;
        return Subscribers.containsKey(keySub);
    }
    
    @Override
    public boolean hasPublisher(String name) throws RemoteException {
        String keyPub = name + "#";
        return Publishers.containsKey(keyPub);
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
    public SubscriberInterface getSubscriber(String name, int id) throws RemoteException {
        String keySub = name + "#" + id;
        return Subscribers.get(keySub);
    }

    @Override
    public PublisherInterface getPublisher(String name) throws RemoteException {
        String keyPub = name + "#";
        return Publishers.get(keyPub);
    }
    
    @Override
    public ArrayList<PublisherInterface> getPublishers()throws RemoteException {
        return new ArrayList<>(Publishers.values());
    }

    @Override
    public void registerSubscriber(SubscriberInterface Sub) throws RemoteException {
        String keySub = getSubscriberKey(Sub);
        if (!Subscribers.containsKey(keySub)) {
            this.Subscribers.put(keySub, Sub);

        }
    }

    @Override
    public void registerPublisher(PublisherInterface Pub) throws RemoteException {
        String keyPub = getPublisherKey(Pub);
        if (!Publishers.containsKey(keyPub)) {
            this.Publishers.put(keyPub, Pub);
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
