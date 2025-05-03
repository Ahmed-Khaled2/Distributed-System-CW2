package MainService;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class MainService {

    //MainService Main - This is where the Service starts
    //ServiceImplementation service - Creats an object of the service implementation
    //Registry r - Starts the RMI registry on port '1099'
    //r.bind() - Binds the service object to the name "NotificationSystem" in the registry
    //ServiceConsoleGUI SCGUI - Opens the service console GUI
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
