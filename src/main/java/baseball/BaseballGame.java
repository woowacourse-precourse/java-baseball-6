package baseball;

public class BaseballGame {

    private final Input input;
    private final Output output;
    private GameStatus gameStatus;

    public BaseballGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void playBaseball() {
        try {
            gameStart();
        } catch (IllegalArgumentException exception) {
            handleException(exception);
        }
    }

    private void gameStart() {
        gameStatus = GameStatus.GAME_START;
        output.gameStart();
        while (!GameStatus.isGameEnd(gameStatus)) {
            playUntilInningEnd();
            output.inputGameCommand();
            GameCommand gameCommand = input.readGameCommand();
            gameStatus = GameStatus.fromGameCommand(gameCommand);
        }
        output.gameEnd();
    }

    private void playUntilInningEnd() {
        Computer computer = Computer.getInstanceByRandomNumbers();
        while (!GameStatus.isInningEnd(gameStatus)) {
            output.inputPlayerNumber();
            Player player = Player.getInstanceByNumber(input.readPlayerNumber());
            Referee referee = Referee.getInstance(computer, player);
            Result result = referee.judge();
            output.printResult(result);
            gameStatus = GameStatus.fromResult(result);
        }
        output.inningEnd();
    }

    private void handleException(IllegalArgumentException exception) {
        output.printExceptionMessage(exception);
        throw exception;
    }

}
