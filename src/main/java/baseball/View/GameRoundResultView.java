package baseball.View;

public class GameRoundResultView {
    public void printResult(int[] ballCount) {
        StringBuilder sb = new StringBuilder();
        int ball = ballCount[0];
        int strike = ballCount[1];

        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }

        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}
