import java.util.Scanner;
//996A
public class HitTheLottery {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long count=0;
        count+=a/100;
        a%=100;
        count+=a/20;
        a%=20;
        count+=a/10;
        a%=10;
        count+=a/5;
        a%=5;
        count+=a;
        a%=1;
        System.out.println(count);
        sc.close();
    }
}
