package baseball;

import baseball.Domain.Baseball;
import baseball.Domain.BaseballScore;
import baseball.Service.GameService;
import baseball.View.GameView;

public class Application {
    public static void main(String[] args) {

        GameView gameView = new GameView();
        GameService gameService = new GameService();

        gameView.printGameStart();

        while(true) {

            Baseball base = gameService.buildRandomBaseball();

            while(true) {

                String number = gameView.getNumbers();
                Baseball now = gameService.buildBaseball(number);
                BaseballScore score = base.compare(now);
                gameView.printScore(score);

                if(score.isThreeStrike()) break;

            }

            gameView.printGameEnd();
            String line = gameView.getAnswer();
            if(line.equals("2")) break;

        }
    }
}
