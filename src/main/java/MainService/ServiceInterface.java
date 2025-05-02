package MainService;

import Subscriber.*;
import Publisher.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServiceInterface extends Remote {
    public boolean hasPublisher(String name) throws RemoteException;
    public boolean hasSubscriber(String name, int id) throws RemoteException;
    public ArrayList<PublisherInterface> getPublishers()throws RemoteException;
    public SubscriberInterface getSubscriber(String name, int id) throws RemoteException;
    public PublisherInterface getPublisher(String name) throws RemoteException;
    public ArrayList<SubscriberInterface> getPublisherSubscribers(PublisherInterface Pub) throws RemoteException;
    public ArrayList<PublisherInterface> getSubscriptions(SubscriberInterface Sub) throws RemoteException;
    public void registerSubscriber(SubscriberInterface Sub) throws RemoteException;
    public void registerPublisher(PublisherInterface Pub)throws RemoteException;
    public void subscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException;
    public void unsubscribe(SubscriberInterface Sub, PublisherInterface Pub) throws RemoteException;
    public void sendNotification(PublisherInterface Pub, String notification) throws RemoteException; 
}
