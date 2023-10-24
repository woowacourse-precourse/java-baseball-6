package baseball.model;

public class Game {
    private final User user;
    private final Computer computer;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
    }

    public String playGame(String numberString) {
        user.inputNumber(numberString);
        int strike = countStrike();
        int ball = countBall() - strike;
        return getGameResult(strike, ball);
    }

    private int countBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.hasNumber(user.getDigit(i))) {
                ball++;
            }
        }
        return ball;
    }

    private int countStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.getDigit(i) == user.getDigit(i)) {
                strike++;
            }
        }
        return strike;
    }

    public String getGameResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (strike != 0) {
            return strike + "스트라이크";
        }
        if (ball != 0) {
            return ball + "볼";
        }
        return "낫싱";
    }
}
