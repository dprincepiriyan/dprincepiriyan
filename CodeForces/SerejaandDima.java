import java.util.Arrays;
import java.util.Scanner;
//381A
public class SerejaandDima {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sereja=0;
        int dima=0;
        int[] cards=new int[n];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            cards[i]=a;
        }
        boolean serejaTurn=true;
        int left=0;
        int right=n-1;
        while(left<=right){
            if(cards[left]>cards[right]){
                if(serejaTurn) sereja+=cards[left];
                else dima+=cards[left];
                left++;
            }else{
                if(serejaTurn) sereja+=cards[right];
                else dima+=cards[right];
                right--;
            }
            serejaTurn=!serejaTurn;
        }
        System.out.println(sereja+" "+dima);
        sc.close();
    }
}
