package baseball.game;

import baseball.game.io.ConsoleManager;
import baseball.game.io.GameMessage;
import baseball.game.model.NumbersComparator;
import baseball.game.model.RandomNumberGenerator;
import baseball.game.model.dto.GameResultDto;
import baseball.game.status.ProcessStatus;
import baseball.game.util.StringConverter;
import baseball.game.model.Numbers;

import java.util.List;

public class GameRunner {
    private final ConsoleManager consoleManager;
    private final RandomNumberGenerator randomNumberGenerator;
    private final NumbersComparator numbersComparator;
    private ProcessStatus processStatus = ProcessStatus.ONGOING;

    public GameRunner() {
        consoleManager = new ConsoleManager();
        randomNumberGenerator = new RandomNumberGenerator();
        numbersComparator = new NumbersComparator();
    }

    public void run() {
        List<Integer> randomNumbers = randomNumberGenerator.createRandomNumber();

        while (true) {
            consoleManager.printMessage(GameMessage.INPUT_MESSAGE.getMessage());

            enterBaseBallNumber(randomNumbers);

            if (processStatus.isOngoing()) {
                randomNumbers = randomNumberGenerator.createRandomNumber();
            }
            if (processStatus.isFinish()){
                break;
            }
        }
    }

    private void enterBaseBallNumber(List<Integer> randomNumbers) {
        while (true) {
            Numbers number = StringConverter.convertToNumbers(consoleManager.readNumber());
            GameResultDto gameResultDto = numbersComparator.checkNumber(number, randomNumbers);
            consoleManager.printGameResult(gameResultDto);

            if (isGameFinish(gameResultDto)) {
                printResultAndCheckRetry();
                return;
            }
        }
    }

    private void printResultAndCheckRetry() {
        consoleManager.printLineMessage(GameMessage.GAME_FINISH_MESSAGE.getMessage());
        consoleManager.printLineMessage(GameMessage.GAME_RETRY_MESSAGE.getMessage());

        int menu = consoleManager.readRetryMenu();
        if (menu == 2) {
            processStatus = ProcessStatus.FINISH;
        }

    }

    private boolean isGameFinish(GameResultDto resultDto) {
        return resultDto.getStrike() == 3;
    }
}
