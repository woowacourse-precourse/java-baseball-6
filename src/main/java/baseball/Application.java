package baseball;
import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

final class computer {
    public ArrayList<Integer> data;
    public HashMap<Integer,Boolean> hash;
    public computer(ArrayList<Integer> data, HashMap<Integer,Boolean> hash){
        this.data = data;
        this.hash = hash;
    }
}

public class Application {
    
    private static final String inputError = "형식에 맞지 않는 입력입니다. 프로그렘을 종료합니다.";

    public static String jud(int s, int b){ 
        String res = "";

        if(b+s==0) return "낫싱";
        if(b>0) res+=(Integer.toString(b)+"볼 ");
        if(s>0) res+=(Integer.toString(s)+"스트라이크");

        return res;
    }

    public static computer setcom(){
        ArrayList<Integer> comdata = new ArrayList<>();
        HashMap<Integer,Boolean> comhash = new HashMap<>();

        while (comdata.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comhash.containsKey(randomNumber)) {
                comdata.add(randomNumber);
                comhash.put(randomNumber, true);
            }
        }

        return new computer(comdata, comhash);
    }

    public static ArrayList<Integer> chooseNumber(){
        boolean dupError = false;
        ArrayList<Integer> user = new ArrayList<>();
        char[] s = Console.readLine().toCharArray();

        for(int i = 0; i < s.length; i++){
            if (user.contains(s[i]-48)) {
                dupError = true;
                break;
            }
            user.add(s[i]-48);
        }
        
        if (user.size()!=3 || dupError) 
            throw new IllegalArgumentException(inputError);

        return user;
    }
    
    public static int game(computer com){
        while(true){            
            System.out.print("숫자를 입력해 주세요 : ");

            ArrayList<Integer> user = chooseNumber();
            int s = 0, b = 0;

            for(int i = 0; i < 3; i++){
                if (com.data.get(i) == user.get(i)) s++;
                else if (com.hash.containsKey(user.get(i))) b++;
            }

            System.out.println(jud(s,b));

            if(s==3) return gameover();
        }
    }

    public static int gameover(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int user = Integer.parseInt(Console.readLine());

        if (user != 1 || user != 2) throw new IllegalArgumentException(inputError);

        return user;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (game(setcom())!=2);
    }

}