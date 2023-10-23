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

        if(strikeCount == 3) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }

        if(strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        return ballCount + "볼 " + strikeCount + "스트라이크";
    }
}
