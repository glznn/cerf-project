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

    private static JFrame frame;
    private static JPanel panel;

    public GUI2() {
        //frame = GUI.getFrame();
        //panel = GUI.getPanel();
        
        //panel.setLayout(new FlowLayout());
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel attendees = new JLabel("Paste the event attendees: ");
        attendees.setBounds(20, 20, 250, 25);
        panel.add(attendees);

        JTextArea aList = new JTextArea(25, 30);
        aList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aList.setLineWrap(true);
        aList.setWrapStyleWord(false);

        JScrollPane scroll = new JScrollPane(aList);

        panel.add(scroll);

        // Next Button
    
        JButton next = new JButton("Next");
        next.setBounds(360,450, 100,25);
        //next.addActionListener(this);
        panel.add(next);        


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        //frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        // For Testing , make frame/panel static
        frame = new JFrame();
        panel = new JPanel();
        //
        new GUI2();
    }

}
