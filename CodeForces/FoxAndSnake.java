//510A

import java.util.Scanner;

public class FoxAndSnake {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        for(int i=1;i<=a;i++){
            if(i%2==1){
                System.out.println("#".repeat(b));
            }else{
                if(i%4==2){
                    System.out.println(".".repeat(b-1)+'#');
                }
                else if(i%4==0){
                    System.out.println('#'+".".repeat(b-1));
                }
            }
        }
        sc.close();
    }
}
