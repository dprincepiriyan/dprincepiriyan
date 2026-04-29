import java.util.Arrays;
import java.util.Scanner;
//141A
public class Amusingjoke {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        String pile=sc.next();
        if(s1.length()+s2.length()!=pile.length()){
            System.out.println("NO");
            sc.close();
            return;
        }
        String combined=s1+s2;
        char[] c1=combined.toCharArray();
        char[] c2=pile.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1, c2)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
