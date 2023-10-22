package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public static void startGame() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.println(randomNumber);
            }
        }

        while (true) {

            int strikeCount = 0;
            int ballCount = 0;
            String result;

            System.out.println("숫자를 입력해 주세요: ");
            List<Integer> player = new ArrayList<>();

            // playerInput에 플레이어가 입력한 값 저장
            String playerInput = Console.readLine();
        }
    }
}
