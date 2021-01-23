import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class App {
    public static final String UNIC_BINDING_NAME = "server.carlist.validator";

    public App() {
  
    }

    public static void main(String[] args) throws Exception {
        CarListValidatorImpl service = new CarListValidatorImpl();
        Registry registry = LocateRegistry.createRegistry(1213);
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        registry.bind("server.carlist.validator", stub);
        Thread.sleep(2147483647L);
    }
}
