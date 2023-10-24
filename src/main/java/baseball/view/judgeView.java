package baseball.view;

public class judgeView {
    static boolean temp;

    public void countResult(int[] judgement) {

        int strike = judgement[0];
        int ball = judgement[1];

        temp = false;

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            temp = true;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public boolean countThreeStrike() {
        return temp;
    }

    public void victoryScore() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
