import java.util.Scanner;
//1703A
public class YesOrYes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String check="yes";
        for(int i=0;i<n;i++){
            String str=sc.next();
            str=str.toLowerCase();
            if(str.equals(check)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
