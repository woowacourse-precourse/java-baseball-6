package baseball.domain;

import baseball.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int MAX_NUMBER_SIZE = 3;
    private static final int PLAY_AGAIN = 1;
    private static final int EXIT = 2;

    public List<Integer> getThreeDigitNumberForUser() {
        List<Integer> userThreeDigitNumber = new ArrayList<>();
        View.printNumberInsertMessage();
        char[] numberArray = Console.readLine().toCharArray();
        validateUserNumber(numberArray);

        for (char oneDigit : numberArray) {
            userThreeDigitNumber.add(Character.getNumericValue(oneDigit));
        }

        return userThreeDigitNumber;
    }

    public int getNumberForPlayAgain() {
        int number = Integer.parseInt(Console.readLine());
        validateNumberForPlayAgain(number);
        return number;
    }

    private void validateUserNumber(char[] numberArray) {
        if (numberArray.length != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }

    private void validateNumberForPlayAgain(int number) {
        if (!(number == PLAY_AGAIN || number == EXIT)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}
