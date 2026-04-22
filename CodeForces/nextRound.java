import java.util.Scanner;
//158A
public class nextRound {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] scores= new int[n];
        for (int i=0;i<n;i++){
            scores[i]=sc.nextInt();
        }
        int target=scores[k-1];
        int count=0;
        for(int score: scores){
            if (score>=target && score>0){
                count++;
            }
        }
        System.out.println(count);
    }
}
