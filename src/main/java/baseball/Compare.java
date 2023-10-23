package baseball;

public class Compare {
    private int strike;
    private int ball;

    public Compare(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Compare compareNum(String computer, String player) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.length(); i++) {
            if (computer.charAt(i) == player.charAt(i)) {   // 위치와 숫자 다 맞으면 스트라이크
                strike++;
            } else if (computer.contains(Character.toString(player.charAt(i)))) {   // 숫자만 포함되어 있으면 볼
                ball++;
            }
        }

        return new Compare(strike, ball);
    }

    public String getResultMsg() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0 && ball > 0) {
            return ball + "볼";
        }
        return ball + "볼" + " " + strike + "스트라이크";
    }

    public boolean isEnd() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

}
