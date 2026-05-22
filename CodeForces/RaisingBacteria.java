import java.util.Scanner;
//579A
public class RaisingBacteria {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Integer.bitCount(n));
        sc.close();
    }
}
