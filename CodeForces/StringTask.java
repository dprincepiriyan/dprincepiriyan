import java.util.Scanner;
//118A
public class StringTask {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        str=str.toLowerCase();
        StringBuilder result=new StringBuilder();
        String vowels="aeiouy";
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(vowels.indexOf(c)==-1){
                result.append(".");
                result.append(c);
            }
        }
        System.out.println(result.toString());
        sc.close();
    }
}
