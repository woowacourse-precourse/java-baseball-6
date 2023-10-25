package baseball;

import java.util.List;

public class StrikeAndBall {
    public int strikeCount(List<Integer> computerList, List<Integer> userList) {

        int strikeCounts = 0;

        for (int i = 0; i < 3; i++) {
            if (computerList.get(i).equals(userList.get(i)))
                strikeCounts++;
        }
        return strikeCounts;
    }

    public int correctBallCount(List<Integer> computerList, List<Integer> userList) {

        int correctBallCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computerList.contains(userList.get(i))) {
                correctBallCount++;
            }
        }
        return correctBallCount;
    }

}

