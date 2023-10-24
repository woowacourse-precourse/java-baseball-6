package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        int roundResult;
        boolean running = true;

        game.startGame();

        while (running) {

            game.getGuessNums();
            roundResult = game.getHint();

            if (roundResult == 2) {
                running = game.isRestart();
                if (running) {
                    game.startGame();
                } else {
                    game.endGame();
                }
            }
        }
    }
}
