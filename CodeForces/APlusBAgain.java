import java.util.Scanner;
//1999A
public class APlusBAgain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=a%10;
            int c=a/10;
            System.out.println(b+c);
        }
        sc.close();
    }
}
