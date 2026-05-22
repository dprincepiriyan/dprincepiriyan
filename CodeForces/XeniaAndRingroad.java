import java.util.Scanner;
//339B
public class XeniaAndRingroad {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long totalTime=0;
        int currentPos=1;
        for(int i=0;i<m;i++){
            int nextTaskHouse=sc.nextInt();
            if(nextTaskHouse>=currentPos){
                totalTime+=(nextTaskHouse-currentPos);
            }else{
                totalTime+=(n-currentPos)+nextTaskHouse;
            }
            currentPos=nextTaskHouse;
        }
        System.out.println(totalTime);
        sc.close();
    }
}
