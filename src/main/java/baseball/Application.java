package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            BaseballNumber computer = new BaseballNumber();
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                BaseballNumber input = new BaseballNumber(Console.readLine());
                BaseballResult result = computer.compareTo(input);
                result.print();
                if (result.isCorrect()) break;
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartCode = Console.readLine();
            if (Objects.equals(restartCode, "1")) continue;
            if (Objects.equals(restartCode, "2")) break;
            throw new IllegalArgumentException();
        }
        Console.close();
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

    public boolean isCorrect() {
        return strike == 3;
    }
}