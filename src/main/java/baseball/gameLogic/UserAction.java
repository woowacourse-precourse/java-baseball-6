package baseball.gameLogic;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import baseball.models.User;

public class UserAction {
    public User user = new User();


    public void inputAnswer(InputValidator inputValidator){
        user.numberList = inputValidator.validateUserAnswer(Console.readLine());
    }

    public void inputRestartFactor(InputValidator inputValidator){
        user.mind = inputValidator.validateRestartInput(Console.readLine());
    }

}
