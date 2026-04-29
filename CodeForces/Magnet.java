import java.util.Scanner;
//344A
public class Magnet{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int count=1;
        String prev=sc.next();
        for(int i=1;i<a;i++){
            String curr=sc.next();
            if(!curr.equals(prev)){
                count++;
                prev=curr;
            }
        }
        System.out.println(count);
        sc.close();
    }
}