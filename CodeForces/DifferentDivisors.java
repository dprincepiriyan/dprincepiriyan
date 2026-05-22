import java.util.Scanner;

public class DifferentDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long d = sc.nextLong(); // The difference required
            
            // Step 1: Find the first prime p >= 1 + d
            long p = findNextPrime(1 + d);
            
            // Step 2: Find the first prime q >= p + d
            long q = findNextPrime(p + d);
            
            // Step 3: Print their product
            System.out.println(p * q);
        }
        sc.close();
    }
    
    // Helper method to look for the next available prime number
    private static long findNextPrime(long start) {
        while (true) {
            if (isPrime(start)) {
                return start;
            }
            start++;
        }
    }
    
    // Standard O(sqrt(N)) primality tester
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}