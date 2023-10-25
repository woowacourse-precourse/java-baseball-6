package baseball.domain;

import baseball.SYSTEM_VALUE.GameStatusValue;
import baseball.controller.BallNumberVerifier;
import baseball.controller.GameStatusVerifier;
import baseball.controller.InputVerifier;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleManager {
    private final String REQUIRE_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_TRIGGER_MESSAGE =
            GameStatusValue.GAME_FINISH + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 " + GameStatusValue.GAME_RESTART +
                    ", 종료하려면 " + GameStatusValue.GAME_EXIT + "를 입력하세요.\n";
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String DELIMITER = " ";

    public int readGameInput() {
        System.out.print(REQUIRE_INPUT_MESSAGE);
        String line = Console.readLine();

        InputVerifier ballNumberVerifier = new BallNumberVerifier();
        ballNumberVerifier.verify(line);
        return Integer.parseInt(line);
    }

    public int readGameControlInput() {
        System.out.println(RESTART_TRIGGER_MESSAGE);
        String line = Console.readLine();

        InputVerifier gameStatusVerifier = new GameStatusVerifier();
        gameStatusVerifier.verify(line);
        return Integer.parseInt(line);
    }


    public void printResult(Score userScore) {
        System.out.println(printCurrentScore(userScore));
    }

    private String printCurrentScore(Score score) {
        if (score.isNothing()) {
            return NOTHING;
        }
        return printBallCount(score.getBall()) +
                DELIMITER +
                printStrikeCount(score.getStrike());
    }

    private String printBallCount(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL;
    }

    private String printStrikeCount(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE;
    }
}
