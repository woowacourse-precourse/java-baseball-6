package baseball.domain;

import baseball.utils.RandomUtils;

import java.util.List;

public class Answer {
    private final int size;
    private final List<Integer> answer;
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

    public List<Integer> getAnswer() {
        return answer;
    }

    public int getSize() {
        return size;
    }
}
