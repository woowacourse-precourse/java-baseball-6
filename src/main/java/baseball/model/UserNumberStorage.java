package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class UserNumberStorage {
    // 값 정의
    private List<Integer> _numbers;

    // 생성자
    public UserNumberStorage(List<Integer> numbers) {
        _numbers = numbers;
    }

    // getter
    public List<Integer> getNumbers() {
        return _numbers;
    }

    // setter
    public void setNumbers(List<Integer> numbers) {
        _numbers = numbers;
    }

    // str to list
    public static List<Integer> strToList(String str) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp_char = str.charAt(i);
            int digit = Character.getNumericValue(tmp_char);
            intList.add(digit);
        }

        return intList;
    }

}
