package Publisher;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Publisher extends UnicastRemoteObject implements PublisherInterface{

    private String name;
    private ArrayList<String> notifications = new ArrayList<>();

    public Publisher(String name) throws RemoteException {
        super();
        this.name = name;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }
    
    public void saveNotification(String notification){
        notifications.add(notification);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
    
    
}
