package Interfaces;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Add extends JFrame implements ActionListener {
    private JPanel add;
    private JTextField nombreTextField;
    private JTextField numeroTextField;

    public Add () {
        setTitle("Add");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(add);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        numeroTextField.addActionListener(this);
        nombreTextField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
