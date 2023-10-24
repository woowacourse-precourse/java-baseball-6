package baseball.model;

import java.util.List;

public class BallCount {
    public int countStrike(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for (int idx = 0; idx < answer.size(); idx++) {
            if(answer.get(idx).equals(input.get(idx))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Integer> answer, List<Integer> input) {
        int count = 0;
        for(int idx = 0; idx < answer.size(); idx++) {
            if(!answer.get(idx).equals(input.get(idx)) && input.contains(answer.get(idx))) {
                count++;
            }
        }
        return count;
    }

}
