package baseball;

public class GameController {
    private static final UserService userService = new UserService();
    private static final ComputerService computerService = new ComputerService();
    private static final GameViewer gameViewer = new GameViewer();
    private static Game game;

    public void startGame(){
        gameViewer.startGameMessage();

        boolean willRestart = true;
        Computer computer = computerService.createComputer();

        while (willRestart) {
            User user = userService.createUser(gameViewer.getUserGuess());
            game = new Game();

            boolean won = game.checkAndCalcUserGuess(user, computer);

            gameViewer.displayGuessResult(game.getStrike(), game.getBall());

            if (won) {
                willRestart = gameViewer.hasNewGameMessage();
                computer = computerService.createComputer();
            }
        }


    }
}
