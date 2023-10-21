package baseball;

import baseball.controller.GameController;
import baseball.io.Input;
import baseball.io.Output;
import baseball.model.Game;
import baseball.model.Status;
import baseball.service.BaseballService;
import baseball.service.NumberService;

public class Application {
    public static void main(String[] args) {
        Status status = new Status();
        Input input = new Input(status);
        Output output = new Output(input);
        BaseballService baseballService = new BaseballService();
        NumberService numberService = new NumberService();
        Game game = new Game(status,baseballService,numberService);

        GameController gameController = new GameController(game,input,output);
        gameController.runGame();
    }
}
