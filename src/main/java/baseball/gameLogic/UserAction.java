package baseball.gameLogic;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import baseball.models.User;
import static baseball.utils.Constants.ANSWER_LENGTH;
import static baseball.utils.InputValidator.*;

/*
 User의 행동들을 수행하는 클래스
 */

public class UserAction {
    private final User user = new User();


    public void inputAnswer(){
        String userAnswer = Console.readLine();
        validateAnswerLength(userAnswer.length());
        validateIsDistinct(userAnswer);
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            user.saveNumber(userAnswer.charAt(i));
        }
    }

    public void inputRestartFactor(){
        String userMind = Console.readLine();
        user.changeMind(validateRestartInput(userMind));
    }

    public List<Integer> showNumberList(){
        return user.showNumberList();
    }

    public int showMind(){
        return user.showMind();
    }

    public void clearAnswer(){
        user.clearAnswerList();
    }

}
