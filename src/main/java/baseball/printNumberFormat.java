package baseball;

public class printNumberFormat {
    public void onlyStrike(int Strike) {
        System.out.println(Strike + "스트라이크");
    }

    public void ballAndStrike(int ball, int strike) {
        System.out.println(ball + "볼" + strike + "스트라이크");
    }

    public void onlyBall(int ball) {
        System.out.println(ball + "볼");
    }

    public void nothing() {
        System.out.println("낫싱");
    }
}
