package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

import static baseball.constants.Constants.*;

public class Computer {

    String answer;

    public Computer() {
        answer = "";
    }

    public void generateRandomAnswer() {
        StringBuilder answerBuilder = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != NUMBER_LENGTH.getValue()) {
            set.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue()));
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
