package Publisher;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Remote interface for the publisher objects [RMI]
//Defines functions that the Service can call on registered publishers
public interface PublisherInterface extends Remote {
    public void saveNotification(String notification) throws RemoteException;
    public ArrayList<String> getNotifications() throws RemoteException;
    public String getName() throws RemoteException;
}
