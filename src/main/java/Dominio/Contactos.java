package Dominio;
import java.io.*;
import java.util.ArrayList;

public class Contactos {
    private ArrayList<Users> contactos;
    private static final String FILE_NAME = "contactos.txt";

    public Contactos() {
        this.contactos = new ArrayList<>();
        cargarContactos();
    }

    public void addContacto(Users contacto) {
        contactos.add(contacto);
        guardarContactos();
    }

    public void removeContacto(Users contacto) {
        contactos.remove(contacto);
        guardarContactos();
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
        } else {
            for (Users contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }

    private void guardarContactos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Users contacto : contactos) {
                writer.write(contacto.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    private void cargarContactos() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    contactos.add(new Users(data[0], data[1], data[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los contactos: " + e.getMessage());
        }
    }
}
