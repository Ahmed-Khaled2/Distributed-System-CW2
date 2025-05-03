package Subscriber;

import java.rmi.Remote;
import java.util.ArrayList;
import java.rmi.RemoteException;

//Remote interface for the subscriber objects [RMI]
//Defines functions that the Service can call on registered subscribers
public interface SubscriberInterface extends Remote {
    public int getId() throws RemoteException;
    public String getName() throws RemoteException;
    public ArrayList<String> getNotifications() throws RemoteException;
    public void receiveNotification(String notification) throws RemoteException;
}
