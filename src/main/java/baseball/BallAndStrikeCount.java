package baseball;

import java.util.List;

public class BallAndStrikeCount {
    private int ballCount;
    private int strikeCount;

    public void compare(List<Integer> randomNumber, List<Integer> userNumber) {
        ballCount = 0;
        strikeCount = 0;
        for (int i = 0; i < 3; i++) {
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
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    public void showStatus() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("\n낫싱");
        } else if (ballCount == 0 && strikeCount != 0) {
            System.out.println("\n" + strikeCount + "스트라이크");
        } else if (ballCount != 0 && strikeCount == 0) {
            System.out.println("\n" + ballCount + "볼");
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println("\n" + ballCount + "볼" + " " + strikeCount + "스트라이크");
        }
    }
}
