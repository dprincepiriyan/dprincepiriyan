import java.util.Scanner;
//268A
public class Games {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] home=new int[n];
        int[] guest=new int[n];
        for(int i=0;i<n;i++){
            int h=sc.nextInt();
            home[i]=h;
            int g=sc.nextInt();
            guest[i]=g;
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(home[i]==guest[j]){
                    count++;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
