import java.util.Scanner;
//476A
public class DreamoonAndStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        if(m>n){
            System.out.println(-1);
        }else{
            int minMoves=(n+1)/2;
            int result=minMoves;
            while(result%m!=0){
                result++;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
