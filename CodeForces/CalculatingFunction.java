//486A

import java.util.Scanner;

public class CalculatingFunction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        if(a%2==0){
            System.out.println(a/2);
        }else{
            System.out.println(-(a/2+1));
        }
        sc.close();
    }
}
