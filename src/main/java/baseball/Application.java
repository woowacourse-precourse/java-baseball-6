package baseball;
import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static ArrayList<Integer> input(){
        String inputErrorCoed = "입력은 중복되지 않는 정수 3글자 입니다. 프로그렘을 종료합니다.";
        boolean dupError = false;
        ArrayList<Integer> user = new ArrayList<>();
        char[] s = Console.readLine().toCharArray();
        for(int i = 0; i < s.length; i++){
            if (user.contains(s[i]-48)) {                
                dupError = true;
                throw new IllegalArgumentException(inputErrorCoed);
            }
            user.add(s[i]-48);
        }
           
        if (user.size()!=3 || dupError) {
            throw new IllegalArgumentException(inputErrorCoed);
        }
        return user;
    }

    public static String jud(int s, int b){ 
        String res = "";
        if(b+s==0) return "낫싱";
        if(b>0) res+=(Integer.toString(b)+"볼 ");
        if(s>0) res+=(Integer.toString(s)+"스트라이크");
        return res;
    }

    public static int[] count(HashMap<Integer,Boolean> cumhash, ArrayList<Integer> cum, ArrayList<Integer> user){
        int[] res = {0,0};
        for(int i = 0; i < 3; i++){
            if (cum.get(i) == user.get(i)) {
                res[0]++;
            }
            else if (cumhash.containsKey(user.get(i))){
                res[1]++;
            }
        }
        return res;
    }

    public static int gameover(){
        String inputErrorCoed = "형식에 맞지 않는 입력입니다. 프로그렘을 종료합니다.";
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료.\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int user = Integer.parseInt(Console.readLine());
        if (user == 1) return 1;
        if (user == 2) return 2;
        throw new IllegalArgumentException(inputErrorCoed);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현        
        int game = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");    
        while (game!=2) {
            ArrayList<Integer> computer = new ArrayList<>();
            HashMap<Integer,Boolean> comhash = new HashMap<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!comhash.containsKey(randomNumber)) {
                    computer.add(randomNumber);
                    comhash.put(randomNumber, true);
                }
            }

            while(true){            
                System.out.print("숫자를 입력해 주세요 : ");
                ArrayList<Integer> user = input();
                int[] ct = count(comhash, computer, user);
                System.out.println(jud(ct[0],ct[1]));
                if(ct[0]==3) {
                    game = gameover();
                    break;
                }
            } 
        }    
    }
}
