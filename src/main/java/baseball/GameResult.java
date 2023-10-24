package baseball;

public class GameResult {
    private int strike;
    private int ball;

    public void checkBallIndex(int destIndex, int targetIndex) {
        if (destIndex == targetIndex) {
            strike++;
            return;
        }
        if (targetIndex >= 0) {
            ball++;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike + ball == 0) {
            return "낫싱";
        }

        String result = "";
        if (ball > 0) {
            result = ball + "볼 ";
        }
        if (strike > 0) {
            result += strike + "스트라이크";
        }

        return result.trim();
    }
}
