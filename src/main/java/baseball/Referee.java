package baseball;

import java.util.List;

public class Referee {

    private final List<Integer> target;

    public Referee(List<Integer> target) {
        this.target = target;
    }

    public Result umpire(List<Integer> answer) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < answer.size(); i++) {
            int answerElement = answer.get(i);

            for (int j = 0; j < target.size(); j++) {
                int targetElement = target.get(j);

                if (answerElement == targetElement) {
                    if (i == j) {
                        strikes++;
                    } else {
                        balls++;
                    }
                    break;
                }
            }
        }

        return new Result(strikes, balls);
    }
}
