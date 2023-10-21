package baseball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

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

    public Map<String, Integer> checkGuess(List<Integer> computerNumbers, List<Integer> userNumbers) {
        Map<String, Integer> result = new HashMap<>();
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            } else if (userNumbers.contains(computerNumbers.get(i))) {
                ball++;
            }
        }
        result.put("스트라이크", strike);
        result.put("볼", ball);

        return result;
    }
}
