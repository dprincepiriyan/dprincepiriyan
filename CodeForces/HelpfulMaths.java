import java.util.*;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        // 1. Split the string into an array of numbers (as strings)
        String[] numbers = s.split("\\+");
        
        // 2. Sort the array
        Arrays.sort(numbers);
        
        // 3. Join them back with "+"
        // String.join is a very handy tool for this!
        String result = String.join("+", numbers);
        
        System.out.println(result);
    }
}