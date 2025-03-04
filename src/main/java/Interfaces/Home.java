package Interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    private JPanel Home;
    private JButton mostrarButton;
    private JButton agregarButton;
    private JButton eliminarButton;

    public Home() {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Home);
        pack();
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        mostrarButton.addActionListener(this);
        agregarButton.addActionListener(this);
        eliminarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mostrarButton) {
            this.setVisible(false);
            new mostrar();

        } else if (e.getSource() == agregarButton) {
            this.setVisible(false);
            new Add();

        } else if (e.getSource() == eliminarButton) {
            this.setVisible(false);
            new Remove();
        }


    }
}

