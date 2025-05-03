package Publisher;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Publisher extends UnicastRemoteObject implements PublisherInterface {

    //Instance variables - Publisher's name
    //ArrayList - List to store sent notifications
    private String name;
    private Map<String, ArrayList<String>> notifications = new HashMap<>();

    //Loaded Constructor - Initializes publisher their name 
    public Publisher(String name) throws RemoteException {
        super();
        this.name = name;
    }

    //getName - returns the name of the publisher 
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    //getNotifications - returns a list of all sent notifications
    @Override
    public ArrayList<String> getNotifications(String topic) throws RemoteException {
        return notifications.getOrDefault(topic, new ArrayList<>());
    }

    //saveNotification - Called remotely by the Service when a new notification is sent
    //                   by a publisher, then the notification is stored in 'notifications'
    @Override
    public void saveNotification(String topic, String notification) throws RemoteException {
        if (!notifications.containsKey(topic)) {
            notifications.put(topic, new ArrayList<>());
        }
        notifications.get(topic).add(notification);
    }
}
