package baseball.gameLogic;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import baseball.models.User;

import static baseball.utils.InputValidator.validateRestartInput;
import static baseball.utils.InputValidator.validateUserAnswer;

/*
 User의 행동들을 수행하는 클래스
 */

public class UserAction {
    private final User user = new User();


    public void inputAnswer(){
        user.numberList = validateUserAnswer(Console.readLine());
    }

    public void inputRestartFactor(){
        user.mind = validateRestartInput(Console.readLine());
    }

    public List<Integer> getNumberList(){
        return user.numberList;
    }

    public int showMind(){
        return user.mind;
    }

}
