package baseball;

public class GameController {
    public static void createGame() {

        Game game = new Game();

        String resultCode = null;

        game.startGame();

        while (true) {

            game.playGame();

            if (game.isEndGame()) {
                break;
            }

        }

        resultCode = game.restartGame();

        if (resultCode.equals("2")) {
            return;
        }

        if (resultCode.equals("1")) {
            createGame();
            return;
        }

        if (!(resultCode.equals("1") && resultCode.equals("2"))) {
            InputExceptionError.throwIllegalArgumentException();
        }
    }
}
