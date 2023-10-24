package baseball;

import model.ModelCompareAnswerInput;
import model.ModelCreateRandomNumber;
import model.ModelRestartOrEnd;
import model.ModelUserNumCheck;
import view.ViewInput;
import view.ViewResult;
import view.ViewStart;
import vo.Balls;
import vo.Result;

/**
 * BaseBallGame.java
 * <p>
 * 야구게임이 수행될 메인 부분
 *
 * @author Lee NaYeon
 * @since 2023-10-24
 */

public class BaseBallGame {

    public void start() {

        ViewStart.view();

        do {

            Balls computer = new Balls(ModelCreateRandomNumber.createRandomNumber());

            while (true) {

                Balls user = ModelUserNumCheck.changeToComparable(ViewInput.numInputView());

                Result result = ModelCompareAnswerInput.compareAnswerInput(computer, user);

                ViewResult.view(result);

                if (ModelCompareAnswerInput.isAnswer(result)) {
                    break;
                }
            }

        } while (!ModelRestartOrEnd.isEnd(ViewInput.restartOrEndInputView()));

    }

}
