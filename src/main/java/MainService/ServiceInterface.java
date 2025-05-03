package MainService;

import java.rmi.Remote;
import java.util.ArrayList;
import java.rmi.RemoteException;
import Publisher.PublisherInterface;
import Subscriber.SubscriberInterface;

//Remote interface for the publisher objects [RMI]
//Defines functions that the Service can call on registered publishers
public interface ServiceInterface extends Remote {
    public boolean hasPublisher(String name) throws RemoteException;
    public boolean hasSubscriber(String name, int id) throws RemoteException;
    public PublisherInterface getPublisher(String name) throws RemoteException;
    public ArrayList<PublisherInterface> getPublishers() throws RemoteException;
    public void registerPublisher(PublisherInterface Pub) throws RemoteException;
    public void registerSubscriber(SubscriberInterface Sub) throws RemoteException;
    public SubscriberInterface getSubscriber(String name, int id) throws RemoteException;
    public void subscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException;
    public void unsubscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException;
    public void sendNotification(PublisherInterface Pub, String topic, String notification) throws RemoteException;
    public ArrayList<PublisherInterface> getSubscriptions(SubscriberInterface Sub) throws RemoteException;
    public ArrayList<SubscriberInterface> getPublisherSubscribers(PublisherInterface Pub) throws RemoteException;   
}