package baseball.controller;

import baseball.model.Command;
import baseball.model.Game;
import baseball.view.GameView;

public class GameController {
    private final GameView view = new GameView();

    public void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        while (true) {
            String inputNumber = view.inputUserNumber();
            String hint = game.playGame(inputNumber);
            String command = view.printGameResult(hint);
            if (command.equals(Command.RESTART.getValue())) {
                game = new Game();
            }
            if (command.equals(Command.FINISH.getValue())) {
                return;
            }
        }
    }
}
