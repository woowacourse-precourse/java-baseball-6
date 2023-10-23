package baseball;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BaseballGame {
    private final BaseballNumber numbers;

    public BaseballGame(int[] numbers) {
        this.numbers = new BaseballNumber(numbers);
    }

    public void sayHello(ConsoleLogger consoleLogger) {
        consoleLogger.print("숫자 야구 게임을 시작합니다.\n");
    }

    public void run(ConsoleInput consoleInput, ConsoleLogger consoleLogger) {
        while (true) {
            consoleLogger.print("숫자를 입력해주세요 :");
            String input = consoleInput.getInput();
            checkInputs(input);
        }
    }

    private static void checkInputs(String s) {
        if (Pattern.matches("[0-9]{3}", s)) {
            return;
        }
        throw new IllegalArgumentException();
    }

}

