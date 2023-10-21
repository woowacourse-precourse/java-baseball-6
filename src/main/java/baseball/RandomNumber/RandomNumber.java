package baseball.RandomNumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class RandomNumber {

    public String createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String randomNumber = computer.stream()
                .map(Object::toString)
                .collect(joining(""));
        return randomNumber;
    }
}
