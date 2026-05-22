import java.util.Arrays;
import java.util.Scanner;
//723A
public class TheNewYear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int[] d=new int[3];
        d[0]=a;
        d[1]=b;
        d[2]=c;
        Arrays.sort(d);

        int distance=(d[2]-d[0]);
        System.out.println(distance);
        sc.close();
    }
}
