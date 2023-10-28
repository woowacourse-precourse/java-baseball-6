package baseball;

import User.ComputerPlayer;
import User.Player;
import camp.nextstep.edu.missionutils.Console;
import Util.MatchEvaluator;
import Util.Printer;


class BaseballGame implements IGame {
    private static final int STRIKE_COUNT_FOR_WIN = 3;
    private boolean gameEnded;
    private final Printer print = new Printer();
    private final BaseballGuide guide = new BaseballGuide();
    private final ComputerPlayer computer;
    private final MatchEvaluator evaluator;

    public BaseballGame() {
        this.computer = new ComputerPlayer();
        this.evaluator = new MatchEvaluator();
    }

    @Override
    public void startGame() {
        print.print(Printer.Message.START);
        gameEnded = false;
        while(!gameEnded){
            playOneRound();
        }
    }
    @Override
    public void endGame() {
        gameEnded = true;
    }

    @Override
    public void restartGame() {
        gameEnded = false;
        computer.resetNumbers();
    }

    private void playOneRound() {
        print.print(Printer.Message.USER_INPUT_PROMPT);
        Player userGuess = guide.getPlayerInput();
        String input = userGuess.getPlayer();
        if (handleGameControlCommands(input)) {
            return;
        }
        processUserGuess(userGuess);
    }

    private void processUserGuess(Player userGuess) {
        int[] guessArray = guide.convertGuessToIntArray(Integer.parseInt(userGuess.getPlayer()));
        int[] computerNumbers = computer.getNumbersArray();
        BallCount ballCount = evaluator.evaluate(guessArray, computerNumbers);
        guide.displayResult(ballCount, print);
        checkForGameEndingCondition(ballCount);
    }

    private boolean handleGameControlCommands(String input) {
        if (guide.isRestartCommand(input)) {
            restartGame();
            return true;
        }
        if (guide.isEndCommand(input)) {
            endGame();
            return true;
        }
        return false;
    }

    private void checkForGameEndingCondition(BallCount ballCount) {
        if (ballCount.strikes() == STRIKE_COUNT_FOR_WIN) {
            handleWinningScenario();
        }
    }
    private void handleWinningScenario() {
        print.print(Printer.Message.ALL_STRIKE);
        print.print(Printer.Message.GAME_OPTION);
        String input = Console.readLine();
        handleGameControlCommands(input);
    }
}