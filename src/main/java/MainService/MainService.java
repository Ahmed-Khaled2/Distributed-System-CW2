package MainService;

import Starter.StarterGUI;
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
        
        StarterGUI S1 = new StarterGUI();
        StarterGUI S2 = new StarterGUI();
        StarterGUI S3 = new StarterGUI();
        StarterGUI P1 = new StarterGUI();
        StarterGUI P2 = new StarterGUI();
        StarterGUI P3 = new StarterGUI();
        S1.setVisible(true);
        S2.setVisible(true);
        S3.setVisible(true);
        P1.setVisible(true);
        P2.setVisible(true);
        P3.setVisible(true);
            
        ServiceConsoleGUI SCGUI = new ServiceConsoleGUI(service);
        service.setGUI(SCGUI);
        SCGUI.setVisible(true);
        
        System.out.println("System Started!");
    }
}
