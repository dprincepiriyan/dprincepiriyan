import java.util.Scanner;
//112A
public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        int result=str1.compareTo(str2);
        if(result<0){
            System.out.println("-1");
        }else if(result>0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
        sc.close();
    }
}
