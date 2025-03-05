package Dominio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactosTest {

    @Test
    void addContacto() {

    }

    @Test
    void removeContacto() {
        // Aquí van las pruebas para el método removeContacto
    }

    @Test
    void cargarContactos() {
        // Aquí van las pruebas para el método cargarContactos
    }

    @Test
    void cargarContactosTabla() {
        // Aquí van las pruebas para el método cargarContactosTabla
    }

    @Test
    void numeroValido() {
        assertTrue(Contactos.numeroValido("12345678000"));
    }
}
