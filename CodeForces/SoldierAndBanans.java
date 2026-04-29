//546A

import java.util.Scanner;

public class SoldierAndBanans {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextInt();
        long b=sc.nextInt();
        long c=sc.nextInt();
        long total=a*((c*(c+1))/2);
        long borrow=total-b;
        System.out.println(Math.max(0, borrow));
        sc.close();
    }
}
