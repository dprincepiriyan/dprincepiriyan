//116A

import java.util.Scanner;

public class tram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int current=0;
        int maxCap=0;
        for(int i=0;i<n;i++){
            int exit=sc.nextInt();
            int enter=sc.nextInt();
            current=current-exit+enter;
            if(current>maxCap){
                maxCap=current;
            }
        }
        System.out.println(maxCap);
        sc.close();
    }
}
