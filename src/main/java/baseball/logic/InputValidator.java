package baseball.logic;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public void validateLength(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이를 확인하세요.");
        }
    }

    public List<Integer> convertStrToList(String inputNumbers) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numberList.add((int) inputNumbers.charAt(i));
        }
        return numberList;
    }
    
}
