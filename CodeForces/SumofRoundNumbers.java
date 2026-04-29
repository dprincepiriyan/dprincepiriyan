import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//1352A
public class SumofRoundNumbers {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
        // 1. Reset the list and multiplier for EACH test case
        List<Integer> rounds = new ArrayList<>();
        int a = sc.nextInt();
        int multiplier = 1;

        while (a > 0) {
            int digit = a % 10;
            if (digit != 0) {
                rounds.add(digit * multiplier);
            }
            a /= 10;
            multiplier *= 10;
        }

        // 2. Print the size for THIS test case
        System.out.println(rounds.size());

        // 3. Print the numbers for THIS test case on one line
        for (int val : rounds) {
            System.out.print(val + " ");
        }
        System.out.println(); // New line for the next test case
    }
    sc.close();
}
}
