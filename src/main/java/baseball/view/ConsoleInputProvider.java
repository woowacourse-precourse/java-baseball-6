package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider<String> {
    @Override
    public String readNonNullInput() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력값을 제공해야 합니다.");
        }
        return input;
    }
}
