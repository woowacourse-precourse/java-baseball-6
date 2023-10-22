package baseball.view;

import baseball.domain.BaseBallHint;
import baseball.domain.BaseBallNumbers;
import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SinglePlayerConsole implements Player {

    private static final String RESTART_CODE = "1";
    private static final String END_CODE = "2";

    @Override
    public void startBaseballGameMessage() {
        OutputConsole.printStartMessage();
    }

    @Override
    public BaseBallNumbers readBaseballNumbers() {
        OutputConsole.requestInputMessage();
        String stringNumbers = InputConsole.readConsole();
        try {
            final IntStream numbers = Stream.of(stringNumbers.split("")).mapToInt(Integer::parseInt);
            return BaseBallNumbers.of(numbers);
        } catch (NumberFormatException | OutOfBaseBallNumbersSize | DuplicateBaseBallNumber e) {
            throw new IllegalArgumentException(String.format("올바르지 않은 입력입니다. 서로 다른 3개의 숫자를 입력해주세요. %s", stringNumbers));
        }
    }

    @Override
    public boolean checkRestart() {
        OutputConsole.requestRestartOrEndMessage();
        String input = InputConsole.readConsole();
        return isRestart(input);
    }

    private boolean isRestart(String input) {
        return switch (input) {
            case RESTART_CODE -> true;
            case END_CODE -> false;
            default -> throw new IllegalStateException("올바르지 않은 입력입니다.");
        };
    }

    @Override
    public void printBaseBallHint(BaseBallHint baseBallHint) {
        StringBuilder stringBuilder = new StringBuilder();
        if (baseBallHint.isNothing()) {
            OutputConsole.printHint("낫싱");
            return;
        }
        if (baseBallHint.hasBall()) {
            stringBuilder.append(String.format("%d볼 ", baseBallHint.ball()));
        }
        if (baseBallHint.isNothing()) {
            stringBuilder.append(String.format("%d스트라이크", baseBallHint.strike()));
        }
        OutputConsole.printHint(stringBuilder.toString());
    }

    @Override
    public void printEndGameMessage() {
        OutputConsole.printEndMessage();
    }
}
