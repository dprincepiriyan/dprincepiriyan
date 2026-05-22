import java.util.Scanner;
//427A
public class PoliceHiring {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int availableOfficer = 0;
    int untreatedCrime = 0;
    int n = sc.nextInt(); // Total number of events

    for (int i = 0; i < n; i++) {
        int event = sc.nextInt(); // READ THE INDIVIDUAL EVENT!

        if (event == -1) {
            // A crime happened
            if (availableOfficer > 0) {
                availableOfficer--; // Use an officer
            } else {
                untreatedCrime++; // No one available
            }
        } else {
            // Recruits were hired
            availableOfficer += event;
        }
    }
    System.out.println(untreatedCrime);
    sc.close();
}
}
