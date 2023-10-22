package baseball.io;

import baseball.constant.NumberConstant;
import baseball.io.console.ConsoleReader;
import baseball.io.console.ConsoleWriter;
import baseball.model.judge.JudgeResult;
import baseball.utils.NumberValidator;
import java.util.List;

public class PlayerIoManager {

    private ConsoleReader consoleReader;
    private ConsoleWriter consoleWriter;

    private PlayerIoManager(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public static PlayerIoManager create() {
        return new PlayerIoManager(new ConsoleReader(), new ConsoleWriter());
    }

    public void welcomePlayer() {
        consoleWriter.printGameStartText();
    }

    public List<Integer> askThreeNumbers() {
        consoleWriter.printNumberInputText();

        List<Integer> numbers = consoleReader.readThreeNumbers();
        NumberValidator.validateNumbersInRange(numbers, 1, 9);
        NumberValidator.validateNotDuplicated(numbers);

        return numbers;
    }

    public void notifyJudgeResult(JudgeResult judgeResult) {
        consoleWriter.printLine(judgeResult.toResultString());
    }

    public void congratulate() {
        consoleWriter.printCongratulationText();
    }

    public boolean isPlayerWantToReplay() {
        consoleWriter.printReplayAskText();
        return consoleReader.readOneOrTwo() == NumberConstant.ONE;
    }

}
