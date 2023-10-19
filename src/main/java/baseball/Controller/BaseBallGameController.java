package baseball.Controller;

import baseball.Domain.UserNumber;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseBallGameController {

    private UserNumber userNumber;

    public void gameStart(){
        OutputView.startBaseBallGame();
        inputUserNumber();
    }

    public void inputUserNumber(){ // 유저 정보 넣기
        OutputView.inputUserNumber();
        userNumber = new UserNumber(InputView.inputUserNumber());
    }
}
