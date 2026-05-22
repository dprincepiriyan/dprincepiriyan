import java.util.Scanner;
//584A
public class OlesyaandRodion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int t=sc.nextInt();
        if(n==1&& t==10){
            System.out.println("-1");
        }else{
            StringBuilder sb=new StringBuilder();
            if(t==10){
                sb.append(1);
                for(int i=0;i<n-1;i++){
                    sb.append(0);
                }
            }else{
                sb.append(t);
                    for(int i=0;i<n-1;i++){
                        sb.append(0);
                    }
                
                
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
