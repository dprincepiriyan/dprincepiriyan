//734A

import java.util.Scanner;

public class AntonAndDanik {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        int c=sc.nextInt();
        String n=sc.next();
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='A'){
                a++;
            }else{
                b++;
            }
        }
        if(a>b){
            System.out.println("Anton");
        }else if(b>a){
            System.out.println("Danik");
        }else{
            System.out.println("Friendship");
        }
        sc.close();
    }
}
