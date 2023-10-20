package baseball;

import baseball.controller.GameController;
import baseball.model.BaseballGame;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        BaseballGame game = new BaseballGame();
        GameView view = new GameView();
        GameController controller = new GameController(game, view);
        controller.startGame();

    }
}