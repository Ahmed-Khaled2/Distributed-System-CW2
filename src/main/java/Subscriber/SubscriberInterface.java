package Subscriber;

import Publisher.Publisher;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubscriberInterface extends Remote{
    public void receiveNotification(String msg, Publisher Pub) throws RemoteException;
}
