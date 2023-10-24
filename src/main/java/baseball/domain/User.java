package baseball.domain;

import baseball.util.exception.duplicateNumberException;
import baseball.util.exception.inputOutOfRangeException;
import baseball.util.exception.invaildInputLengthException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {

    public int[] parseUserNum(String userNum, int size) {
        checkException(userNum, size);

        int[] user = new int[size];

        for (int i = 0; i < size; i++) {
            user[i] = getNumbericValue(userNum.charAt(i));
        }

        return user;
    }

    private int getNumbericValue(char ch) {
        if (ch >= '1' && ch <= '9') {
            return Character.getNumericValue(ch);
        }
        throw new inputOutOfRangeException();
    }

    private void checkException(String userNum, int size) {
        checkUserNumSize(userNum, size);
        checkDuplicateNum(userNum, size);
    }

    private void checkUserNumSize(String userNum, int size) {
        if (userNum.length() != size || userNum.isBlank()) {
            throw new invaildInputLengthException();
        }
    }

    private void checkDuplicateNum(String userNum, int size) {
        Set<String> userSet = new HashSet<>(Arrays.asList(userNum.split("")));
        if (userSet.size() != size) {
            throw new duplicateNumberException();
        }
    }
}
