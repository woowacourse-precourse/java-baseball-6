package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private String randomNumber;

    public String getRandomNumber() {
        return randomNumber;
    }

    public Computer() {
        setComputerNumber();
    }

    private void setComputerNumber() {
        randomNumber = generateRandomNumber()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(""));
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
