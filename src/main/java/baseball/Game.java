package baseball;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

/**
 * 전체 게임 로직을 실행 시키는 클래스 이다.
 */
public class Game {
    private NumberChecker checker;
    private final NumberGenerator generator = new NumberGenerator();
    private final Queue<Consumer<Void>> inningQueue = new ConcurrentLinkedQueue<>();

    private final int RANDOM_NUMBER_LENGTH = 3;

    public static Game newGame() {
        return new Game();
    }

    Game() {
        gameInit();
    }

    private void gameInit() {
        List<Integer> randomNumbers = generator.getUniqueRandomNumbers(RANDOM_NUMBER_LENGTH);
        checker = NumberChecker.setRandomNumbers(randomNumbers);
    }

    public void start() {
        OutputHandler.showGameStartMessage();
        makeInning();

        while(isNextInning()) {
            playNextInning();
        }
    }

    private void makeInning() {
        inningQueue.offer(_void -> startInning());
    }

    private boolean isNextInning() {
        return !inningQueue.isEmpty();
    }

    private void playNextInning() {
        inningQueue.poll().accept(null);
    }

    private void startInning() {
        OutputHandler.showGamePromptNumbersMessage();
        List<Integer> inputNumbers = InputHandler.getMultipleNumbersInput(RANDOM_NUMBER_LENGTH);

        int ballCount = checker.getBallCount(inputNumbers);
        int strikeCount = checker.getStrikeCount(inputNumbers);
        OutputHandler.showNumberCheckResultMessage(ballCount, strikeCount);

        if(isGameEnd(strikeCount)) {
            OutputHandler.showGameEndMessage();
            restartCheck();
            return;
        }

        makeInning();
    }

    private boolean isGameEnd(int strikeCount) {
        if(strikeCount == RANDOM_NUMBER_LENGTH) {
            return true;
        }

        return false;
    }

    private void restartCheck() {
        int restartFlag = 1;
        int endFlag = 2;

        OutputHandler.showRestartPrompt();
        Integer inputNumber = InputHandler.getOneNumberInput();
        if(inputNumber == restartFlag) {
            gameInit();
            makeInning();
        }

        if(inputNumber != restartFlag && inputNumber != endFlag) {
            throw new IllegalArgumentException("Illegal input number. Allowed Number is 1 or 2");
        }
    }
}
