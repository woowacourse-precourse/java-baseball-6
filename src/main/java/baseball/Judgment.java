package baseball;

import java.util.List;

public class Judgment {

    private final List<Integer> answer;

    public Judgment(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean judge(List<Integer> guess) {
        Hint hint = getHintFromGuess(guess);
        System.out.println(hint);

        return hint.isAnswer();
    }

    private Hint getHintFromGuess(List<Integer> guess) {
        // 추측값과 정답을 비교.
        return new Hint();
    }

}