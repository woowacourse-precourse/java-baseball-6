package baseball;

import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {
        // for test
        BaseballNumber t1 = new BaseballNumber("123");
        BaseballNumber t2 = new BaseballNumber("253");
        BaseballNumber t3 = new BaseballNumber("789");
        BaseballNumber t4 = new BaseballNumber("789");

        t1.compareTo(t2).print();
        t2.compareTo(t3).print();
        t3.compareTo(t4).print();
    }
}

class BaseballNumber {
    int[] values = {1, 1, 1};

    public BaseballNumber(String input) {
        // 사용자의 잘못된 입력을 확인해야 함 (나중에 구현)
        // 1. input.length()가 정확히 3인지
        // 2. 각 자릿수가 1 ~ 9의 수인지
        // 3. 각 자리의 숫자가 서로 다른 수인지
        for (int i = 0; i < 3; i++) {
            this.values[i] = input.charAt(i);
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