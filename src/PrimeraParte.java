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

public class PrimeraParte {
    private static final String PERSONA_TAG = "persona";
    private static final String PERSONA_NOMBRE_TAG = "nombre";
    private static final String PERSONA_EDAD_TAG = "edad";
    private static final String PERSONA_DNI_TAG = "dni";
    private static final String PERSONA_SALARIO_TAG = "salario";
    private static final String PERSONA_ATT_ID = "id";
    private static final String PERSONA_ATT_BORRADO = "borrado";


    public static ArrayList<Persona> leerDom(String s) {
        ArrayList<Persona> persona=new ArrayList<>();
        try {
            File f= new File(s);
            DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder db= dbFactory.newDocumentBuilder();
            Document doc= db.parse(f);

            NodeList nList = doc.getElementsByTagName("persona");

            for (int i=0; i<nList.getLength();i++){
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    Boolean borrado=false;
                    if(eElement.getAttribute("borrado").length()>0)borrado=true;

                    String nombre= eElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String DNI=eElement.getElementsByTagName("dni").item(0).getTextContent();
                    int edad= Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent());
                    Double salario= Double.valueOf(eElement.getElementsByTagName("salario").item(0).getTextContent());
                    persona.add(new Persona(nombre,DNI,edad,salario));
                    persona.get(i).setBorrado(borrado);

                }
            }

        return persona;

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
