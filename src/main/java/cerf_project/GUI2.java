package cerf_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.javatuples.Triplet;

public class GUI2 implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JButton next, download;
    private static JTextArea aList;
    private static final char NEW_LINE = '\n';
    private static final char TAB = '\t';

    JTextField leadershipHr = new JTextField();
    JTextField fellowshipHr = new JTextField();
    JTextField serviceHr = new JTextField();
    final JComponent[] inputs = new JComponent[] {
            new JLabel("Leadership Hours: "),
            leadershipHr,
            new JLabel("Fellowship Hours: "),
            fellowshipHr,
            new JLabel("Service Hours: "),
            serviceHr
    };

    public GUI2() {
        frame = GUI.getFrame();
        panel = GUI.getPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // panel.setLayout(new FlowLayout());
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
        next.setBounds(360, 450, 100, 25);
        next.addActionListener(this);
        panel.add(next);

        // Download Button

        download = new JButton("Download");
        download.setBounds(380, 450, 100, 25);
        download.setEnabled(false);
        download.addActionListener(this);
        panel.add(download);        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new GUI2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        // NOTE: Last names and first names are separated by tabs. Attendees are
        // separated by newlines.

        if (e.getSource() == next) {
            Triplet<Integer, Integer, Integer> firstAttCell = ExcelConstants.getFirstAtt();
            String attendees = aList.getText();
            String name = "";
            String fullName = "";
            int nameCount = 0;
    
            if (attendees.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please enter the attendees", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!(attendees.charAt(attendees.length() - 1) == '\n')) {
                attendees = attendees + '\n';
            }
    
            for (int i = 0; i < attendees.length(); i++) {
                if (attendees.charAt(i) != TAB && attendees.charAt(i) != NEW_LINE) {
                    name += attendees.charAt(i);
                    fullName += attendees.charAt(i);
                } else if (attendees.charAt(i) == TAB) {
                    App.editCell(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount, firstAttCell.getValue2(),
                            name);
                    name = "";
                    fullName += " ";
                } else if (attendees.charAt(i) == NEW_LINE) {
                    App.editCell(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount,
                            firstAttCell.getValue2() + 1, name);
                    name = "";
                    DataHandler.addA(fullName);
                    JOptionPane.showConfirmDialog(null, inputs, "Input Hours for " + fullName, JOptionPane.PLAIN_MESSAGE);
                    // Put in hours , make sure type is number for spreadsheet
    
                    App.setDouble(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount,
                            firstAttCell.getValue2() + 2, serviceHr.getText());
    
                    App.setDouble(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount,
                            firstAttCell.getValue2() + 4, leadershipHr.getText());
    
                    App.setDouble(firstAttCell.getValue0(), firstAttCell.getValue1() + nameCount,
                            firstAttCell.getValue2() + 5, fellowshipHr.getText());
    
                    fullName = "";
                    nameCount++;
                }
    
            }
            download.setEnabled(true);
        }
        else if (e.getSource() == download) {

            try {
                App.saveWb();
                App.closeWb();
                System.out.println("reached");
                //System.exit(0);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select Destination to save this CERF!");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File destinationFile = fileChooser.getSelectedFile();;
                File completedCERF = new File("workbook.xlsx");
                //String newFileName = GUI.getEventName() + "_CERF.xlsx";
                //completedCERF.renameTo(new File("newanme.xlsx"));
                //System.out.println(completedCERF.getName());
                //System.out.println(GUI.getEventName() + "_CERF.xlsx");

                try {
                    Path sourcePath = completedCERF.toPath();
                    Path destinationPath = destinationFile.toPath().resolve(completedCERF.getName());

                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(frame, "CERF has been saved to " + destinationPath.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, "Failed to download file: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        }
    }
}
