import java.util.*;

public class Monsters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            // We store the monsters as an array of a custom class or a 2D array
            // Integer objects are needed to use a custom Comparator on indices
            Integer[] indices = new Integer[n];
            int[] modifiedHealth = new int[n];
            
            for (int i = 0; i < n; i++) {
                int h = sc.nextInt();
                int rem = h % k;
                if (rem == 0) rem = k; // Treat divisible by k as the maximum
                
                modifiedHealth[i] = rem;
                indices[i] = i + 1; // Store 1-based index
            }
            
            // Sort indices based on health (descending) 
            // If health is equal, sort by index (ascending)
            Arrays.sort(indices, (a, b) -> {
                if (modifiedHealth[b - 1] != modifiedHealth[a - 1]) {
                    return modifiedHealth[b - 1] - modifiedHealth[a - 1];
                }
                return a - b;
            });
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(indices[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}