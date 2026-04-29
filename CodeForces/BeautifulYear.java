import java.util.Scanner;
//271A
public class BeautifulYear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y=sc.nextInt();
        for(int i=y+1;i<=9100;i++){
            int a=i/1000;
            int b=(i/100)%10;
            int c=(i/10)%10;
            int d=i%10;
            if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d){
                System.out.println(i);
                break;
            }
        }
        sc.close();
    }
}
