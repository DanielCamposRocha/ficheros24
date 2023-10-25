import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        apartadoA();
        apartadoB();

    }

    private static void apartadoB() {
        ArrayList<Persona> personasActivas=SegundaParte.leerDom("personas.xml");
    }

    private static void apartadoA() {
        ArrayList<Persona> personas=PrimeraParte.leerDom("personas.xml");
        for (Persona alguien:personas) {
            if(!alguien.isBorrado()) System.out.println(alguien);
        }
    }



}