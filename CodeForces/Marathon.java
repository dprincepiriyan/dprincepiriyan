import java.util.Scanner;
//1692A
public class Marathon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();  
        for(int i=0;i<n;i++){
            int count=0;
            int timur=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            if(b>timur){
                count++;
            }
            if (c>timur) {
                count++;
            }
            if (d>timur) {
                count++;
            }
            System.out.println(count);
        }
        sc.close();
    }
}
