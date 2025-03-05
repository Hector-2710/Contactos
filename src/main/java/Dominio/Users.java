package Dominio;

public class Users {


    private String name;
    private String numero;

    public Users(String name, String numero) {
        this.name = name;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return name + "," + numero;
    }

    public String getName() {
        return name;
    }

    public String getNumero() {
        return numero;
    }
}
