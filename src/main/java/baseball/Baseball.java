package baseball;


import static baseball.model.MsgConst.WELCOME_MSG;
import static baseball.model.NumConst.END;
import static baseball.model.NumConst.RESTART;
import static baseball.util.CountResult.ball;
import static baseball.util.CountResult.strike;
import static baseball.util.Validation.validateNumberDuplicated;
import static baseball.util.Validation.validateNumberLength;
import static baseball.util.Validation.validateNumberRange;

import baseball.control.ComputerControl;
import baseball.control.UserControl;
import baseball.util.Converter;
import baseball.util.CountResult;
import baseball.util.Validation;
import baseball.view.ResultView;
import baseball.view.UserView;
import java.util.List;


public class Baseball {
    public static Validation validation = new Validation();
    public static ComputerControl computerControl = new ComputerControl();
    public static UserControl userControl = new UserControl();
    public static CountResult countResult = new CountResult();
    public static ResultView resultView = new ResultView();
    public static UserView userView = new UserView();
    public static List<Integer> computerNum;
    public static boolean isRestart = false;
    public static List<Integer> userNum;


    public void playGame() {

        isRestart = false;
        startGame();

        while (!isRestart) {
            userView.requestInput();
            String inputNum = userControl.getNumber();
            Converter.toIntegerList(inputNum);

            validateNumberLength(inputNum);
            validateNumberDuplicated(userNum);
            validateNumberRange(userNum);

            countResult.countingBall(computerNum, userNum);
            countResult.countingStrike(computerNum, userNum);

            resultView.givingHint(ball, strike);

        }
    }

    public static void startGame() {
        System.out.println(WELCOME_MSG);
        computerNum = computerControl.generateRandomNum();
    }

    public static void restartOrExit() {
        UserView.requestReply();
        String reply = UserControl.getRestartCode();

        if (reply.equals(RESTART)) {
            computerNum = ComputerControl.generateRandomNum();
        } else if (reply.equals(END)) {
            isRestart = true;
        }
        validation.validateReply(reply);
    }

}
