import java.util.Scanner;
//69a
public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int countX=0;
        int countY=0;
        int countZ=0;
        for(int i=0;i<n;i++){
            countX+=sc.nextInt();
            countY+=sc.nextInt();
            countZ+=sc.nextInt();
        }
        if(countX==0 && countY==0&& countZ==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
}
