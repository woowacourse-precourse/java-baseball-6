package baseball.service;

import baseball.domain.Game;
import baseball.domain.User;
import baseball.utils.Parser;
import baseball.utils.RandomUtils;
import baseball.view.GameInputView;
import baseball.view.GameOutputView;

public class GameService {
    Game game;
    User user = new User();
    Parser parser = new Parser();
    RandomUtils randomUtils = new RandomUtils();
    GameInputView gameInputView = new GameInputView();
    GameOutputView gameOutputView = new GameOutputView();

    public void setGame() {
        gameOutputView.printStartGame();
        game = new Game(randomUtils.getGameNumber());
    }

    public void playGame() {
        gameOutputView.printInputNumber();
        user.setUserNumber(parser.parseUserInput(gameInputView.getUserInput()));
    }
}