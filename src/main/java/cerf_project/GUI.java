package cerf_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    private App app;
    private JFrame frame;
    private JPanel panel;
    private JTextField cerfTitle;

    public GUI() {

        app = new App();

        frame = new JFrame();
        panel = new JPanel();

        panel.setLayout(null);

        JLabel label = new JLabel("Enter the event name: ");
        label.setBounds(20, 20, 250, 25);
        panel.add(label);

        cerfTitle = new JTextField(20);
        cerfTitle.setBounds(150, 20, 165, 25);
        cerfTitle.addActionListener(this);
        panel.add(cerfTitle);

        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        // frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = cerfTitle.getText();
        App.changeEvent(text);
        System.out.println("changed");
        App.getEvent();
        try {
            App.saveWb();
            App.closeWb();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("lol");
            e1.printStackTrace();
        }
    }
}
