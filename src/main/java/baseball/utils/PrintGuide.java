package baseball.utils;

import baseball.player.User;
import java.util.ArrayList;
import java.util.List;

public class PrintGuide {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";

    private final String INTRO_MSG = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_COMMAND_MSG = "숫자를 입력해주세요 : ";
    private final String OUTRO_MGS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RETRY_COMMAND_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printIntro() {
        System.out.println(INTRO_MSG);
    }

    public void printInputCommand() {
        System.out.print(INPUT_COMMAND_MSG);
    }

    public void printOutro() {
        System.out.println(OUTRO_MGS);
    }

    public void printRetryCommand() {
        System.out.println(RETRY_COMMAND_MSG);
    }

    public boolean printGameResult(User user) {
        List<String> gameResultMessage = new ArrayList<>();
        if (user.getBalls() > 0) {
            gameResultMessage.add(user.getBalls() + BALL);
        }
        if (user.getStrikes() > 0) {
            gameResultMessage.add((user.getStrikes() + STRIKE));
        }

        if (gameResultMessage.isEmpty()) {
            System.out.println(NOTHING);
        } else {
            System.out.println(String.join(" ", gameResultMessage));
        }

        if (user.getStrikes() == 3) {
            return true;
        } else {
            return false;
        }
    }
}
