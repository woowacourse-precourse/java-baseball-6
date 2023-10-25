package baseball.user;

import baseball.game.GameConst;
import baseball.io.ConsoleInputReader;
import baseball.io.GameMessageOutput;
import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private final List<Integer> numbers;

    public static UserNumber of() {
        GameMessageOutput.printUserNumberInputMessage();
        String userNumber = ConsoleInputReader.read();
        return new UserNumber(userNumber);
    }

    private UserNumber(String userNumber) {
        validateUserNumber(userNumber);
        this.numbers = convertToList(userNumber);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers); // defensive copy
    }

    private void validateUserNumber(String userNumber) {
        if (userNumber.length() != GameConst.NUMBER_SIZE) {
            throw new IllegalArgumentException("3개의 숫자를 연속해서 입력하세요.");
        }

        if (!isNumber(userNumber)) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private boolean isNumber(String userNumber) {
        for (char ch : userNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> convertToList(String number) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char ch : number.toCharArray()) {
            userNumbers.add(ch - '0');
        }
        return userNumbers;
    }
}
