package baseball;

public class Umpire {
    private final int[] answerNumber;
    private int strike;
    private int ball;

    public Umpire(int[] answerNumber) {
        this.answerNumber = answerNumber;
    }

    public void judge(int enterNumber[]) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < answerNumber.length; i++) {
            for (int j = 0; j < answerNumber.length; j++) {
                if (answerNumber[i] == enterNumber[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
    }

    public void speak() {
        String judgeResult = "";

        if ((ball == 0) && (strike == 0)) {
            judgeResult += "낫싱";
        }

        if (ball > 0) {
            judgeResult += ball + "볼 ";
        }

        if (strike > 0) {
            judgeResult += strike + "스트라이크";
        }

        System.out.println(judgeResult);

    }

    public int getStrike() {
        return strike;
    }

}
