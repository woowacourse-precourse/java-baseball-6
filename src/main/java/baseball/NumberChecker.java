package baseball;

import java.util.List;

public class NumberChecker {
    public StringBuilder checkNumber(List<Integer> user, List<Integer> computer){
        StringBuilder checkResult = new StringBuilder();
        int[] ballAndStrikeCounts = countBallAndStrike(user, computer);
        int ballCount = ballAndStrikeCounts[0];
        int strikeCount = ballAndStrikeCounts[1];
        if (ballCount == 0 && strikeCount == 0)
            checkResult.append("낫싱");
        else if (ballCount > 0 && strikeCount > 0) {
            checkResult.append(ballCount).append("볼 ");
            checkResult.append(strikeCount).append("스트라이크");
        }
        else if (ballCount > 0) {
            checkResult.append(ballCount).append("볼");
        } else if (strikeCount > 0) {
            checkResult.append(strikeCount).append("스트라이크");
        }
        return checkResult;
    }

    public int[] countBallAndStrike(List<Integer> user, List<Integer> computer){
        int[] ballAndStrikeCounts = new int[2];
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(computer.get(i)))
                strikeCount++;
            else if (computer.contains(user.get(i)))
                ballCount++;

        }
        ballAndStrikeCounts[0] = ballCount;
        ballAndStrikeCounts[1] = strikeCount;
        return ballAndStrikeCounts;
    }

}
