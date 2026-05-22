import java.util.Scanner;
//379A
public class NewYearCandles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int totalhours=a;
        int stubs=a;
        while(stubs>=b){
            int newcandles=stubs/b;
            totalhours+=newcandles;
            stubs=newcandles+(stubs%b);
        }
        
        System.out.println(totalhours);
        sc.close();
    }
}
