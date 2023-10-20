package baseball.gameLogic;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import baseball.models.User;

/*
 User의 행동들을 수행하는 클래스
 */

public class UserAction {
    public User user = new User();


    public void inputAnswer(InputValidator inputValidator){
        user.numberList = inputValidator.validateUserAnswer(Console.readLine());
    }

    public void inputRestartFactor(InputValidator inputValidator){
        user.mind = inputValidator.validateRestartInput(Console.readLine());
    }

    public List<Integer> getNumberList(){
        return user.numberList;
    }

}
