package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        boolean gameChoice = true;
        List<Integer> computerNum = new ArrayList<>();
        String gameString = "";
        // 컴퓨터 숫자를 생성함. 차후 메소드로 분리
        while (computerNum.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(num)) {
                computerNum.add(num);
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(gameChoice){
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            gameString = check(userInput,computerNum);

            System.out.println(gameString); // 진행상황 표시

            if(gameString.equals("3스트라이크")){
                //이후 게임이 다시 시작할 것 인지 말것인지 구현
            }
        }

    }
    static String check(String userInput, List<Integer> ComputerNum){
        // Switch case 로 상황에 따른 String 출력하기
        return null;
    }
}
