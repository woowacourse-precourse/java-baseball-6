package baseball;

public class GameController {
    public static void createGame() {

        Game game = new Game();

        game.startGame();

        while (true) {

            game.playGame();

            if (game.playGame() == 3) {
                game.endGame();
                break;
            }
        }
    }
}
