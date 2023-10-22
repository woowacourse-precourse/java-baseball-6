package baseball.domain;

import baseball.utils.RandomUtils;

import java.util.List;

public class Answer {
    private final List<Integer> answer;
    private final int size;
    private Answer(int size, List<Integer> answer) {
        this.size = size;
        this.answer = answer;
    }

    public static Answer createByRandom(int size) {
        return new Answer(size, RandomUtils.generateDistinctNumbers(size));
    }

    public static Answer createByList(List<Integer> list) {
        return new Answer(list.size(), list);
    }


    public boolean isCorrect(Answer guessAnswer) {
        if(guessAnswer == null) return false;

        return this.answer.equals(guessAnswer.getAnswer());
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public int getSize() {
        return size;
    }
}
