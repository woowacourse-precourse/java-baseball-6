package baseball.domain;

import baseball.View;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> getThreeDigitNumberForUser() {
        List<Integer> userThreeDigitNumber = new ArrayList<>();
        View.printNumberInsertMessage();
        char[] numberArray = Console.readLine().toCharArray();

        for (char oneDigit : numberArray) {
            userThreeDigitNumber.add(Character.getNumericValue(oneDigit));
        }

        return userThreeDigitNumber;
    }
}
