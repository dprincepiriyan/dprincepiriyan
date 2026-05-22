import java.util.Scanner;
//750A
public class NewYearandHurry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int TimeLeft=240-b;
        int problemSolved=0;
        for(int i=1;i<=a;i++){
            int time=5*i;
            if(TimeLeft>=time){
                TimeLeft-=time;
                problemSolved++;
            }
            else{
                break;
            }
           
        }
        System.out.println(problemSolved);
        sc.close();
    }
}
