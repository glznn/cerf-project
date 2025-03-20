package cerf_project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;

public class GUI implements ActionListener {

    private GUI2 gui2;
    private App app;
    private ExcelConstants excelConstants;
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField nameOfEventI;
    private JTextField eventChairI;
    private JTextField userI;
    private JTextField dateI;
    private JTextField timeI;
    private JTextField timeII;
    private JTextField locationI;
    private JTextField hostI;
    private JCheckBox commService;
    private JCheckBox camService;
    private JCheckBox sAdmin;
    private JCheckBox conServ;
    private JCheckBox dSI;
    private JCheckBox iSP;
    private JCheckBox admin;
    private JCheckBox socialE;
    private JCheckBox inClub;
    private JCheckBox devE;
    private JCheckBox fund;
    private JCheckBox alum;
    private JCheckBox kFam;
    private JCheckBox iClub;
    private JCheckBox web;
    private JCheckBox divEvent;
    private JCheckBox disEvent;
    private JCheckBox iEvent;
    private JButton next;
    private LinkedList<JTextField> pageOneTextFields;
    private LinkedList<JCheckBox> pageOneCheckBox;
    private static final int ARRAY_BUFFER = 7;

    public GUI() {

        //app = new App();
        excelConstants = new ExcelConstants();
        pageOneTextFields = new LinkedList<>();
        pageOneCheckBox = new LinkedList<>();

        frame = new JFrame();
        panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // So that the tooltip comes out much faster!
        ToolTipManager.sharedInstance().setInitialDelay(100);

        panel.setLayout(null);

        // Name of Event
        JLabel nameOfEvent = new JLabel("Event name: ");
        nameOfEvent.setBounds(20, 20, 250, 25);
        panel.add(nameOfEvent);

        nameOfEventI = new JTextField(20);
        nameOfEventI.setBounds(180, 20, 165, 25);
        nameOfEventI.addActionListener(this);
        pageOneTextFields.add(nameOfEventI);
        panel.add(nameOfEventI);

        // Event Chair
        JLabel eventChair = new JLabel("Event chair: ");
        eventChair.setBounds(20, 40, 250, 25);
        panel.add(eventChair);

        eventChairI = new JTextField(20);
        eventChairI.setBounds(180, 40, 165, 25);
        pageOneTextFields.add(eventChairI);
        panel.add(eventChairI);

        // Person Filling out CERF
        JLabel user = new JLabel("Person Filling out CERF: ");
        user.setBounds(20, 60, 250, 25);
        panel.add(user);

        userI = new JTextField(20);
        userI.setBounds(180, 60, 165, 25);
        pageOneTextFields.add(userI);
        panel.add(userI);

        // Date of Event
        JLabel date = new JLabel("Date of Event: ");
        date.setBounds(20, 80, 250, 25);
        panel.add(date);

        dateI = new JTextField(10);
        dateI.setBounds(180, 80, 165, 25);
        dateI.setToolTipText("Input as MM/DD/YY");
        pageOneTextFields.add(dateI);
        panel.add(dateI);

        // Time of Event 
        JLabel time = new JLabel("Start / End Time: ");
        time.setBounds(20, 100, 250, 25);
        panel.add(time);
        
            // Start time
        timeI = new JTextField(10);
        timeI.setBounds(180, 100, 82, 25);
        timeI.setToolTipText("Input as HH:MM");
        pageOneTextFields.add(timeI);
        panel.add(timeI);

            // End Time
        timeII = new JTextField(10);
        timeII.setBounds(262, 100, 83, 25);
        timeII.setToolTipText("Input as HH:MM");
        panel.add(timeII);


        // Location
        JLabel location = new JLabel("Location: ");
        location.setBounds(20, 120, 250, 25);
        panel.add(location);

        locationI = new JTextField(20);
        locationI.setBounds(180, 120, 165, 25);
        pageOneTextFields.add(locationI);
        panel.add(locationI);

        // Event Contact & Number
        JLabel host = new JLabel("Event Contact & Number: ");
        host.setBounds(20, 140, 250, 25);
        panel.add(host);

        hostI = new JTextField(20);
        hostI.setBounds(180, 140, 165, 25);
        pageOneTextFields.add(hostI);
        panel.add(hostI);

        // Was this a .... ?

        JLabel eventType = new JLabel("Was this a ... ?");
        eventType.setBounds(200, 170, 165, 25);
        panel.add(eventType);

        // CHECKBOXES

        // Community Service

        commService = new JCheckBox();
        commService.setText("Community Service Event");
        commService.setBounds(20, 200, 200, 25);
        commService.setToolTipText("Community Service: An event where your club members are serving for the community without pay.");
        pageOneCheckBox.add(commService);
        panel.add(commService);

        // Campus Service

        camService = new JCheckBox();
        camService.setText("Campus Service");
        camService.setBounds(20, 220, 200, 25);
        camService.setToolTipText("Campus Service: Any event where your club is doing community service on your school's campus, that is hosted by the school's administrative or student body.");
        pageOneCheckBox.add(camService);
        panel.add(camService);

        // Service Administration
        
        sAdmin = new JCheckBox();
        sAdmin.setText("Service Administration");
        sAdmin.setBounds(20, 240, 200, 25);
        sAdmin.setToolTipText("Service Administration: Time spent planning service, this includes but is not limited to, committee meetings, single service projects, activism, and planning charitable fundraisers. Service Administration hours cannot exceed 50% of a member's total service hours (e.g. if a member has a total of 80 active service hours, the total service administration hours can only be 40 hours. A total of 120 service hours)");
        pageOneCheckBox.add(sAdmin);
        panel.add(sAdmin);

        // Continuing Service

        conServ = new JCheckBox();
        conServ.setText("Continuing Service");
        conServ.setBounds(20, 260, 200, 25);
        conServ.setToolTipText("Continuing Service: An event that has been completed with the same organization repeatedly at least once a month for a two-month duration.");
        pageOneCheckBox.add(conServ);
        panel.add(conServ); 

        // District Service Initiative

        dSI = new JCheckBox();
        dSI.setText("District Service Initiative");
        dSI.setBounds(20, 280, 200, 25);
        dSI.setToolTipText("District Service Initiative: Any event that contributes to the current District Service Initiatives: Serving Our Environment, Community Wellness & Equity, and Food Insecurity.");
        pageOneCheckBox.add(dSI);
        panel.add(dSI);

        // International Service Partner

        iSP = new JCheckBox();
        iSP.setText("International Service Partner");
        iSP.setBounds(20, 300, 200, 25);
        iSP.setToolTipText("International Service Partner: Any event that contributes to or involves an international service partner or preferred charity.");
        pageOneCheckBox.add(iSP);
        panel.add(iSP);

        // Administrative

        admin = new JCheckBox();
        admin.setText("Administrative");
        admin.setBounds(20, 320, 200, 25);
        admin.setToolTipText("Any event related to the operation of the club should be tagged as AD. Examples of administrative events include but are not limited to attending meetings (e.g. general meetings, board meetings, committee meetings, Kiwanis meetings), and workshops.");
        pageOneCheckBox.add(admin);
        panel.add(admin);

        // Social Event

        socialE = new JCheckBox();
        socialE.setText("Social Event");
        socialE.setBounds(20, 340, 200, 25);
        socialE.setToolTipText("Any event in which club members are socially interacting with one another should be tagged as SE (e.g. a game night social after an event, movie nights, banquets).");
        pageOneCheckBox.add(socialE);
        panel.add(socialE);

        // Hosted through your Circle K club

        inClub = new JCheckBox();
        inClub.setText("Club Hosted");
        inClub.setBounds(20, 360, 200, 25);
        inClub.setToolTipText("Club Hosted: Any event hosted through your Circle K club.");
        pageOneCheckBox.add(inClub);
        panel.add(inClub);

        // Develop and Educate Members

        devE = new JCheckBox();
        devE.setText("Develop and Educate Members");
        devE.setBounds(250, 200, 200, 25);
        devE.setToolTipText("Membership Development: An event that promotes membership education, development, recruitment, and retention. Examples include: tabling, workshops, webinars, etc.");
        pageOneCheckBox.add(devE);
        panel.add(devE);

        // Fundraiser

        fund = new JCheckBox();
        fund.setText("Fundraiser");
        fund.setBounds(250, 220, 200, 25);
        fund.setToolTipText("Fundraiser: A home club-hosted event that raises money for a charity or for administrative funds. If 100% of the proceeds are donated to charity, then service planning hours may be given to the individuals who helped plan the event. Members who attended the event cannot simply receive service hours. If the proceeds go to the club's administrative funds, then the planning hours given may only be administrative.");
        pageOneCheckBox.add(fund);
        panel.add(fund);

        // Alumni

        alum = new JCheckBox();
        alum.setText("Alumni Present");
        alum.setBounds(250, 240, 200, 25);
        alum.setToolTipText("Alumni: An event in which two members from a Circle K club and at least two alumni are present. An alumnus/alumna is someone who was in Circle K and graduated from a college or university.");
        pageOneCheckBox.add(alum);
        panel.add(alum);

        // Kiwanis Family

        kFam = new JCheckBox();
        kFam.setText("Kiwanis Family Present");
        kFam.setBounds(250, 260, 200, 25);
        kFam.setToolTipText("Kiwanis Family: An event in which at least two members from your Circle K club and at least two members from another non-Circle K Kiwanis Family club (e.g. Key Club, Kiwanis) are present. Examples include: Kiwanis meetings, Key to College, Kiwanis Takeover, etc..");
        pageOneCheckBox.add(kFam);
        panel.add(kFam);

        // Interclub 

        iClub = new JCheckBox();
        iClub.setText("Interclub");
        iClub.setBounds(250, 280, 200, 25);
        iClub.setToolTipText("Interclub: An event in which there must be a certain amount of members from your Circle K club and only two members from another Circle K/Kiwanis Family club present, depending on your Circle K club's number of dues paid members. Clubs with less than or equal to 50 members need a minimum of two members present; clubs with 51-90 members need a minimum of three members present; and clubs with greater than or equal to 91 members need a minimum of four members present. General Meetings that also include the Club Hosted (HE) tag cannot be considered an Interclub event for the host club.");
        pageOneCheckBox.add(iClub);
        panel.add(iClub);

        // Webinar

        web = new JCheckBox();
        web.setText("Webinar");
        web.setBounds(250, 300, 200, 25);
        web.setToolTipText("Webinar: A workshop that is broadcasted online on the Club, Division, District, or International level.");
        pageOneCheckBox.add(web);
        panel.add(web);

        // Divisional Event

        divEvent = new JCheckBox();
        divEvent.setText("Divisional Event");
        divEvent.setBounds(250, 320, 200, 25);
        divEvent.setToolTipText("Divisional: An event hosted by and for your home Division, which is usually done by the respective Lieutenant Governor (and Divisional Board).");
        pageOneCheckBox.add(divEvent);
        panel.add(divEvent);

        // District Event

        disEvent = new JCheckBox();
        disEvent.setText("District Event");
        disEvent.setBounds(250, 340, 200, 25);
        disEvent.setToolTipText("District: An event hosted by and for the District.");
        pageOneCheckBox.add(disEvent);
        panel.add(disEvent);

        // International Event

        iEvent = new JCheckBox();
        iEvent.setText("International Event");
        iEvent.setBounds(250, 360, 200, 25);
        iEvent.setToolTipText("International: An event hosted by Circle K International.");
        pageOneCheckBox.add(iEvent);
        panel.add(iEvent);

        // Next Button
    
        next = new JButton("Next");
        next.setBounds(360,420, 100,25);
        next.addActionListener(this);
        panel.add(next);
        // -----------------------------------------------------------------------------------------------------------
        frame.setSize(500, 500);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CERF Creation Tool");
        frame.setSize(500, 500);
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }

