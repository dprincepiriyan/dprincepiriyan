import java.util.Scanner;

public class team2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), ans=0;
        while(n-->0){
            if(sc.nextInt()+sc.nextInt()+sc.nextInt()>=2) ans++;
        }
        System.out.println(ans);
    }
}
