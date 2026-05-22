import java.util.Scanner;

public class RoadToZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ 
            sc.close();
            return;
        }
        int t = sc.nextInt();
        
        while (t-- > 0) {
            // Use long for all inputs to prevent overflow
            long x = sc.nextLong();
            long y = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            // Step 1: Normalize to positive distances
            x = Math.abs(x);
            y = Math.abs(y);
            
            // Step 2: Ensure x is the smaller one for easier math
            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }
            
            // Strategy 1: Only use 'a' (single moves)
            long ans1 = (x + y) * a;
            
            // Strategy 2: Use 'b' for the common part, then 'a' for the rest
            long ans2 = (x * b) + ((y - x) * a);
            
            // The answer is the cheaper of the two
            System.out.println(Math.min(ans1, ans2));
        }
        sc.close();
    }
}