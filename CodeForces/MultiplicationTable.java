import java.util.Scanner;
//577A
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            if(x%i==0 && x/i<=n){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
