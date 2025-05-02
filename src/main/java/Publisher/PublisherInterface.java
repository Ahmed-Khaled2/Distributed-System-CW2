package Publisher;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface PublisherInterface extends Remote{
    public String getName() throws RemoteException;
    public ArrayList<String> getNotifications() throws RemoteException;
    public void saveNotification(String notification) throws RemoteException;
}
