import java.util.Scanner;
//791A
public class BearAndBigBrother {
    public static void main(String[] args) {
        int count=0;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        while(a<=b){
            a*=3;
            b*=2;
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
