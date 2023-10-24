package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class AnswerNumber {
    private List<Integer> randomNumber = new ArrayList<>();

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        randomNumber = computer;
    }

}