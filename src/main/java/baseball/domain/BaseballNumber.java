package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private List<Integer> baseballNumberList;

    private BaseballNumber(List<Integer> baseballNumberList) {
        this.baseballNumberList = baseballNumberList;
    }

    public static BaseballNumber createComputerNumber() {
        List<Integer> baseballNumberList = new ArrayList<>();
        while (baseballNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumberList.contains(randomNumber)) {
                baseballNumberList.add(randomNumber);
            }
        }
        return new BaseballNumber(baseballNumberList);
    }

    public static BaseballNumber createNumberByString(String inputString) {
        validateBaseballNumbers(inputString);
        return new BaseballNumber(parseIntegerList(inputString));
    }

    private static void validateBaseballNumbers(String inputString) {
        validateInputLength(inputString);
        validateInputContentRange(inputString);
    }

    private static void validateInputLength(String inputString) {
        if (inputString == null || inputString.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 숫자만 가능합니다.");
        }
    }

    private static void validateInputContentRange(String inputString) {
        for (int i = 0; i < 3; i++) {
            char c = inputString.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("각 자리는 1~9사이의 숫자로 입력해야 합니다.");
            }
        }
    }

    private static List<Integer> parseIntegerList(String inputString) {
        List<Integer> baseballNumberList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            baseballNumberList.add(inputString.charAt(i) - '0');
        }
        return baseballNumberList;
    }

    public int get(int index) {
        return baseballNumberList.get(index);
    }
}
