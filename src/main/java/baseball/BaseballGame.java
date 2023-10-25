package baseball;

import java.util.List;

public class BaseballGame implements GameBehavior {

    private int strike;
    private int ball;

    @Override
    public void ballAndStrikeCount(List<Integer> computer, String str) {
        String[] srr = str.split("");
        strike = 0;
        ball = 0;

        for (int i = 0; i < srr.length; i++) {
            int num = Integer.parseInt(srr[i]);
            int computerNum = computer.get(i);

            if (num == computerNum) {
                strike++;
            } else if (computer.contains(num)) {
                ball++;
            }
        }
    }

    @Override
    public String getResult() {
        String result = generateResultMessage();
        System.out.println(result);
        return result;
    }

    @Override
    public String generateResultMessage() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
