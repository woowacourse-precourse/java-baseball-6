package baseball.view;

import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
public class GameIO {
    private String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private String THREE_STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private String NOTHING = "낫싱";
    private String RESTART_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }
    public String readPlayerGuess() {
        System.out.print(NUMBER_INPUT_REQUEST_MESSAGE);
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

    public boolean askPlayerToContinue() {
        System.out.println(RESTART_OPTION_MESSAGE);
        String playerDecision = Console.readLine();

        if (playerDecision.equals("1")) {
            return true;
        }
        if (playerDecision.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
