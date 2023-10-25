package baseball;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class test2 {
    public static void main(String[] args) {

        String Input = Console.readLine() ;
        String[] arr = Input.split("") ;
        ArrayList<Integer> user = new ArrayList<Integer>();
        for(int i = 0; i<=2; i++) {
        	int a = Integer.parseInt(arr[i]) ;
        	user.add(a) ;
        }
        
        String Inpu = Console.readLine() ;
        String[] ar = Inpu.split("") ;
        ArrayList<Integer> user2 = new ArrayList<Integer>();
        for(int i = 0; i<=2; i++) {
        	int a = Integer.parseInt(ar[i]) ;
        	user2.add(a) ;
        }
        
        	
        user2.get(0);
        System.out.println(user2.get(0)) ;
        System.out.println(user2) ;
     
    }
}