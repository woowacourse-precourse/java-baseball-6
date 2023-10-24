package baseball.util;

import java.util.List;

public class ComputeBallCount {
    public int[] ballCount(List<Integer> computer, String answer){
        int[] count=new int[2];
        for (int i = 0; i < answer.length(); i++) {
            if (computer.contains((answer.charAt(i)) - '0')) {
                count[0]++;
            }
        }
        for (int i = 0; i < answer.length(); i++) {
            if (computer.get(i) == answer.charAt(i) - '0') {
                count[1]++;
            }
        }
        count[0] -= count[1];
        return count;
    }

}
