package baseball.controller;

import java.util.List;

public class GameResultController {

    public String calculateResult(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i<computerNumber.size(); i++) {
            if(userNumber.get(i).equals(computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
        }

        return generateResultMessage(ballCount, strikeCount);
    }

    private String generateResultMessage(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();

        if(strikeCount == 3) {
            return "3 스트라이크";
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
