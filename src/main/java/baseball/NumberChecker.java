package baseball;

import java.util.List;

public class NumberChecker {
    public int[] checkNumber(List<Integer> user, List<Integer> computer){
        return countBallAndStrike(user, computer);
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
