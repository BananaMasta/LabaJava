package Laba.Java;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        File sourceFile = new File("src/Laba/XML/Carlist.xml");
        File outputFile = new File("src/Laba/XML/Carlistout.xml");
        CarListValidator validator = new CarListValidator();
        try {
            validator.validator(sourceFile, outputFile);
        } catch (TransformerException e) {
            System.err.println("Произошла внутренняя ошибка.");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
