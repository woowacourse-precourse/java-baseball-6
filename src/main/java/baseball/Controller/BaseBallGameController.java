package baseball.Controller;

import baseball.Domain.ComputerNumber;
import baseball.Domain.UserNumber;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseBallGameController {

    private UserNumber userNumber;
    private ComputerNumber computerNumber;

    public void gameStart(){
        OutputView.startBaseBallGame();
        inputUserNumber();
        setComputerNumber();
    }

    public void inputUserNumber(){ // 유저 정보 넣기
        OutputView.inputUserNumber();
        userNumber = new UserNumber(InputView.inputUserNumber());
    }

    public void setComputerNumber(){
        computerNumber = new ComputerNumber();
    }
}
