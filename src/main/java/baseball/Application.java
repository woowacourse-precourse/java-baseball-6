package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
public class Application {

    private final static int GAME_RESTART = 1;
    private final static int GAME_EXIT = 2;
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

//        System.out.println(computer);  // 3자리 숫자 정상 생성 확인


    }

//    private static List<Integer> generateComputerNumbers(int randomNumber) {
//
//    }
}
