import java.util.Scanner;
//1335A
public class CandiesandTwoSisters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n-->0) {
            long t=sc.nextLong();
            System.out.println((t-1)/2);
        }
        
        sc.close();

    }
}
