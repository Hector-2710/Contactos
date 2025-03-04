package Dominio;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Contactos {
    private ArrayList<Users> contactos;
    private static final String FILE_NAME = "src/main/java/Datos/contactos.txt";

    public Contactos() {
        this.contactos = new ArrayList<>();
        cargarContactos();
    }

    public void addContacto(Users contacto) {
        contactos.add(contacto);
        guardarContactos();
    }

    public void removeContacto(String name) {
        for (Users contacto : contactos) {
            if (contacto.getName().equals(name)) {
                contactos.remove(contacto);
                guardarContactos();
                return;
            }
        }
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
                writer.write(contacto.toString()); // Escribe "nombre,numero"
                writer.newLine();
            }
            System.out.println("Contactos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    public void cargarContactos() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {// Solo procesamos si hay dos elementos (nombre y número)
                    String nombre = data[0].trim();  // Eliminar espacios en blanco
                    String numero = data[1].trim();
                    contactos.add(new Users(nombre, numero));
                }
            }
            System.out.println("Contactos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar los contactos: " + e.getMessage());
        }
    }
    public static DefaultTableModel cargarContactosTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Número");

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No se encontró el archivo de contactos.");
            return modeloTabla; // Retorna la tabla vacía si no hay archivo
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Verificando cada línea leída
                System.out.println("Leyendo línea: " + line);
                String[] data = line.split(","); // Separa el nombre y número
                if (data.length == 2) {
                    String nombre = data[0].trim(); // Elimina espacios en blanco antes y después del nombre
                    String numero = data[1].trim(); // Elimina espacios en blanco antes y después del número
                    modeloTabla.addRow(new Object[]{nombre, numero}); // Agregar fila a la tabla
                } else {
                    System.out.println("Formato incorrecto en línea: " + line); // Si no es correcto, muestra la línea
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los contactos: " + e.getMessage());
        }

        return modeloTabla;
    }




}
