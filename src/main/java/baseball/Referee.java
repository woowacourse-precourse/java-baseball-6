package baseball;

import java.util.List;

public class Referee {
    public static int countBall(List<Integer> computer, List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                if (i != j && number.get(i).equals(computer.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countStrike(List<Integer> computer, List<Integer> number) {
        int count = 0;
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i).equals(computer.get(i))) {
                count++;
            }
        }
        return count;
    }
}
