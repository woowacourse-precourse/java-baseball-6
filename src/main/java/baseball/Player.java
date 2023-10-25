package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> values;
    private final ExceptionHandler exceptionHandler;

    public Player() {
        this.values = new ArrayList<>();
        this.exceptionHandler = new ExceptionHandler();
    }

    // 사용자에게 값을 입력 받기
    public void chooseValues() {
        String inputValue = Console.readLine();
        exceptionHandler.handleInputException(inputValue);
        values.clear();
        char[] values = inputValue.toCharArray();
        for (char value : values) {
            this.values.add(Character.getNumericValue(value));
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    public boolean isRestart() {
        String valueRestart = Console.readLine();
        exceptionHandler.handleRestartInputException(valueRestart);
        int choice = Integer.parseInt(valueRestart);
        return choice == 1;
    }
}
