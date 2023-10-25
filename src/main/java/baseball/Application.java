package baseball;
import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

final class computer {
    public ArrayList<Integer> data;
    public HashMap<Integer,Boolean> hash;

    public computer(){
        ArrayList<Integer> comdata = new ArrayList<>();
        HashMap<Integer,Boolean> comhash = new HashMap<>();

        while (comdata.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comhash.containsKey(randomNumber)) {
                comdata.add(randomNumber);
                comhash.put(randomNumber, true);
            }
        }

        this.data = comdata;
        this.hash = comhash;
    }
}

public class Application {
    
    private static final String inputError = "형식에 맞지 않는 입력입니다. 프로그렘을 종료합니다.";

    public static String jud(int s, int b){ 
        String res = "";
        
        if(b+s==0) return "낫싱";
        if(b>0) res+=(String.format("%d볼",b));
        if(b > 0 && s > 0) res+=' ';
        if(s>0) res+=(String.format("%d스트라이크",s));

        return res;
    }

    public static ArrayList<Integer> chooseNumber(){
        ArrayList<Integer> user = new ArrayList<>();
        char[] s = Console.readLine().toCharArray();

        if (s.length != 3) 
            throw new IllegalArgumentException(inputError);

        for(char c :s){
            if(user.contains(c-48)) throw new IllegalArgumentException(inputError);
            user.add(c-48);
        }

        return user;
    }

    public static boolean selcetContinue(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int user = Integer.parseInt(Console.readLine());

        if (user != 1 && user != 2) throw new IllegalArgumentException(inputError);

        return user == 1;
    }
    
    public static boolean game(){
        computer com = new computer();

        while(true){            
            System.out.print("숫자를 입력해 주세요 : ");

            ArrayList<Integer> user = chooseNumber();
            int s = 0, b = 0;

            for(int i = 0; i < 3; i++){
                if (com.data.get(i) == user.get(i)) s++;
                else if (com.hash.containsKey(user.get(i))) b++;
            }

            System.out.println(jud(s,b));

            if(s==3) break;
        }

        return selcetContinue();        
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (game());
    }

}