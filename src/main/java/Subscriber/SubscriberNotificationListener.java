package Subscriber;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubscriberNotificationListener extends Remote {
    void onNotification() throws RemoteException;
}
