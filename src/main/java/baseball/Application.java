package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

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

                if(score.strike == 3) break;

            }

            gameView.printGameEnd();
            String line = gameView.getAnswer();
            if(line.equals("2")) break;

        }
    }
}
