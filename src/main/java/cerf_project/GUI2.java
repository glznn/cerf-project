package cerf_project;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;

public class GUI2 {

    private JFrame frame;
    private JPanel panel;

    public GUI2() {
        frame = GUI.getFrame();
        panel = GUI.getPanel();
        
        panel.setLayout(new FlowLayout());
        frame.setSize(500, 500);

        JLabel attendees = new JLabel("Paste the event attendees: ");
        attendees.setBounds(20, 20, 250, 25);
        panel.add(attendees);

        JTextArea aList = new JTextArea(20, 20);
        aList.setBounds(250, 250, 165, 25);
        //aList.addActionListener(this);
        //List.add(aList);
        //JScrollPane scrollPane = new JScrollPane(aList);
        aList.setEditable(true);
        panel.add(aList);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new GUI2();
    }
}
