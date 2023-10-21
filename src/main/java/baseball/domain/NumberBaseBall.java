package baseball.domain;

import java.util.List;

public class NumberBaseBall {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public Result verifyGuess(List<Integer> answer, List<Integer> guessAnswer) {
        int strike = 0;
        int ball = 0;

        for(int i=0; i<guessAnswer.size(); i++) {
            int number = guessAnswer.get(i);
            int index = answer.indexOf(number);

            if(index == -1) continue;

            if(index == i) strike++;
            else ball++;
        }

        return new Result(ball,strike);
    }
}
