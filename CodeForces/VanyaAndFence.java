//677A

import java.util.Scanner;

public class VanyaAndFence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int h=sc.nextInt();
        int count=0;
        for(int i=0;i<n;i++){
            int w=sc.nextInt();
            if(w>h){
                count+=2;
            }else if(w<=h){
                count+=1;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
