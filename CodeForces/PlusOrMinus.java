import java.util.Scanner;
//1807A
public class PlusOrMinus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            if(a+b==c){
                System.out.println("+");
            }else if(a-b==c){
                System.out.println("-");
            }
        }
        sc.close();
    }
}
