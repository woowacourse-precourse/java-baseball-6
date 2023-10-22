package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameResult;
import baseball.view.View;

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
}
