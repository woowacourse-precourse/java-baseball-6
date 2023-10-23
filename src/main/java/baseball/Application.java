package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class Computer {

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);

    }

    public List<Integer> createAnswer() {
        final int answerSize = 3;
        List<Integer> computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < answerSize) {
            int randomNumber = createRandomNumber();
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }

}

public class Application {
    public static void main(String[] args) {

        final Computer computer = new Computer();
        List<Integer> answer = computer.createAnswer();
        System.out.println(answer);
    }
}
