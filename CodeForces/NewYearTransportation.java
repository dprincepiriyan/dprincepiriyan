import java.util.Scanner;
//500A
public class NewYearTransportation{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        int arr[]=new int[n];
        for(int i=1;i<=n-1;i++){
            arr[i]=sc.nextInt();
        }
        int curr=1;
        while(curr<t){
            curr=curr+arr[curr];
        }
        if(curr==t){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
        sc.close();
    }
}