import java.util.Scanner;

public class TrafficLight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            String s = sc.next();
            
            // If the current color is already green, the wait is 0
            if (c == 'g') {
                System.out.println(0);
                continue;
            }
            
            // Double the string to handle the circular wrap-around easily
            String doubled = s + s;
            int maxWait = 0;
            int nextGreen = -1;
            
            // Sweep backwards from the end of the doubled string
            for (int i = 2 * n - 1; i >= 0; i--) {
                if (doubled.charAt(i) == 'g') {
                    nextGreen = i;
                }
                
                // If we are in the first half of the doubled string 
                // and find our target color 'c'
                if (i < n && doubled.charAt(i) == c) {
                    maxWait = Math.max(maxWait, nextGreen - i);
                }
            }
            
            System.out.println(maxWait);
        }
        sc.close();
    }
}