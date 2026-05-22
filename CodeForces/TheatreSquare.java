import java.util.Scanner;
//1A
public class TheatreSquare {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        long a=sc.nextLong();
        long sum=((n+a-1)/a)*((m+a-1)/a);
        System.out.println(sum);
        sc.close();
    }
}
