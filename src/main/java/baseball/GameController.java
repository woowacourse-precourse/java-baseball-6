package baseball;

public class GameController {
    private static final UserService userService = new UserService();
    private static final ComputerService computerService = new ComputerService();
    private static final GameViewer gameViewer = new GameViewer();
    private static Game game;

    public void startGame() {
        gameViewer.startGameMessage();

        boolean willRestart = true;

        while (willRestart) {
            User user = userService.createUser(gameViewer.getUserGuess());
            Computer computer = computerService.createComputer();
            game = new Game();

            boolean won = game.checkAndCalcUserGuess(user, computer);

            if (won) {
                willRestart = gameViewer.hasNewGameMessage();
            } else {
                gameViewer.displayGuessResult(game.getStrike(), game.getBall());
            }
        }


    }
}
