package Subscriber;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface SubscriberInterface extends Remote {

    public void receiveNotification(String notification) throws RemoteException;

    public ArrayList<String> getNotifications() throws RemoteException;

    public String getName() throws RemoteException;

    public int getId() throws RemoteException;
}
