package baseball.domain;

import baseball.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer extends DefaultData {

    public Computer() {
        super();
        setNumberList(generateComputerNumber());
    }
    private List<Integer> generateComputerNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < MAX_LENGTH) {
            int randomNumber = RandomNumberGenerator.generate();
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public int countStrike(List<Integer> userNumber) {
        int strikeCount = 0;
        for (int index = 0; index < MAX_LENGTH; index++) {
            if (Objects.equals(userNumber.get(index), numberList.get(index))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int countBall(List<Integer> userNumber) {
        int ballCount = 0;
        for (Integer number : userNumber) {
            if (numberList.contains(number)) {
                ballCount += 1;
            }
        }
        return ballCount - countStrike(userNumber);
    }

}
