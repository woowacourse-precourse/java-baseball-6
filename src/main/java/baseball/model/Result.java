package baseball.model;

import baseball.vo.Numbers;

public class Result {
    private int strike;
    private int ball;

    public Result(Numbers computer, Numbers user) {
        strike = 0;
        ball = 0;

        for (int index = 0; index < 3; index++) {
            addResult(computer.calculateByIndex(user, index));
        }
    }

    private void addResult(String result) {
        if (result.equals("스트라이크")) {
            strike += 1;
            return;
        }

        if (result.equals("볼")) {
            ball += 1;
        }
    }

    public String getResult() {
        String resultMessage = "";

        if (ball != 0) {
            resultMessage += ball + "볼 ";
        }
        if (strike != 0) {
            resultMessage += strike + "스트라이크";
        }
        if (resultMessage.equals("")) {
            return "낫싱";
        }

        return resultMessage.strip();
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }
}