package Interfaces;

import Dominio.Contactos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Remove extends JFrame implements ActionListener {
    private JPanel remove;
    private JTextField ingresaNameTextField;
    private JButton deleteButton;
    private JButton exitButton;

    public Remove() {
        setTitle("Remove");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(remove);
        pack();
        setLocationRelativeTo(null);
        setSize(300,300);
        setVisible(true);
        ingresaNameTextField.addActionListener(this);
        deleteButton.addActionListener(this);
        exitButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            String name = ingresaNameTextField.getText();
            Contactos ct = new Contactos();
            ct.removeContacto(name);
            ingresaNameTextField.setText("eliminado");
        } else if (e.getSource()== exitButton) {

            this.setVisible(false);
            new Home();

        }
    }
}
