package baseball;

import baseball.Domain.Baseball;
import baseball.Domain.BaseballScore;
import baseball.Service.GameService;
import baseball.View.GameView;
import baseball.View.OutputView;
import baseball.dto.ExitCode;
import baseball.utils.InputConverter;

import java.util.List;

public class Application {

    private final GameView gameView;
    private final GameService gameService;

    public Application(GameView gameView, GameService gameService) {
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void play() {

        gameView.printStart();
        while (true) {
            Baseball base = gameService.buildRandomBaseball();
            loopTurn(base);
            gameView.printEnd();

            String line = gameView.getAnswer();
            ExitCode exitCode = InputConverter.convertToExitCode(line);
            if (exitCode.isExit()) break;
        }

    }

    private void loopTurn(Baseball base) {

        while (true) {
            String line = gameView.getNumbers();
            List<Integer> numbers = InputConverter.convertToIntegerList(line);
            Baseball now = gameService.buildBaseball(numbers);

            BaseballScore score = base.compare(now);
            gameView.printScore(score);

            if (score.isThreeStrike()) break;
        }

    }

    public static void main(String[] args) {

        GameView gameView = new GameView(new OutputView());
        GameService gameService = new GameService();
        Application app = new Application(gameView, gameService);

        app.play();

    }

}
