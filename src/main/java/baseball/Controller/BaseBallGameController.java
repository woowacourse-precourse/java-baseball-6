package baseball.Controller;

import baseball.Domain.CompareUserWithComputer;
import baseball.Domain.ComputerNumber;
import baseball.Domain.UserNumber;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseBallGameController {

    private UserNumber userNumber;
    private ComputerNumber computerNumber;

    private CompareUserWithComputer compareUserWithComputer;

    private boolean isFinishedGame = true;
    private boolean isRestartedGame = false;

    public void gameStart(){

        while(isFinishedGame){

            if(isRestartedGame || userNumber == null){
                OutputView.startBaseBallGame();
            }

            inputUserNumber();

            if(isRestartedGame || computerNumber == null){
                setComputerNumber();
                isRestartedGame = false;
            }

            getCompareUserWithComputer();

            if(isThreeStrike(compareUserWithComputer.getStrikeNum())){
                GameOver();
            }
        }

    }

    public void inputUserNumber(){ // 유저 정보 넣기
        OutputView.inputUserNumber();
        userNumber = new UserNumber(InputView.inputUserNumber());
    }

    public void setComputerNumber(){
        computerNumber = new ComputerNumber();
    }

    public void getCompareUserWithComputer(){
        compareUserWithComputer = new CompareUserWithComputer(userNumber.getNumber(),computerNumber.getNumber());
        OutputView.showCompareResult(compareUserWithComputer.getStrikeNum(), compareUserWithComputer.getBallNum());
    }

    public boolean isThreeStrike(int strikeNum){

        return strikeNum == 3;
    }

    public void GameOver(){
        OutputView.gameOver();
        String value = InputView.inputGameOverOrRestart();
        if("1".equals(value)){
            isRestartedGame = true;
        }

        if("2".equals(value)){
            isFinishedGame = false;
        }
    }
}
