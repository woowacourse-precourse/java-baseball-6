package baseball;


import static baseball.constant.MsgConstant.*;
import static baseball.constant.NumConstant.*;
import static baseball.util.CountResult.ball;
import static baseball.util.CountResult.strike;

import baseball.control.ComputerControl;
import baseball.control.UserControl;
import baseball.util.Converter;
import baseball.util.CountResult;
import baseball.util.Validation;
import baseball.view.ResultView;
import baseball.view.UserView;
import java.util.List;


public class Baseball {
    private static final Validation validation = new Validation();
    private static final ComputerControl computerControl = new ComputerControl();
    private static final UserControl userControl = new UserControl();
    private static final CountResult countResult = new CountResult();
    private static final ResultView resultView = new ResultView();
    private static final UserView userView = new UserView();
    private static final Converter converter = new Converter();
    public static boolean isRestart = false;
    private static List<Integer> computerNum;
    private static List<Integer> userNum;

    public void playGame() {
        isRestart = false;
        startGame();
        while (!isRestart) {
            userView.requestInput();
            String inputNum = userControl.getNumber();
            validation.validateUserInput(inputNum);

            // countingResult에서의 셈이 수월하도록 IntegerList로 변환 후 진행
            userNum = converter.toIntegerList(inputNum);
            countResult.countingResult(computerNum, userNum);

            resultView.givingResult(ball, strike);
        }
    }

    public static void startGame() {
        System.out.println(WELCOME_MSG);
        computerNum = computerControl.generateRandomNum();
    }

    public static void restartOrExit() {
        UserView.requestReply();
        String reply = userControl.getRestartCode();
        validation.validateReply(reply);

        if (reply.equals(RESTART)) {
            computerNum = computerControl.generateRandomNum();
        } else if (reply.equals(END)) {
            isRestart = true;
        }
    }
}
