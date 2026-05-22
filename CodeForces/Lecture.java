import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//499B
public class Lecture {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Map<String,String> dict=new HashMap<>();
        for(int i=0;i<m;i++){
            String a=sc.next();
            String b=sc.next();
            if(b.length()<a.length()){
                dict.put(a, b);
            }else{
                dict.put(a, a);
            }
        }
        StringBuilder sbr=new StringBuilder();
        for(int i=0;i<n;i++){
            String lecture=sc.next();
            sbr.append(dict.get(lecture)).append(" ");
        }
        System.out.println(sbr.toString().trim());
        sc.close();
    }
}
