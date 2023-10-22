package baseball.gameLogic;

import baseball.models.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.*;
import static baseball.utils.RandomNumberGenerator.pickRandomNumberValidRange;

/*
  Computer의 행동들을 수행하는 클래스
*/

public class ComputerAction {
    private final Computer computer = new Computer();

    public void generateNumber(){
        while (computer.getListSize() < ANSWER_LENGTH){
            int randomNumber = pickRandomNumberValidRange();
            List<Integer> randomNumberList = showNumberList();

            if (!randomNumberList.contains(randomNumber))
                computer.saveNumber(randomNumber);
        }
    }

    public List<Integer> showNumberList(){
        return computer.showNumberList();
    }

    public void clearAnswer(){
        computer.clearAnswerList();
    }
}
