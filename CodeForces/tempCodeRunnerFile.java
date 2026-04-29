import java.util.Scanner;

public class tempCodeRunnerFile {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int final_count=0;
        for(int i=0;i<n;i++){
            if(i<k-1){
                final_count++;
            }else{
                if(sc.nextInt()==sc.nextInt()){
                    final_count++;
                }else{
                    break;
                }
            }


        }
        System.out.println(final_count);
        sc.close();
    }
}
