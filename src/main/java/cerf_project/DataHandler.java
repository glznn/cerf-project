package cerf_project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataHandler {
    private static String time;
    private static ArrayList<String> attendees = new ArrayList<>();

    DataHandler() {
    }

    public static void setTime(String iTime) {
        time = iTime;
    }

    public static void calcTimeDiff(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String startTime = " ";
        String endTime = " ";
    }

    public static void addA(String person) {
        attendees.add(person); 
    }

    public static ArrayList<String> getAttendees() {
        return attendees;
    }

    // For Testing

    public static void printAttendees() {
        for (int i = 0; i < attendees.size(); i++) {
            System.out.println(attendees.get(i));
        }
    }
}
