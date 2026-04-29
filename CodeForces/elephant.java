import java.util.Scanner;
//617A
public class elephant {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int dist=sc.nextInt();
    int count=0;
    count=dist/5;
    if(dist%5!=0){
        count++;
    }
    System.out.println(count);
    sc.close();
    }
}
