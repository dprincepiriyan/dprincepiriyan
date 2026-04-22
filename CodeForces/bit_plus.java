//282A
import java.util.Scanner;

public class bit_plus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int b=0;
        while(x-->0){
            String s=sc.next();
            if(s.charAt(1)=='+'){
                b++;
            }else if(s.charAt(1)=='-'){
                b--;
            }
        }
        System.out.println(b);
    }
}