     public static String getEventName() {
         return nameOfEventI.getText();
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JPanel getPanel() {
        return panel;
    }
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Go through text fields
        for (int i = 0; i < pageOneTextFields.size(); i++) {
            App.editCell(ExcelConstants.getA(i), ExcelConstants.getB(i), ExcelConstants.getC(i), pageOneTextFields.get(i).getText());
            if (i == 4) {
                App.editCell(ExcelConstants.getA(i), ExcelConstants.getB(i), ExcelConstants.getC(i), pageOneTextFields.get(i).getText() + " - " + timeII.getText());
            }
        }

        // Go through check boxes 
        for (int i = 0; i < pageOneCheckBox.size(); i++) {
            if (pageOneCheckBox.get(i).isSelected() == true)
            {
                App.editCell(ExcelConstants.getA(i + ARRAY_BUFFER), ExcelConstants.getB(i + ARRAY_BUFFER), ExcelConstants.getC(i + ARRAY_BUFFER), "x");
            }
        }
        //App.editCell(2, 23, 1, pageOneTextFields.get(0).getText());
        System.out.println("changed");
        //App.getEvent();
        panel.removeAll();
        panel.repaint();
        new GUI2();
/*          try {
            App.saveWb();
            App.closeWb();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            System.out.println("lol");
            e1.printStackTrace();
        } */
    } 
}
