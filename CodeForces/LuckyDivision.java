import java.util.Scanner;
//122A
public class LuckyDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int[] lucky={4,7,44,47,74,77,444,447,474,477,744,747,774,777};
        boolean isAlmostLucky=false;
        for(int i=0;i<lucky.length;i++){
            if(a%lucky[i]==0){
                isAlmostLucky=true;
                break;
            }
        }
        if (isAlmostLucky==true) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
