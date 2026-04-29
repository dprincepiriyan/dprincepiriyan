//263A

import java.util.Scanner;

public class beautifulmatrix {
    public static void main(String[] args) {
        int rowpos=0;
        int colpos=0;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int val=sc.nextInt();
                if(val==1){
                    rowpos=i;
                    colpos=j;
                }
            }
        }
        int x=Math.abs(colpos-2);
        int y=Math.abs(rowpos-2);
        System.out.println(x+y);
        sc.close();
    }
}