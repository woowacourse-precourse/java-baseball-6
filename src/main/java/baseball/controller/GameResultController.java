package baseball.controller;

import java.util.List;

public class GameResultController {

    public String calculateResult(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = calculateStrikes(computerNumber, userNumber);
        int ballCount = calculateBalls(computerNumber, userNumber);


        return generateResultMessage(ballCount, strikeCount);
    }

    private int calculateStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;

        for(int i=0; i<computerNumber.size(); i++) {
            if(userNumber.get(i).equals(computerNumber.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int calculateBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int ballCount = 0;

        for(int i=0; i<userNumber.size(); i++) {
            if(computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private String generateResultMessage(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();

        if(strikeCount == 3) {
            return "3스트라이크";
        }

        if(ballCount > 0) {
            result.append(ballCount).append("볼");
        }

        if(ballCount > 0 && strikeCount > 0) {
            result.append(" ");
        }

        if(strikeCount > 0) {
            result.append(strikeCount).append("스트라이크");
        }

        if(ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        return result.toString();
    }
}
