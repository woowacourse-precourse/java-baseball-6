package baseball.model;

import static baseball.util.ValidationChecking.checkUserInputValidate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber(String inputNumber) {
        this.userNumber = changeStringtoList(inputNumber);
        checkUserInputValidate(this.userNumber);
    }

    public List<Integer> getInputNumber() {
        return Collections.unmodifiableList(this.userNumber);
    }

    public static List<Integer> changeStringtoList(String string) {
        return getIntegers(string);
    }

    public static List<Integer> getIntegers(String string) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            int currentInteger = (int) (string.charAt(i)) - '0';
            list.add(currentInteger);
        }

        return list;
    }
}
