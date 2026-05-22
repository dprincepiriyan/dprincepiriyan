import java.util.Scanner;
//450A
public class JzzhuAndChildren {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int lastchild=1;
        double maxTurns=0;
        for(int i=1;i<=n;i++){
            int a=sc.nextInt();
            int turns=(a+m-1)/m;
            if(turns>=maxTurns){
                maxTurns=turns;
                lastchild=i;
            }
        }
        System.out.println(lastchild);
        sc.close();
    }
}
