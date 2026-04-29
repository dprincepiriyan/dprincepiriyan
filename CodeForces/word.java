//59A

import java.util.Scanner;

public class word {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int lower=0;
        int upper=0;
        for(int i=0;i<str.length();i++){
            if(Character.isUpperCase(str.charAt(i))){
                upper++;
            }else{
                lower++;
            }
        }
        if(upper>lower){
            System.out.println(str.toUpperCase());
        }else{
            System.out.println(str.toLowerCase());
        }
        sc.close();
    }
}
