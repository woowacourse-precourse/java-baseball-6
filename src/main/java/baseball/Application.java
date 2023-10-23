package baseball;
import baseball.game.NumberBaseballGame;
import baseball.ui.GameUI;
import baseball.util.GuessValidator;

public class Application {
    public static void main(String[] args) {

        GuessValidator guessValidator = new GuessValidator();
        GameUI gameUI = new GameUI(null,guessValidator);
        NumberBaseballGame game = new NumberBaseballGame(gameUI);
        game.playGame();
    }
}
