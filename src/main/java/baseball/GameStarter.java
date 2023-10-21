package baseball;

import baseball.handler.InputHandler;
import baseball.handler.OutputHandler;

import java.util.List;

public class GameStarter {
    private final NumberGenerator numberGenerator;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final InputResolver inputResolver;
    private final String RESTART_COMMAND = "1";
    private final int THREE_STRIKE = 3;
    private final int NO_BALL = 0;
    private List<Integer> answerNumbers;

    public GameStarter() {
        numberGenerator = new NumberGenerator();
        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        inputResolver = new InputResolver();
    }

    public void initGame() {
        outputHandler.printStartMessage();
        answerNumbers = numberGenerator.generateNumbers();
    }

    public void startGame() {
        while (true) {
            String inputNumber = inputHandler.getNumbers();
            List<Integer> playerNumbers = inputResolver.stringToIntegerList(inputNumber);

            GameResult gameResult = getGameResult(playerNumbers);

            outputHandler.printGameResult(gameResult);

            if (isGameOver(gameResult)) {
                outputHandler.printFinishMessage();
                quitOrPlay();
                return;
            }
        }
    }

    private boolean isGameOver(GameResult gameResult) {
        return gameResult.getStrikeCount() == THREE_STRIKE && gameResult.getBallCount() == NO_BALL;
    }

    private GameResult getGameResult(List<Integer> playerNumbers) {
        int strikeCount = countStrike(playerNumbers);
        int ballCount = countBall(playerNumbers);
        return new GameResult(strikeCount, ballCount);
    }

    private int countBall(List<Integer> playerNumbers) {
        int count = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (answerNumbers.contains(playerNumbers.get(i)) && playerNumbers.get(i) != answerNumbers.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int countStrike(List<Integer> playerNumbers) {
        int count = 0;
        for (int i = 0; i < answerNumbers.size(); i++) {
            if (playerNumbers.get(i) == answerNumbers.get(i)) {
                count++;
            }
        }
        return count;
    }


    private void quitOrPlay() {
        String command = inputHandler.getCommand();
        if (command.equals(RESTART_COMMAND)) {
            answerNumbers = numberGenerator.generateNumbers();
            startGame();
        }
    }


}
