package baseball;

import java.util.ArrayList;
import java.util.List;

public class User {

    /* 입력받은 String 입력값을 Integer Array로 변경 */
    public List<Integer> changeStringToIntegerList(String userInput) {
        List<Integer> result = new ArrayList<>();
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("사용자가 입력한 숫자열의 길이가 3이 아닙니다");
        }
        for (int i = 0; i < 3; i++) {
            int numericValue = Character.getNumericValue(userInput.charAt(i));
            if (result.contains(numericValue)) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }
            result.add(numericValue);
        }
        return result;
    }
}
