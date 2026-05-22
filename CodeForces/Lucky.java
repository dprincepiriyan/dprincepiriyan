import java.util.Scanner;
//1676A
public class Lucky {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int second=a%1000;
            int first=a/1000;
            if(checkSum(second)==checkSum(first)){
                System.out.println("yes");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static int checkSum(int a) {
        int Sum=0;
        while (a>0) {
            Sum+=a%10;
            a/=10;
        }
        return Sum;
    }
}

