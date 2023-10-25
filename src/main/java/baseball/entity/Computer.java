package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.stream.Collectors;

import static baseball.constants.Constants.*;

public class Computer {

    String answer;

    public Computer() {
        answer = "";
    }

    public void generateRandomAnswer() {
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != VALID_NUMBER_LENGTH.getValue()) {
            set.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER.getValue(), MAX_RANDOM_NUMBER.getValue()));
        }
        answer = String.join("", set.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public String getAnswer() {
        return answer;
    }
}
