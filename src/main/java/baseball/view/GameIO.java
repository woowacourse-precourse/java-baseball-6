package baseball.view;

import java.util.Map;
import camp.nextstep.edu.missionutils.Console;
public class GameIO {
    private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private final String THREE_STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String NOTHING = "낫싱";
    private final String RESTART_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String STRIKE_PRINT_FORMAT = "%d스트라이크";
    private final String BALLS_PRINT_FORMAT = "%d볼";

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

        if (strike > 0 && balls == 0) {
            System.out.printf(STRIKE_PRINT_FORMAT + "%n", strike);
            return;
        }

        if (strike == 0 && balls > 0) {
            System.out.printf(BALLS_PRINT_FORMAT + "%n", balls);
            return;
        }

        System.out.printf(BALLS_PRINT_FORMAT + " " + STRIKE_PRINT_FORMAT + "%n", balls, strike);
    }

    public boolean askPlayerToContinue() throws IllegalArgumentException{
        System.out.println(RESTART_OPTION_MESSAGE);
        String playerDecision = Console.readLine();

        if (playerDecision.equals(PlayerResponse.CONTINUE.decision)) {
            return PlayerResponse.CONTINUE.shouldContinue;
        }
        if (playerDecision.equals(PlayerResponse.TERMINATE.decision)) {
            return PlayerResponse.TERMINATE.shouldContinue;
        }

        throw new IllegalArgumentException("유효하지 않은 입력 : 1 와 2중 하나로 입력이 필요합니다.");
    }

    public enum PlayerResponse {
        CONTINUE("1", true),
        TERMINATE("2", false);

        private final String decision;
        private final boolean shouldContinue;
        PlayerResponse(String decision, boolean shouldContinue) {
            this.decision = decision;
            this.shouldContinue = shouldContinue;
        }

    }

}
