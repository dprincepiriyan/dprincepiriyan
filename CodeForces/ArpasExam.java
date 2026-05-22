import java.util.Scanner;
//742A
public class ArpasExam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){
            System.out.println(1);
        }else{
            int a=n%4;
        switch (a) {
            case 1:
                System.out.println(8);
                break;
            case 2:
                System.out.println(4);
                break;
            case 3:
                System.out.println(2);
                break;
            case 0:
                System.out.println(6);
                break;
            default:
                break;
        }
    }
        sc.close();
    }
}
