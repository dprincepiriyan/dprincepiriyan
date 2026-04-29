import java.util.Scanner;
//1742A
public class sum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int count=a+b+c;
            // Inside your loop:
if ((count - a) == a || (count - b) == b || (count - c) == c) {
    System.out.println("YES");
} else {
    System.out.println("NO");
}
                
        }
        
        sc.close();
    }
}
