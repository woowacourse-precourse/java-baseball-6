package baseball.entity;

public class Hint {
    private Integer strike;
    private Integer ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    // strike와 ball 값에 따라 힌트를 생성한다.
    public void generateHint(String randomNumber, String inputNumber) {
        init();
        countStrike(randomNumber, inputNumber);
        countBall(randomNumber, inputNumber);

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱"); return;
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크"); return;
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼"); return;
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크"); return;
        }

    }

    private void init() {
        this.strike = 0;
        this.ball = 0;
    }

    // 랜덤값과 사용자 입력을 비교해 strike 갯수를 계산한다.
    private void countStrike(String randomNumber, String inputNumber) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
                strike++;
            }
        }
    }

    // 랜덤값과 사용자 입력을 비교해 ball 갯수를 계산한다.
    private void countBall(String randomNumber, String inputNumber) {
        for(int i = 0; i < 3; i++) {
            char targetNumber = inputNumber.charAt(i);
            if (randomNumber.indexOf(targetNumber) != -1
                    && randomNumber.charAt(i) != targetNumber) {
                ball++;
            }
        }
    }
}
