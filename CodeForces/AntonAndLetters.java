import java.util.HashSet;
import java.util.Scanner;
//443A
public class AntonAndLetters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        HashSet<Character> letters=new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                letters.add(str.charAt(i));
            }
        }
        System.out.println(letters.size());

        sc.close();
    }
}
