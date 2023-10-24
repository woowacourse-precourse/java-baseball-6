package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameResult;
import baseball.view.View;
import java.util.HashSet;
import java.util.Set;

public class BaseballController {

    private final BaseballGame baseballGame;

    private final String START_GAME = "숫자 야구 게임을 시작합니다.\n";
    private final String REQUIRE_NUMBER = "숫자를 입력해주세요 : ";
    private final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private final String ASK_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public BaseballController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void startGame() {
        baseballGame.init();

        View.printText(START_GAME);
        BaseballGameResult result;

        do {
            View.printText(REQUIRE_NUMBER);
            String input = View.readLine();
            checkValidation(input);
            result = baseballGame.play(input);
            View.printText(result.toString());
        } while (!result.isEnded());

        View.printText(END_GAME);
        View.printText(ASK_RESTART_GAME);
        String restartFlag = View.readLine();

        if ("1".equals(restartFlag)) {
            startGame();
        }
    }

    private void checkValidation(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        Set<Character> set = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException();
            }

            if (set.contains(c)) {
                throw new IllegalArgumentException();
            }

            set.add(c);
        }
    }
}
