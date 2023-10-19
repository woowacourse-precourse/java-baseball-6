package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // for test
        BaseballNumber input = new BaseballNumber(Console.readLine());
        System.out.println(Arrays.toString(input.values));
    }
}

class BaseballNumber {
    int[] values = {1, 1, 1};

    private boolean validateInput(String input) {
        if (input.length() != 3) return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(input.charAt(i))) return false;
            int value = Character.getNumericValue(input.charAt(i));
            if (set.contains(value)) return false;
            set.add(value);
        }
        return true;
    }

    public BaseballNumber(String input) {
        // 사용자의 잘못된 입력을 확인해야 함
        // 1. input.length()가 정확히 3인지
        // 2. 각 자릿수가 1 ~ 9의 수인지
        // 3. 각 자리의 숫자가 서로 다른 수인지
        if (!validateInput(input)) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            this.values[i] = Character.getNumericValue(input.charAt(i));
        }
    }

    public BaseballNumber() {
        List<Integer> randomValues = new ArrayList<>();
        while (randomValues.size() < 3) {
            int randomValue = Randoms.pickNumberInRange(1, 9);
            if (!randomValues.contains(randomValue)) randomValues.add(randomValue);
        }
        for (int i = 0; i < 3; i++) {
            this.values[i] = randomValues.get(i);
        }
    }

    public BaseballResult compareTo(BaseballNumber target) {
        BaseballResult result = new BaseballResult();
        for (int i = 0; i < 3; i++) {
            if (this.values[i] == target.values[i]) {
                result.strike++; // +1 strike
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (this.values[i] == target.values[j]) result.ball++; // +1 ball
            }
        }
        return result;
    }
}

class BaseballResult {
    public int ball = 0;
    public int strike = 0;

    public void print() {
        StringJoiner sj = new StringJoiner(" ");
        if (ball != 0) sj.add(ball + "볼");
        if (strike != 0) sj.add(strike + "스트라이크");
        if (ball == 0 && strike == 0) sj.add("낫싱");
        System.out.println(sj);
    }
}