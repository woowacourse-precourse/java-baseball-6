package baseball;

public class BaseBall {
    private String number;
    private static final int BASE = 3;

    public BaseBall(final String number) {
        if (number.length() != BASE) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    // 입력한 수에 볼이 몇 개 있는지 계산한다.
    public int countBalls(final BaseBall inputBaseBall) {
        int balls = 0;
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < BASE; j++) {
                // 같은 수가 다른 자리에 있으면 볼
                if (i != j && this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
                    balls += 1;
                }
            }
        }
        return balls;
    }

    // 입력한 수에 스트라이크가 몇 개 있는지 계산한다.
    public int countStrikes(final BaseBall inputBaseBall) {
        int strikes = 0;
        for (int i = 0; i < BASE; i++) {
            // 같은 수가 같은 자리에 있으면 스트라이크
            if (this.number.charAt(i) == inputBaseBall.number.charAt(i)) {
                strikes += 1;
            }
        }
        return strikes;
    }

    // 입력한 수가 낫싱인지 판단한다.
    public boolean isNothing(final BaseBall inputBaseBall) {
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < BASE; j++) {
                // 같은 수가 하나라도 있는 경우 낫싱이 아니다.
                if (this.number.charAt(i) == inputBaseBall.number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
