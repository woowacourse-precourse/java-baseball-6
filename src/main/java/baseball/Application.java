package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Application {
    static List<Integer> ans = new ArrayList<>();
    public static void startGame(){
        ans.clear();
        while(ans.size()<3){ //123~987 0은 들어 가지 않도록
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(ans.contains(randomNum))
                continue;
            else
                ans.add(randomNum);
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            boolean isNumeric =  input.matches("[+-]?\\d*(\\.\\d+)?");
            if(!isNumeric) {
                throw new IllegalArgumentException("문자를 입력했습니다.");
            }
            else if(input.length() != 3) {
                throw new IllegalArgumentException("세자리 수가 아님");
            }

            List<Integer> playerNum = new ArrayList<>();

            for(String number: input.split("")){
                playerNum.add(Integer.parseInt(number));
            }
            int result = 0;
            //동일한 숫자가 있는지 확인(스트라이크 +볼 )
            for(int i = 0; i < playerNum.size(); i++) {
                if (ans.contains(playerNum.get(i))) {
                    result ++;
                }
            }
            int strike = 0;
            //스트라이크의 수 확인
            for(int i = 0; i < playerNum.size(); i++) {
                if (ans.get(i) == playerNum.get(i)) {
                    strike ++;
                }
            }
            if(result==0)
                System.out.println("낫싱");
            else if(strike==3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = Integer.parseInt(Console.readLine());
                if(restart==1) {
                    startGame();
                    continue;
                }
                else if (restart==2) {
                    break;
                }
                else {
                    throw new IllegalArgumentException("잘못된 입력입니다");
                }
                }
            else if(strike==0) {
                System.out.println(result + "볼");
            }
            else if(result-strike==0) {
                System.out.println(result + "스트라이크");
            }
            else {
                System.out.println(result - strike + "볼 " + strike + "스트라이크");
            }
        }
    }
}
