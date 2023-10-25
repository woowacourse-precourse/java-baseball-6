package baseball;

import baseball.controller.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 야구 게임 구현
        BaseballGame baseballGame = new BaseballGame();

        do {
            //게임 시작
            baseballGame.start();

            //재시작 확인
            String input = InputView.setRetryGame();
            if(input.equals("1")){
                baseballGame.restartGame();
            }
            if (input.equals("2")) {
                break;
            }
        } while (true);
    }
}
