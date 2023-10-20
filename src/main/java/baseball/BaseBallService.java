package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallService {
    final int BASE = 3;

    // 입력한 수가 3자리인지 판단한다.
    public boolean isValidInput(String in) {
        return in.length() == 3;
    }

    // StringBuilder sb가 정수 n을 포함하는지 판단한다.
    private boolean contains(StringBuilder sb, int n) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == Character.forDigit(n, 10)) {
                return true;
            }
        }
        return false;
    }

    // 서로 다른 3자리의 난수를 생성한다.
    public String generateAnswer() {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!contains(sb, randomNumber)) {
                sb.append(randomNumber);
            }
        }
        return sb.toString();
    }

    // 입력한 수에 볼이 몇 개 있는지 계산한다.
    public int countBalls(String in, String answer) {
        int balls = 0;
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < BASE; j++) {
                // 같은 수가 다른 자리에 있으면 볼
                if (i != j && in.charAt(i) == answer.charAt(j)) {
                    balls += 1;
                }
            }
        }
        return balls;
    }

    // 입력한 수에 스트라이크가 몇 개 있는지 계산한다.
    public int countStrikes(String in, String answer) {
        int strikes = 0;
        for (int i = 0; i < BASE; i++) {
            // 같은 수가 같은 자리에 있으면 스트라이크
            if (in.charAt(i) == answer.charAt(i)) {
                strikes += 1;
            }
        }
        return strikes;
    }

    // 입력한 수가 낫싱인지 판단한다.
    public boolean isNothing(String in, String answer) {
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < BASE; j++) {
                // 같은 수가 하나라도 있는 경우 낫싱이 아니다.
                if (in.charAt(i) == answer.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
