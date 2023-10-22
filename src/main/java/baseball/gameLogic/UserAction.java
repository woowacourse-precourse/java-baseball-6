package baseball.gameLogic;

import java.util.List;

import baseball.models.User;

import static baseball.utils.Constants.ANSWER_LENGTH;

import static baseball.utils.InputValidator.validateAnswerLength;
import static baseball.utils.InputValidator.validateIsDistinct;
import static baseball.utils.InputValidator.validateRestartInput;

import static baseball.userInterface.InputViewer.requestUserAnswer;
import static baseball.userInterface.InputViewer.requestUserRestartFactor;

/*
 User의 행동들을 수행하는 클래스
 */

public class UserAction {
    private final User user = new User();


    public void inputAnswer(){
        String userAnswer = requestUserAnswer();
        validateAnswerLength(userAnswer.length());
        validateIsDistinct(userAnswer);
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            user.saveNumber(userAnswer.charAt(i));
        }
    }

    public void inputRestartFactor(){
        String userMind = requestUserRestartFactor();
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
