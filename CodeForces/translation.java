import java.util.Scanner;
//41a
public class translation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String original = sc.next();
        String org=sc.next();
        String reversed = new StringBuilder(original).reverse().toString();
        if(org.equals(reversed)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
