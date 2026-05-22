import java.util.Scanner;
//155a
public class ILoveUserName {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int base=sc.nextInt();
        int high=base;
        int low=base;
        int count=0;
        for(int i=1;i<n;i++){
            int a=sc.nextInt();
            if(a<low){
                low=a;
                count++;
            }else if(a>high){
                high=a;
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
