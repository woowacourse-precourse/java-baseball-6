package baseball.Controller;

import baseball.Model.ComputerNumber;
import baseball.Model.UserNumber;
import baseball.View.InputView;
import baseball.View.OutputView;

public class GameController {

    private UserNumber userNumber;
    private ComputerNumber computerNumber;

    private CompareUserWithComputer compareUserWithComputer;

    private boolean isFinishedGame = false;
    private boolean isRestartedGame = false;

    public void gameStart() {

        while (!isFinishedGame) {

            if (isRestartedGame || userNumber == null) {
                OutputView.startBaseBallGame();
            }

            inputUserNumber();

            if (isRestartedGame || computerNumber == null) {
                setComputerNumber();
                isRestartedGame = false;
            }

            getCompareUserWithComputer();

            if (isThreeStrike()) {
                gameOverOrRestart();
            }
        }

    }

    public void inputUserNumber() { // 유저 정보 넣기
        userNumber = new UserNumber(InputView.inputUserNumber());
    }

    public void setComputerNumber() {

        computerNumber = new ComputerNumber();
        computerNumber.GeneratedRandomNumber();
    }

    public void getCompareUserWithComputer() {
        compareUserWithComputer = new CompareUserWithComputer(userNumber.getNumber(), computerNumber.getNumber());
        compareUserWithComputer.countStrikeNum();
        compareUserWithComputer.countBallNum();
        OutputView.showCompareResult(compareUserWithComputer.getStrikeNum(), compareUserWithComputer.getBallNum());
    }

    public boolean isThreeStrike() {
        return compareUserWithComputer.getStrikeNum() == 3;
    }

    public void gameOverOrRestart() {
        String value = InputView.inputGameOverOrRestart();
        if ("1".equals(value)) {
            isRestartedGame = true;
            return;
        }

        if ("2".equals(value)) {
            isFinishedGame = true;
        }
    }
}
