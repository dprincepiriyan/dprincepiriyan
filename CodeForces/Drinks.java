import java.util.Scanner;
//200B
public class Drinks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        double c=0;
        for(int i=0;i<a;i++){
            int b=sc.nextInt();
            c+=b;
        }
        System.out.printf("%.12f",c/a);
        sc.close();
    }
}
