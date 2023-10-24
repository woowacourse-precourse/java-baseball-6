package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class AnswerNumber {

    private static final int NUMBER_OF_DIGITS = 3;
    private List<Integer> randomNumber = new ArrayList<>();

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_DIGITS) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        randomNumber = computer;
    }

}