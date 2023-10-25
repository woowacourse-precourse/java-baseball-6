package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberArray {

    private final List<Integer> numList = new ArrayList<>();

    public List<Integer> getNumList() {
        return Collections.unmodifiableList(numList);
    }
 
    // used to create 3 different numbers
    public NumberArray() {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }

    //used to store user input numbers
    public NumberArray(String num) {
        int length = num.length();
        validateNumberLength(length);
        for (int i = 0; i < length; i++) {
            char character = num.charAt(i);
            validateOnlyNumber(character);
            numList.add(validateDifferentThreeNumbers(character));
        }
    }

    void validateNumberLength(int length) {
        if (length != 3) {
            throw new IllegalArgumentException("3개의 값만 입력하세요.");
        }
    }

    void validateOnlyNumber(char character) {
        if (((int) character > 57) || ((int) character < 48)) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다");
        }
    }

    int validateDifferentThreeNumbers(char character) {
        int intValue = Character.getNumericValue(character);

        if (numList.contains(intValue)) {
            throw new IllegalArgumentException("서로다른 숫자 3개를 입력하셔야 합니다.");
        }
        return intValue;
    }
}
