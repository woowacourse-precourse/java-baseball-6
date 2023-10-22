package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_OVER_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        System.out.printf(GAME_START_MSG);
        boolean isGaming = true;
        while (isGaming) {
            List<Integer> answer = new ArrayList<>();
            while (answer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!answer.contains(randomNumber)) {
                    answer.add(randomNumber);
                }
            }
            NumberBaseballGame game = new NumberBaseballGame(answer);
            game.PlayBall();

            System.out.printf(GAME_OVER_MSG);
            String userChoice = camp.nextstep.edu.missionutils.Console.readLine();

            if (userChoice.equals("2")) {
                isGaming = false;
            } else if (!userChoice.equals("1")) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }
}
