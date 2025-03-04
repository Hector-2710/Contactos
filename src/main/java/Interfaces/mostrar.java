package Interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Dominio.Contactos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mostrar extends JFrame implements ActionListener {
    private JTable tablacontactos;
    private JPanel mostrar;
    private JButton exitButton;
    private JButton button1;
    private DefaultTableModel modeloTabla;

    public mostrar() {
        setTitle("Mostrar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mostrar = new JPanel();
        setContentPane(mostrar);
        mostrar.add(exitButton);
        pack();
        setSize(600, 400);
        setLocationRelativeTo(null);

        // 🟢 Cargar contactos desde el archivo con GestorContactos
        modeloTabla = Contactos.cargarContactosTabla();

        // 🟢 Crear la JTable con los datos cargados
        tablacontactos = new JTable();
        tablacontactos.setModel(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablacontactos);
        add(scrollPane, BorderLayout.CENTER);
        exitButton.addActionListener(this);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            this.setVisible(false);
            new Home();
        }
    }
}
