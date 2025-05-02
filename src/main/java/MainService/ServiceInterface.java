package MainService;

import Subscriber.Subscriber;
import Publisher.Publisher;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceInterface extends Remote {
    public void registerSubscriber(Subscriber Sub)throws RemoteException;
    public void registerPublisher(Publisher Pub)throws RemoteException;
    public void subscribe(Subscriber Sub, Publisher Pub) throws RemoteException;
    public void unsubscribe(Subscriber Sub, Publisher Pub) throws RemoteException;
    public void sendNotification(Publisher Pub, String notification) throws RemoteException;
}
