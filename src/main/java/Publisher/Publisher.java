package Publisher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Publisher extends UnicastRemoteObject{

    private String name;

    public Publisher(String name) throws RemoteException {
        super();
        this.name = name;
    }
    
}
