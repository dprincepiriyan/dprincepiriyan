import java.util.Scanner;
//581A
public class VasyaTheHipster {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int diff=0;
        int same=0;
        if(a>b){
            diff+=b;
            a=a-b;
            if(a>1){
                same+=a/2;
            }
        }else{
            diff+=a;
            b=b-a;
            if(b>1){
                same+=b/2;
            }
        }
        System.out.println(diff+" "+same);

        sc.close();
    }
}
