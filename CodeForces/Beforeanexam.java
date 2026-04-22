import java.util.Scanner;
public class Beforeanexam {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int d=sc.nextInt();
        int sumtime=sc.nextInt();
        int[] minTime=new int[d];
        int[] maxTime=new int[d];
        int totalmin=0;
        int totalmax=0;
        for(int i=0;i<d;i++){
            minTime[i]=sc.nextInt();
            maxTime[i]=sc.nextInt();
            totalmin+=minTime[i];
            totalmax+=maxTime[i];
        }
        if(sumtime<totalmin||sumtime>totalmax){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            int[] schedule=new int [d];
            for(int i=0;i<d;i++){
                schedule[i]=minTime[i];
            }
            int extratime=sumtime-totalmin;
            for(int i=0;i<d&&extratime>0;i++){
                int roomInDay=maxTime[i]-minTime[i];
                int add=Math.min(roomInDay, extratime);
                schedule[i]+=add;
                extratime-=add;

        }
        StringBuilder result = new StringBuilder();
            for (int i = 0; i < d; i++) {
                result.append(schedule[i]).append(i == d - 1 ? "" : " ");
            }
            System.out.println(result.toString());
    }
    System.out.println("jizz");
    sc.close();
}}

