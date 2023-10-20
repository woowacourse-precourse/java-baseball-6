package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameState;
import baseball.domain.RandomBallsGenerator;
import baseball.service.Service;
import baseball.view.Command;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Game game = new Game(new RandomBallsGenerator());
    private final Service service = new Service(game);

    public void execute() {
        start();
        play();
    }

    private void start() {
        outputView.printGameStart();
        game.start();
    }

    private void play() {
        while (true) {
            outputView.printInsertNumbers();
            List<Integer> input = inputView.insertNumbers();
            Balls balls = Balls.from(input);

            String hint = game.hint(balls);
            System.out.println(hint);

            if (hint.equals("3스트라이크")) {
                game.end();
            }

            if (game.getGameState() == GameState.OFF) {
                outputView.printInsertCommand();
                Command command = inputView.insertCommand();
                if (command == Command.RESTART) {
                    game.restart();
                }
                if (command == Command.FINISH) {
                    System.out.println("게임 종료");
                    break;
                }
            }
        }
    }
}
