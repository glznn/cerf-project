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

import org.javatuples.Triplet;

public class GUI2 implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton next;
    private static JTextArea aList;
    private static final char NEW_LINE = '\n';
    private static final char TAB = '\t';

    public GUI2() {
        frame = GUI.getFrame();
        panel = GUI.getPanel();
        
        //panel.setLayout(new FlowLayout());
        new ExcelConstants();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel attendees = new JLabel("Paste the event attendees: ");
        attendees.setBounds(20, 20, 250, 25);
        panel.add(attendees);

        aList = new JTextArea(25, 30);
        aList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aList.setLineWrap(true);
        aList.setWrapStyleWord(false);

        JScrollPane scroll = new JScrollPane(aList);

        panel.add(scroll);

        // Next Button
    
        next = new JButton("Next");
        next.setBounds(360,450, 100,25);
        next.addActionListener(this);
        panel.add(next);        


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        new GUI2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // NOTE: Last names and first names are separated by tabs. Attendees are separated by newlines.
        Triplet<Integer, Integer, Integer> firstAttCell = ExcelConstants.getFirstAtt();
        String attendees = aList.getText();
        String name = "";
        int nameCount = 0;
        for (int i = 0; i < attendees.length(); i++) {
            if (attendees.charAt(i) != TAB && attendees.charAt(i) != NEW_LINE)
            {
                name += attendees.charAt(i); 
            }
            else if (attendees.charAt(i) == TAB) {
                App.editCell(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount, firstAttCell.getValue2(), name);
                name = "";
            }
            else if (attendees.charAt(i) == NEW_LINE) {
                App.editCell(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount, firstAttCell.getValue2() + 1, name);
                name = "";
                nameCount++;
            }

        }
        System.out.println(aList.getText());
        try {
            App.saveWb();
            App.closeWb();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
