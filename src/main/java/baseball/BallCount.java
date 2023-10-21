package baseball;

public class BallCount {

    int strike = 0;
    int ball = 0;

    public void addStrikeCount() {
        strike++;
    }

    public void addBallCount() {
        ball++;
    }

    public boolean isThreeStrike() {
        boolean flag = false;
        if (strike == 3) {
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if (ball > 0) {
            sb.append(ball + "볼 ");
        } // 스트라이크가 있다면 스트라이크 추가
        if (strike > 0) {
            sb.append(strike + "스트라이크");
        } // 둘 다 0 이면 낫싱 추가
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        } // 버퍼 출력
        return sb.toString();
    }
}
