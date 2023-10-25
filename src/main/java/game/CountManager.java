package game;

import java.util.List;

public class CountManager {
    private int ballCount;
    private int strikeCount;

    public CountManager() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void CalculateCount(String inputNumber, List<Integer> RandomAnswerGeneratedInInit) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == RandomAnswerGeneratedInInit.get(i) + '0') {
                strikeCount += 1;
                continue;
            }
            if (RandomAnswerGeneratedInInit.contains(inputNumber.charAt(i) - '0')) {
                ballCount += 1;
            }
        }
    }

    public String BallStrikeStringManager() {
        String ballstrikeString = "";
        if (ballCount == 0 && strikeCount == 0) {
            ballstrikeString = "낫싱";
            return ballstrikeString;
        }
        if (ballCount != 0) {
            ballstrikeString += ballCount + "볼 ";
        }
        if (strikeCount != 0) {
            ballstrikeString += strikeCount + "스트라이크";
        }
        return ballstrikeString;
    }

    public boolean gameRestartChecker() {
        if (strikeCount == 3) {
            return true;
        }
        ballCount = 0;
        strikeCount = 0;
        return false;
    }
}
