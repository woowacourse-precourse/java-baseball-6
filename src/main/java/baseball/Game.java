package baseball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static final Map<GameCommand, Controller> gameCommandControllers = new HashMap<>();

    static {
        gameCommandControllers.put(GameCommand.RESTART, new RestartController());
        gameCommandControllers.put(GameCommand.EXIT, new ExitController());
    }

    private final GameStatus gameStatus;

    public Game(final GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void start() {
        Output.printIntroMessage();
        playing();
    }

    private void playing() {
        while (gameStatus.isPlaying()) {
            Result result = new Result(gameStatus.getComputerNumbers(), getUserNumbers());
            GameResult gameResult = result.getGameResult();
            Output.printHint(gameResult);
            checkThreeStrikes(gameResult);
        }
    }

    private Baseballs getUserNumbers() {
        Output.printUserNumbersMessage();
        String line = Input.readLine();
        List<Integer> numbers = stringToIntList(line);
        return new Baseballs(numbers);
    }

    private List<Integer> stringToIntList(final String str) {
        return str.chars()
            .map(Character::getNumericValue)
            .boxed()
            .toList();
    }

    private GameCommand getGameCommand() {
        Output.printRestartOrExitMessage();
        String line = Input.readLine();
        return GameCommand.from(line);
    }

    private void checkThreeStrikes(final GameResult gameResult) {
        if (gameResult.isThreeStrikes()) {
            Output.printWinningMessage();
            GameCommand gameCommand = getGameCommand();
            gameCommandControllers.get(gameCommand).service(gameStatus);
        }
    }
}
