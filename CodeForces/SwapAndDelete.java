import java.util.Scanner;

public class SwapAndDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String s = sc.next();
            
            int count0 = 0;
            int count1 = 0;
            
            // Step 1: Count total available 0s and 1s
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') count0++;
                else count1++;
            }
            
            // Step 2: Try to satisfy each position from left to right
            int remainingDeletions = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    // We need a '1'
                    if (count1 > 0) {
                        count1--;
                    } else {
                        // Stuck! We must delete everything from index 'i' to the end
                        remainingDeletions = s.length() - i;
                        break;
                    }
                } else {
                    // We need a '0'
                    if (count0 > 0) {
                        count0--;
                    } else {
                        // Stuck! We must delete everything from index 'i' to the end
                        remainingDeletions = s.length() - i;
                        break;
                    }
                }
            }
            
            System.out.println(remainingDeletions);
        }
        sc.close();
    }
}