/*
 * <pre>
 * Class : BaseballController
 * Comment: model과 view를 연결
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2023-10-22       손준형           최초 생성
 * </pre>
 *
 * @author 손준형
 * @version 1.0.0
 * @see
 */

package controller;

import java.util.List;
import model.CreateRandomNumber;
import model.Result;
import view.InputView;
import view.RestartOrEndView;
import view.ResultView;
import view.StartView;
import vo.AnswerBall;

public class BaseballController {
    public static void startBaseball() {
        StartView.startView();
        while (true) {
            AnswerBall answerBall = new AnswerBall(CreateRandomNumber.createRandomNumber());

            while (true) {
                List<Integer> userInput = InputView.userInput();
                List<Integer> result = Result.getResult(answerBall, userInput);
                if (ResultView.resultView(result)) {
                    break;
                }
            }
            if (!RestartOrEndView.userInput()) {
                break;
            }
        }

    }
}