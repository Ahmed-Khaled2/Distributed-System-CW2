package Publisher;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PublisherInterface extends Remote{
    public String getName() throws RemoteException;
}
