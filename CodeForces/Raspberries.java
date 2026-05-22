import java.util.Scanner;
//1883C
public class Raspberries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int t=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[t];
            int minOps=k;
            int evenCount=0;
            for(int j=0;j<t;j++){
                arr[j]=sc.nextInt();
                if(arr[j]%2==0) evenCount++;
                int cost=(k-(arr[j]%k))%k;
                minOps=Math.min(minOps, cost);
            }
            if(k==4){
                int costForTwoEvens=Math.max(0,2-evenCount);
                minOps=Math.min(minOps, costForTwoEvens);
            }
            System.out.println(minOps);


        }
        sc.close();
    }
}
