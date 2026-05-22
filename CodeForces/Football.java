import java.util.Scanner;
//43A
public class Football {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count1=1;
        int count2=0;
        String a=sc.next();
        String c="";
        for(int i=1;i<n;i++){
            String b=sc.next();
            if(a.equals(b)){
                count1++;
            }else{
                count2++;
                c=b;
            }
        }
        if(count1>count2){
            System.out.println(a);
        }else{
            System.out.println(c);
        }
        
        sc.close();
    }
}
