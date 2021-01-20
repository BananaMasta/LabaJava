package Laba.Java;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class CarListValidator {
    private DocumentBuilder documentBuilder;

    public void validator(File sourceFile,File ouputFile) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Document document;
        File file = new File("src/Laba/XML/Carlist.xml");
        File outputFile = new File("src/Laba/XML/Carlistout.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(file);

        NodeList carnumbers = document.getElementsByTagName("carnumber");
        for (int i=0; i<carnumbers.getLength(); ++i) {
            Element carnumber = (Element) carnumbers.item(i);
            int allCarPrice = getCountGaragePrice(carnumber);
            Node GaragePrice;
            GaragePrice = document.createElement("GaragePrice");
            carnumber.appendChild(GaragePrice);
            GaragePrice.setTextContent(String.valueOf(allCarPrice));
        }
        saveOnDisk(document, outputFile);
    }

    private int getCountGaragePrice(Element carnumber) {

        NodeList cars = carnumber.getElementsByTagName("car");
        int count = 0;
        for (int j=0; j<cars.getLength();j++){
            Element car = (Element)cars.item(j);
            Element carprice = (Element) car.getElementsByTagName("price").item(0);
            count += Integer.parseInt(carprice.getAttribute("Price"));
        }
        return count;
    }

    private void saveOnDisk (Document doc,File output) throws  TransformerException{

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(output));

    }
}