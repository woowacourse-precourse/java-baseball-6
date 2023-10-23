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
        int strike = 0, ball = 0;
        for (int i = 0; i < guess.size(); i++) {
            Integer guessNumber = guess.get(i);
            if (answer.contains(guessNumber)) {
                if (answer.get(i).equals(guessNumber)) {
                    strike++;
                    continue;
                }
                ball++;
            }
        }

        return new Hint(strike, ball);
    }

}