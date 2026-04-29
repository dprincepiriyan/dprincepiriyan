import java.util.HashSet;
import java.util.Scanner;
//520A
public class pangram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Character> set=new HashSet<>();
        int a=sc.nextInt();
        String str=sc.next();
        str=str.toLowerCase();
        for(int i=0;i<a;i++){
            set.add(str.charAt(i));
        }
        if(set.size()==26){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
