import java.util.Scanner;
//131A
public class cAPSlOCK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        boolean condition=true;
        for(int i=1;i<s.length();i++){
            if(Character.isLowerCase(s.charAt(i))){
                condition=false;
                break;
            }
        }
        if(condition){
            StringBuilder result=new StringBuilder();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(Character.isUpperCase(c)){
                    result.append(Character.toLowerCase(c));
                }else{
                    result.append(Character.toUpperCase(c));
                }
            }
            System.out.println(result.toString());
        }else{
            System.out.println(s);
        }
        sc.close();
    }
}
