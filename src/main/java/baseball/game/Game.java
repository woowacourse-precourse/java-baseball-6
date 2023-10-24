package baseball.game;

import baseball.ball.Balls;
import baseball.ball.BaseBallStatus;
import baseball.util.Input;
import baseball.util.Output;
import baseball.util.RandomUniqueNumber;

import java.util.List;

public class Game {
    public static final String PLAY_COMMAND = "1";
    private final Input input;
    private final Output output;

    private GameStatus gameStatus;
    private BaseBallStatus baseBallStatus;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
        this.gameStatus = GameStatus.PLAYING;
        this.baseBallStatus = BaseBallStatus.GUESSING;
    }

    public void run() {
        while (gameStatus.isPlaying()) {
            List<Integer> randomUniqueNumbers = RandomUniqueNumber.getRandomUniqueNumbers(3);
            String commandAfterGame = playBaseBallGame(randomUniqueNumbers);
            gameStatus = determineGameStatusAfterGame(commandAfterGame);
            baseBallStatus = makeNewBaseBallGame();
        }
    }

    private GameStatus determineGameStatusAfterGame(String commandAfterGame) {
        if (commandAfterGame.equals(PLAY_COMMAND)) {
            return GameStatus.PLAYING;
        }
        return GameStatus.EXIT;
    }

    private BaseBallStatus makeNewBaseBallGame() {
        return BaseBallStatus.GUESSING;
    }

    public String playBaseBallGame(List<Integer> numbers) {
        Balls answerBalls = makeAnswer(numbers);

        while (baseBallStatus.isGuessing()) {
            Balls userBalls = makeUserBalls();
            checkAnswer(answerBalls, userBalls);
        }

        return getUserCommand();
    }

    private Balls makeAnswer(List<Integer> numbers) {
        output.printStartGame();
        return new Balls(numbers);
    }

    private Balls makeUserBalls() {
        output.printWaitUserInput();
        List<Integer> userNumbers = input.getUserNumbers();
        Balls userBalls = new Balls(userNumbers);
        return userBalls;
    }

    private void checkAnswer(Balls answerBalls, Balls userBalls) {
        GameResult gameResult = answerBalls.compareWithBalls(userBalls);
        output.printUserScore(gameResult);
        baseBallStatus = gameResult.isWinCondition();
    }

    private String getUserCommand() {
        output.printGameWin();
        return input.getCommandAfterGameWin();
    }
}
