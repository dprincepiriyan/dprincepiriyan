import java.util.Scanner;
//1374C
public class MoveBrackets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String s=sc.next();
            int balance=0;
            int moves=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='('){
                    balance++;
                }else{
                    if(balance>0){
                        balance--;
                    }else{
                        moves++;
                    }
                }
            }
            System.out.println(moves);
        }
        
        sc.close();
    }
}
