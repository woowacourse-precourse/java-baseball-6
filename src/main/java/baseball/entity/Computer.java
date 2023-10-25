package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class Computer {
    private final int NUMBER_LENGTH = 3;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;

    String answer;

    public Computer() {
        answer = "";
    }

    public void generateRandomAnswer() {
        StringBuilder answerBuilder = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != NUMBER_LENGTH) {
            set.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        for (int i : set) {
            answerBuilder.append(i);
        }
        answer = answerBuilder.toString();
    }

    public String getAnswer() {
        return answer;
    }
}
