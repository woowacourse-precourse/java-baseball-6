package baseball.domain;

import java.util.List;

public class BallAndStrikeCount {
    private int ballCount;

    private int strikeCount;

    private static final int THREE_NUMBER = 3;

    private static final int THREE_STRIKE = 3;

    public void compare(List<Integer> randomNumber, List<Integer> userNumber) {
        ballCount = 0;
        strikeCount = 0;

        for (int i = 0; i < THREE_NUMBER; i++) {
            if (randomNumber.contains(userNumber.get(i))) {
                ballCount++;
            }
            if (randomNumber.get(i).equals(userNumber.get(i))) {
                strikeCount++;
            }
        }
        ballCount -= strikeCount;
    }

    public boolean checkStrike() {
        if (strikeCount == THREE_STRIKE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    public void showStatus() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        }
    }
}
