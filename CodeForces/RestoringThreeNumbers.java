import java.util.Arrays;
import java.util.Scanner;
//1154A
public class RestoringThreeNumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] collection=new int[4];
        for(int i=0;i<4;i++){
            int a=sc.nextInt();
            collection[i]=a;
        }
        Arrays.sort(collection);
        int S=collection[3];
        int a=S-collection[0];
        int b=S-collection[1];
        int c=S-collection[2];
        System.out.println(a+" "+b+" "+c);
        sc.close();
    }
}
