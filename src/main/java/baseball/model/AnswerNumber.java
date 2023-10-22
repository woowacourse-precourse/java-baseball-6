package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class AnswerNumber {
    private String answer = "";
    public List<Integer> createRandomNumberList() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public String changeListToNumber(List<Integer> randomNumber) {
        StringBuilder computer = new StringBuilder();
        for (Integer i : randomNumber) {
            computer.append(i);
        }
        return computer.toString();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String randomNumber) {
        answer = randomNumber;
    }
}