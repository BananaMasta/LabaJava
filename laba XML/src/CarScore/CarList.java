package CarScore;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File Cars = new File ("Cars.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Cars);

        Element elementcartype = (Element) document.getElementsByTagName("cartype").item(0);
        String Cartype = elementcartype.getAttribute("Cartype");;

        NodeList carNodeList = document.getElementsByTagName("cars");

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNodeList.getLength(); ++i){
        if (carNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
            Element elementCars = (Element) carNodeList.item(i);

            Car car = new Car();
            car.setCartype(Cartype);
            car.setNumber(Integer.parseInt(elementCars.getAttribute("number")));

            NodeList childNodes = elementCars.getChildNodes();
            for (int j = 0; j<childNodes.getLength(); ++j){
                if (childNodes.item(j).getNodeType() ==Node.ELEMENT_NODE){
                    Element childElement = (Element) childNodes.item(j);

                    switch (childElement.getNodeName()) {
                        case "name": {
                            car.setName(childElement.getTextContent());
                        }break;

                           case "maxspeed": {
                               car.setMaxspeed(Integer.parseInt(childElement.getTextContent()));
                           }break;

                            case "price": {
                                car.getPrice().setValue(Double.valueOf(childElement.getTextContent()));
                                car.getPrice().setCurrency(childElement.getAttribute("currency"));
                              }
                           }
                        }
                    }
            carList.add(car);
                }
            }
        carList.forEach(System.out::println);
        }
    }

