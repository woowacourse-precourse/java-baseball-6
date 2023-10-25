package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> inputNumber;
    private final String USER_NUM_REG_EX = "([1-9])(?!\\1)([1-9])(?!\\1|\\2)([1-9])";

    public User() {
        this.inputNumber = setUserNumberFromConsole();
    }

    public List<Integer> getInputNumber() {
        return inputNumber;
    }

    private List<Integer> setUserNumberFromConsole() {
        String st = Console.readLine();
        throwException(st);
        String[] arr = st.split("");

        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            input.add(Integer.parseInt(arr[i]));
        }
        return input;
    }

    private void throwException(String st) {
        if (!st.matches(USER_NUM_REG_EX)) {
            throw new IllegalArgumentException();
        }
    }

}
