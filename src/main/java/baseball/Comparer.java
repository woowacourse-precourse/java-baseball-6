package baseball;

import java.util.HashMap;
import java.util.List;

public class Comparer {

    private final List<Integer> computerNumber;
    private final List<Integer> userNumber;


    public Comparer(Computer computer, User user) {
        computerNumber = computer.getComputerNumber();
        userNumber = user.getUserNumber();
    }

    public HashMap<String, Integer> getCompareResult() {
        HashMap<String, Integer> compareResult = new HashMap<>();
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();
        printCompareResult(strikeCount, ballCount);
        compareResult.put("strikeCount", strikeCount);
        compareResult.put("ballCount", ballCount);

        return compareResult;
    }

    private void printCompareResult(int strikeCount, int ballCount) {
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        }
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
    }

    // Strike 개수 화인
    private int getStrikeCount() {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            strikeCount += isStrike(i);
        }
        return strikeCount;
    }

    // Ball 개수 확인
    private int getBallCount() {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            ballCount += isBall(i);
        }
        return ballCount;
    }

    private int isStrike(int index) {
        if (computerNumber.get(index) == userNumber.get(index)) {
            return 1;
        }
        return 0;
    }

    private int isBall(int index) {
        int findIdx = userNumber.indexOf(computerNumber.get(index));
        if (findIdx != -1 && index != findIdx) {
            return 1;
        }
        return 0;
    }
}