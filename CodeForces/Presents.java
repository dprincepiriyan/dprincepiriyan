//136A

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] given=new int[n+1];
        for(int i=1;i<=n;i++){
            int receiver=sc.nextInt();
            given[receiver]=i;
        }
        for(int i=1;i<=n;i++){
            System.out.print(given[i]+" ");
        }
        sc.close();
    }
}
