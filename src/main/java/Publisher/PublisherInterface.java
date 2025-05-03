package Publisher;

import java.rmi.Remote;
import java.util.ArrayList;
import java.rmi.RemoteException;

//Remote interface for the publisher objects [RMI]
//Defines functions that the Service can call on registered publishers
public interface PublisherInterface extends Remote {
    public String getName() throws RemoteException;
    public ArrayList<String> getNotifications() throws RemoteException;
    public void saveNotification(String notification) throws RemoteException;
}
