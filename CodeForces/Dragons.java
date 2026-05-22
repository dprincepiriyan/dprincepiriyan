import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//230A
public class Dragons {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int n=sc.nextInt();
        int[][] dragon=new int[n][2];
        for(int i=0;i<n;i++){
            dragon[i][0]=sc.nextInt();
            dragon[i][1]=sc.nextInt();
        }
        Arrays.sort(dragon,Comparator.comparingInt(a->a[0]));
        boolean canWin=true;
        for(int i=0;i<n;i++){
            if(s>dragon[i][0]){
                s+=dragon[i][1];
            }else{
                canWin=false;
                break;
            }
        }
        if(canWin){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
