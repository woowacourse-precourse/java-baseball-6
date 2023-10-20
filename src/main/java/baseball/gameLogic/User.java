package baseball.gameLogic;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public List<Integer> numberList;

    public void inputAnswer(InputValidator inputValidator){
        numberList = inputValidator.validateUserAnswer(Console.readLine());
    }

}
