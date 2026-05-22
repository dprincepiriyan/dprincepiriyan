import java.util.Scanner;

public class NatashaAndNearlyGoodNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long a=sc.nextLong();
            long b=sc.nextLong();
            if(b==1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
                long x=a;
                long y=a*b;
                long z=a*(b+1);
                System.out.println(x+" "+y+" "+z);
            }
            
        }
        sc.close();
    }
}
