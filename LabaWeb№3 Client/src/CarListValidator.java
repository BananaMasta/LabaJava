import org.w3c.dom.*; 

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarListValidator extends Remote {
    public int getCountGaragePrice(Element bookshelf) throws RemoteException;
}
