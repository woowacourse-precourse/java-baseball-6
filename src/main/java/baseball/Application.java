package baseball;

import baseball.Domain.Baseball;
import baseball.Domain.BaseballScore;
import baseball.Service.GameService;
import baseball.View.GameView;

import java.util.List;

public class Application {

    private final GameView gameView;
    private final GameService gameService;

    public Application(GameView gameView, GameService gameService) {
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void play() {

        gameView.printGameStart();
        while(true) {
            Baseball base = gameService.buildRandomBaseball();
            cycle(base);

            gameView.printGameEnd();
            String line = gameView.getAnswer();
            if(line.equals("2")) break;
        }

    }

    private void cycle(Baseball base) {

        while(true) {
            List<Integer> number = gameView.getNumbers();
            Baseball now = gameService.buildBaseball(number);
            BaseballScore score = base.compare(now);
            gameView.printScore(score);

            if(score.isThreeStrike()) break;
        }

    }

    public static void main(String[] args) {

        Application app = new Application(new GameView(), new GameService());
        app.play();

    }

}
