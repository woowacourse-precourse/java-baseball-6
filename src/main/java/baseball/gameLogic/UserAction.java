package baseball.gameLogic;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class UserAction {
    public List<Integer> numberList;
    public int mind;

    public void inputAnswer(InputValidator inputValidator){
        numberList = inputValidator.validateUserAnswer(Console.readLine());
    }

    public void inputRestartFactor(InputValidator inputValidator){
        mind = inputValidator.validateRestartInput(Console.readLine());
    }

}
