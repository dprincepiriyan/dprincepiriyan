//228A

import java.util.Scanner;
import java.util.HashSet;
public class horseshoe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> colors=new HashSet<>();
        for(int i =0;i<4;i++){
            colors.add(sc.nextInt());
        }
        System.out.println(4-colors.size());
        sc.close();
    }
}
