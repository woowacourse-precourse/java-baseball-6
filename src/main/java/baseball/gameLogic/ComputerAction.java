package baseball.gameLogic;

import baseball.models.Computer;
import baseball.utils.RandomNumberGenerator;

import java.util.List;

import static baseball.utils.Constants.*;

/*
  Computer의 행동들을 수행하는 클래스
  1. 난수를 생성하여 저장한다.
  2. 생성한 난수 리스트를 보여준다.
  3. 생성한 난수 리스트(정답)를 지운다
*/

public class ComputerAction {
    private final Computer computer = new Computer();

    public void generateNumber() {
        while (computer.getListSize() < ANSWER_LENGTH) {
            int randomNumber = RandomNumberGenerator.pickRandomNaturalNumber();
            List<Integer> randomNumberList = showNumberList();

            if (!randomNumberList.contains(randomNumber)) {
                computer.saveNumber(randomNumber);
            }
        }
    }

    public List<Integer> showNumberList() {
        return computer.showNumberList();
    }

    public void clearAnswer() {
        computer.clearAnswerList();
    }
}
