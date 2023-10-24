package baseball.view;

import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
public class GameIO {

    private String THREE_STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String NOTHING = "낫싱";

    public String readPlayerGuess() {
        return Console.readLine();
    }

    public void printBallStrike(Map<String, Integer> compareResult) {
        int strike = compareResult.get("strike");
        int balls = compareResult.get("balls");

        if (strike == 3) {
            System.out.println(THREE_STRIKE);
            return;
        }

        if (strike == 0 && balls == 0) {
            System.out.println(NOTHING);
            return;
        }

        System.out.println(balls + "볼" + " " + strike + "스트라이크");


    }
}
