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
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            strike += countStrike(i);
            ball += countBall(i);
        }
        return getGameResult(strike, ball - strike);
    }

    private int countStrike(int index) {
        if (computer.getDigit(index) == user.getDigit(index)) {
            return 1;
        }
        return 0;
    }

    private int countBall(int index) {
        if (computer.hasNumber(user.getDigit(index))) {
            return 1;
        }
        return 0;
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
