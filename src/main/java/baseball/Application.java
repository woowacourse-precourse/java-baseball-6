package baseball;

import baseball.game.Game;
import baseball.game.GameLogic;
import baseball.game.GameUI;
import baseball.validators.LengthValidator;
import baseball.validators.NoDuplicateValidator;
import baseball.validators.RangeValidator;
import baseball.validators.Validator;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Validator> validators = Arrays.asList(new LengthValidator(), new NoDuplicateValidator(), new RangeValidator());
        GameUI gameUI = new GameUI();
        GameLogic gameLogic = new GameLogic(validators);
        Computer computer = new Computer();
        User user = new User();

        Game game = new Game(gameUI, gameLogic, computer, user);

        game.startGame();

    }
}