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

import model.CreateRandomNumber;
import model.Result;
import view.InputView;
import view.RestartOrEndView;
import view.ResultView;
import view.StartView;
import vo.AnswerBall;
import vo.ResultBall;
import vo.UserBall;

public class BaseballController {
    public static void startBaseball() {
        StartView.startView();
        while (true) {
            AnswerBall answerBall = new AnswerBall(CreateRandomNumber.createRandomNumber());

            while (true) {
                UserBall userBall = new UserBall(InputView.userInput());
                ResultBall resultBall = Result.getResult(answerBall, userBall);

                ResultView resultView = new ResultView(resultBall);
                resultView.View();

                if (resultView.isThreeStrikes()) {
                    break;
                }
            }
            if (!RestartOrEndView.userInput()) {
                break;
            }
        }

    }
}