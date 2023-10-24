package baseball;

import baseball.controller.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        BaseballGame baseballGame = new BaseballGame();

        do {
            baseballGame.start();
            String input = InputView.setRetryGame();
            if(input.equals("1")){
                baseballGame.restartGame();
            }
            if (input.equals("2")) {
                break; // 루프 종료
            }
        } while (true);
    }
}
