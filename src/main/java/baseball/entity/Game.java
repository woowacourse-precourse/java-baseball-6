package baseball.entity;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;

    public void initAnswer() {
        List<Integer> integers = new ArrayList<>();
        while (integers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!integers.contains(randomNumber)) {
                integers.add(randomNumber);
            }
        }
        this.answer = "";
        for (Integer integer : integers) {
            this.answer += integer.toString();
        }
    }

    public int countStrike(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) == this.answer.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int countBall(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) != this.answer.charAt(i) && this.answer.contains(String.valueOf(inputString.charAt(i)))) { //리팩토링 필요한 지점
                count += 1;
            }
        }
        return count;
    }

    public boolean isAnswer(String inputString) {
        if (countStrike(inputString) == 3) {
            return true;
        }
        return false;
    }

    public void printAnswer() {
        System.out.println(this.answer);

    }

}
