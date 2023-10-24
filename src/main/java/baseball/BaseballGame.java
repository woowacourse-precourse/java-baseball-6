package baseball;

public class BaseballGame {

    private final Input input;
    private final Output output;

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
        output.gameStart();
        while (true) {
            playUntilThreeStrikes();
            output.inputGameCommand();
            GameCommand gameCommand = input.readGameCommand();
            if (!gameCommand.isContinue()) {
                break;
            }
        }
        output.gameEnd();
    }

    private void playUntilThreeStrikes() {
        Computer computer = Computer.getInstanceByRandomNumbers();
        while (true) {
            output.inputPlayerNumber();
            Player player = Player.getInstanceByNumber(input.readPlayerNumber());
            Referee referee = Referee.getInstance(computer, player);
            Result result = referee.judge();
            output.printResult(result);
            if (result.isThreeStrikes()) {
                output.inningEnd();
                break;
            }
        }
    }

    private void handleException(IllegalArgumentException exception) {
        output.printExceptionMessage(exception);
        throw exception;
    }

}
