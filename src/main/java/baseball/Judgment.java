package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class Judgment {

    private final List<Integer> answer;

    public Judgment(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean judge(List<Integer> guess) {
        Hint hint = new Hint(countStrike(guess), countBall(guess));
        System.out.println(hint);

        return hint.isAnswer();
    }

    private int countBall(List<Integer> guess) {
        return (int) IntStream.range(0, 3)
            .filter(i -> answer.contains(guess.get(i))
                && !guess.get(i).equals(answer.get(i)))
            .count();
    }

    private int countStrike(List<Integer> guess) {
        return (int) IntStream.range(0, 3)
            .filter(i -> guess.get(i).equals(answer.get(i)))
            .count();
    }

}