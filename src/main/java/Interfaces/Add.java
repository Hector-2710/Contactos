package Interfaces;
import Dominio.Contactos;
import Dominio.Users;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Add extends JFrame implements ActionListener {
    private JPanel add;
    private JTextField nombreTextField;
    private JTextField numeroTextField;
    private JButton addButton;
    private JLabel text;
    private JButton exitButton;

    public Add () {
        setTitle("Add");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(add);
        pack();
        setLocationRelativeTo(null);
        setSize(300,300);
        setVisible(true);
        numeroTextField.addActionListener(this);
        nombreTextField.addActionListener(this);
        addButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton){

            String name = nombreTextField.getText();
            String numero = numeroTextField.getText();
            Users add = new Users(name,numero);
            Contactos ct = new Contactos();
            boolean estado = ct.numeroValido(numero);

            if (estado == true) {
                ct.addContacto(add);
                text.setText("contacto agregado");
            } else {
                text.setText("numero invalido");
            }

        }
        else if (e.getSource() == exitButton){
            this.setVisible(false);
            new Home();
        }


    }
}
