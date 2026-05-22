import java.util.Scanner;
//1985C
public class GoodPrefixes{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        while (t-->0) {
            int n=sc.nextInt();
            int[]a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            long totalsum=0;
            int maxelement=0;
            int good=0;
            for(int i=0;i<n;i++){
                totalsum+=a[i];
                maxelement=Math.max(maxelement, a[i]);
                if(totalsum==2L*maxelement){
                    good++;
                }
            }
            sb.append(good).append("\n");
        }
        System.out.println(sb);
        sc.close();
    }
}