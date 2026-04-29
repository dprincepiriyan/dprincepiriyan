import java.util.Scanner;

public class ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] height=new int[n];
        int high=0;
        int high_index=0;
        int low_index=0;
        int low=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            height[i]=a;
            if(a>high){
                high=a;
                high_index=i;
            }
            if(a<=low){
                low=a;
                low_index=i;
            }
        }
        int total=high_index+(n-1-low_index);
        if(high_index>low_index){
            total--;
        }
        System.out.println(total);
        sc.close();
    }
}
