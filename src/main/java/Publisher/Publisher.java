package Publisher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Publisher extends UnicastRemoteObject implements PublisherInterface {

    private String name;
    private ArrayList<String> notifications = new ArrayList<>();

    public Publisher(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public ArrayList<String> getNotifications() throws RemoteException {
        return notifications;
    }

    @Override
    public void saveNotification(String notification) throws RemoteException {
        notifications.add(notification);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

}
