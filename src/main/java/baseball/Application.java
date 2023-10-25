package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * 랜덤한 3자리 숫자를 생성하는 함수
     */
    List<Integer> comRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

  
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");
        Application game = new Application();
        List<Integer> randomNumber = game.comRandomNumber();
        //System.out.println(randomNumber);
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        System.out.println(inputNum);

    }
}