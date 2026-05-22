import java.util.Scanner;
//58A
public class ChatRoom {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String target="hello";
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==target.charAt(j)){
                j++;
            }
            if(j==5){
                break;
            }
        }
        if(j==5){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
