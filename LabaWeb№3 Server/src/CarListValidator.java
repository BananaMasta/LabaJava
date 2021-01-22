import java.rmi.Remote;
import java.rmi.RemoteException;
import org.w3c.dom.Element;

public interface CarListValidator extends Remote {
    int getCountGaragePrice (Element var1) throws RemoteException;
}
