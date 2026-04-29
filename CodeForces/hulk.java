//705A

import java.util.Scanner;

public class hulk {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder str=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                str.append("I hate ");
            }else{
                str.append("I love ");
            }
            if(i==n){
                str.append("it");
            }else{
                str.append("that ");
            }
        }
        System.out.println(str.toString());
        sc.close();
    }
}
