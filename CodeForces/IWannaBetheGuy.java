//469A

import java.util.Scanner;

public class IWannaBetheGuy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean[] levels=new boolean[n+1];
        int a=sc.nextInt();
        for(int i=0;i<a;i++){
            int x=sc.nextInt();
            levels[x]=true;
        }
        int b=sc.nextInt();
        for(int i=0;i<b;i++){
            int y=sc.nextInt();
            levels[y]=true;
        }
        for(int i=1;i<=n;i++){
            if(levels[i]==false){
                System.out.println("Oh, my keyboard!");
                return;
            }
        }
        System.out.println("I become the guy.");
        sc.close();
    }
    
}