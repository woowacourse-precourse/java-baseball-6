package baseball.service;

import baseball.domain.Game;
import baseball.utils.RandomUtils;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameService {
    Game game;
    RandomUtils randomUtils = new RandomUtils();
    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();

    public void setGame() {
        gameOutputView.printStartGame();
        game = new Game(randomUtils.getGameNumber());
    }

    public void playGame() {
        gameOutputView.printInputNumber();
        gameInputView.getUserInput();
    }
}