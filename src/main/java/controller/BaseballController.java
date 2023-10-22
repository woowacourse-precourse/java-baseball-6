/*
 * <pre>
 * Class : BaseballController
 * Comment: baseball.Application 시작 클래스
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
import view.InputView;
import view.StartView;

public class BaseballController {
    public static void startBaseball() {
        StartView.startView();
        List<Integer> answer = CreateRandomNumber.createRandomNumber();
        List<Integer> userInput = InputView.userInput();

    }


}
