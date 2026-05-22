import java.util.Scanner;
//1141A
public class Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        if(m%n!=0){
            System.out.println(-1);
            sc.close();
            return;
        }
        int q=m/n;
        int moves=0;
        while(q%2==0){
            q/=2;
            moves++;
        }
        while (q%3==0) {
            q/=3;
            moves++;
        }
        if(q==1){
            System.out.println(moves);
        }else{
            System.out.println(-1);
        }
        
        sc.close();
    }
}
