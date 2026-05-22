import java.util.Scanner;
//151A
public class SoftDrinking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int l=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int p=sc.nextInt();
        int nl=sc.nextInt();
        int np=sc.nextInt();
        int mil=(k*l)/nl;
        int lime=c*d;
        int salt=p/np;
        int totaltoasts=Math.min(mil, Math.min(salt, lime));
        System.out.println(totaltoasts/n);
        sc.close();
    }
}
