package MainService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImplementation extends UnicastRemoteObject implements ServiceInterface {

    public ServiceImplementation() throws RemoteException {
        super();
    }

}
