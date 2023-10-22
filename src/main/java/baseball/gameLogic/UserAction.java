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
 1. 컴퓨터의 난수에 대한 예측 값을 유저로부터 입력한다.
 2. 재시작 인자를 입력한다(유저의 게임 진행의지를 바꾼다.).
 3. 유저의 예측 값 리스트(답안)를 보여준다.
 4. 유저의 게임 지속 진행여부(mind)를 보여준다
 5. 유저의 답안(예측 값)을 지운다.
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
