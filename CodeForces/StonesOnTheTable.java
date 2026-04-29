//266A

import java.util.Scanner;

public class StonesOnTheTable {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=0;
        int n=sc.nextInt();
        String str=sc.next();
        for(int i=0;i<=n-2;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
