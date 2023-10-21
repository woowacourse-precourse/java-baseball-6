package baseball.number;

import java.util.StringJoiner;

/**
 * BaseballNumber 클래스끼리의 비교 연산 결과를 위한 클래스입니다.
 * 연산 결과를 출력하거나 정답 여부를 확인할 수 있습니다.
 */
public class BaseballResult {
    public int ball = 0;
    public int strike = 0;

    /**
     * 비교 연산 결과를 볼, 스트라이크, 낫싱으로 출력합니다.
     */
    public void print() {
        StringJoiner sj = new StringJoiner(" ");
        if (ball != 0) {
            sj.add(ball + "볼");
        }
        if (strike != 0) {
            sj.add(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sj.add("낫싱");
        }
        System.out.println(sj);
    }

    /**
     * 비교 연산 결과가 3자리의 수를 모두 맞췄는지 반환합니다.
     * @return true: 모두 맞춤, false: 모두 맞추지 못함
     */
    public boolean isCorrect() {
        return strike == 3;
    }
}