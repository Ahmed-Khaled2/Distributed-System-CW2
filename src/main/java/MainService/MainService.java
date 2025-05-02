package MainService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainService {

    public static void main(String[] args) throws Exception {
        ServiceImplementation service = new ServiceImplementation();
        Registry r = LocateRegistry.createRegistry(1099);
        r.bind("NotificationSystem", service);
        
        ServiceConsoleGUI SCGUI = new ServiceConsoleGUI(service);
        service.setGUI(SCGUI);
        SCGUI.setVisible(true);
        
        System.out.println("System Started!");
    }
}
