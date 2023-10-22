package baseball.domain;

import baseball.utils.RandomUtils;

import java.util.List;

public class Answer {
    private final List<Integer> answer;

    private Answer(List<Integer> answer) {
        this.answer = answer;
    }

    public Answer createByRandom(int numberLength) {
        return new Answer(RandomUtils.generateDistinctNumbers(numberLength));
    }

    public Answer createByList(List<Integer> list) {
        return new Answer(list);
    }


    public boolean isCorrect(Answer guessAnswer) {
        return this.answer.equals(guessAnswer.getAnswer());
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
