//236A

import java.util.HashSet;
import java.util.Scanner;

public class BoyOrGirl {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        HashSet<Character> distinctChar = new HashSet<>();
        for(int i=0;i<str.length();i++){
            distinctChar.add(str.charAt(i));
        }
        if(distinctChar.size()%2==0){
            System.out.println("CHAT WITH HER!");
        }else{
            System.out.println("IGNORE HIM!");
        }
        sc.close();
    }
}
