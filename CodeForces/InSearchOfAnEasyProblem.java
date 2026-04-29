//1030A

import java.util.Scanner;

public class InSearchOfAnEasyProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            if(a==1){
                System.out.println("hard");
                return;
            }
        }
        System.out.println("easy");
        sc.close();
    }
}
