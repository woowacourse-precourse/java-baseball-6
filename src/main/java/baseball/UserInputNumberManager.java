package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

import static baseball.enum_class.Message.INPUT_USERNUMBER_MESSAGE;
import static baseball.enum_class.NumberInfo.COUNT;

public class UserInputNumberManager implements UserNumberManager{
    private String userNumber;

    public String getUserNumber() {
        System.out.print(INPUT_USERNUMBER_MESSAGE.getMessage());
        userNumber = Console.readLine();

        validInteger(userNumber);
        validDuplication(userNumber);
        validThreeDigit(userNumber);
        validZeroValue(userNumber);

        return userNumber;
    }

    public void validInteger(String Number) {
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validDuplication(String Number) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            set.add(Number.charAt(i));
        }
        if (!(set.size() == COUNT.getNumberInfo())) {
            throw new IllegalArgumentException();
        }
    }

    public void validThreeDigit(String Number) {
        if (Number.length() != COUNT.getNumberInfo()) {
            throw new IllegalArgumentException();
        }
    }

    public void validZeroValue(String Number) {
        for (int i = 0; i < Number.length(); i++) {
            if (Number.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
        }
    }
}