package baseball;

public class Score {

    private int strike;
    private int ball;

    public Score(Num target, Num guess) {
        for (int i = 0; i < Num.DIGIT; i++) {
            if (target.getDigit(i) == guess.getDigit(i)) {
                strike++;
            } else if (target.contains(guess.getDigit(i))) {
                ball++;
            }
        }
    }

    public void printScore() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            StringBuilder sb = new StringBuilder();
            if (ball != 0) {
                sb.append(ball).append("볼 ");
            }
            if (strike != 0) {
                sb.append(strike).append("스트라이크");
            }
            System.out.println(sb);
        }
    }

    public boolean isCorrect() {
        return strike == Num.DIGIT;
    }
}
