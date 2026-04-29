import java.util.Scanner;
//61A
public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                result.append("1");
            }else{
                result.append("0");
            }
        }
        System.out.println(result);
        sc.close();
    }
}
