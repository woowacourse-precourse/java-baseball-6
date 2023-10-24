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

import model.CalculateResult;
import model.CreateRandomNumber;
import model.InputRestartOrEnd;
import view.InputView;
import view.ResultView;
import view.StartView;
import vo.AnswerBall;
import vo.ResultBall;
import vo.UserBall;

public class BaseballController {
    public static void startBaseball() {
        StartView.startView();
        do {
            AnswerBall answerBall = new AnswerBall(CreateRandomNumber.createRandomNumber());

            while (true) {
                UserBall userBall = InputView.userInput();
                ResultBall resultBall = CalculateResult.getResult(answerBall, userBall);
                ResultView.View(resultBall);

                if (CalculateResult.isThreeStrikes(resultBall)) {
                    break;
                }
            }
        } while (InputRestartOrEnd.userInput());

    }
}