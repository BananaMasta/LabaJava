import java.rmi.RemoteException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class CarListValidatorImpl implements CarListValidator {
    public CarListValidatorImpl() {
    }

    public int getCountGaragePrice(Element carnumber) throws RemoteException {
        NodeList cars = carnumber.getElementsByTagName("car");
        int count = 0;

        for(int j = 0; j < cars.getLength(); ++j) {
            Element car = (Element)cars.item(j);
            Element carprice = (Element)car.getElementsByTagName("carprice").item(0);
            count += Integer.parseInt(carprice.getAttribute("price"));
        }

        return count;
    }
}
