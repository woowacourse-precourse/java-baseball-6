package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private boolean isProgress = true;

    // 전체 프로세스 실행
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isProgress) {
            List<Integer> randomNumbers = RandomNumberGenerator.generate();

            String result = "";

            while (!result.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> inputNumbers = setInputNumber();
                result = compareNumbers(randomNumbers, inputNumbers);
                System.out.println(result);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

    }
}
