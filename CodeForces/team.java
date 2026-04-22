//231A

import java.util.Scanner;

public class team {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int final_count=0;
        while (n-->0) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int count=0;
            if(a==1){
                count++;
            }
            if (b==1) {
                count++;
            }
            if (c==1){
                count++;
            }
            if (count>=2){
                final_count++;
            }

        }
        System.out.println(final_count);
    }
    
}