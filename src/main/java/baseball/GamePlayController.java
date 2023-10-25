package baseball;

import static baseball.InputView.*;
import static baseball.OutputView.printGameEnd;
import static baseball.OutputView.printGameStart;

public class GamePlayController {
    private ComputerNumber computerNumber = new ComputerNumber();
    private UserNumber userNumber = new UserNumber();
    private CompareNumber compareNumber = new CompareNumber();
    private boolean gameStatus = true;

    public void gameStart(){
        printGameStart();
        computerNumber.getComputerNumber();
        while (gameStatus){
            userNumber.UserNumber(userInputNumber());
            if(compareNumber.CompareNumber(userNumber.getUserNumber(),computerNumber.getComputerNumber())){
                printGameEnd();
                selectGameRestart();
            }
        }
    }
    public void selectGameRestart() throws IllegalArgumentException{
        String restartNum = userInputGameRestart();
        if (restartNum.equals("1")){
            restartGame();
        }
        else if (restartNum.equals("2")){
            gameEnd();
        }
        else {
            throw new IllegalArgumentException("1 또는 2를 입력하세요");
        }
    }
    public void restartGame(){
        computerNumber.generateNumber();
        gameStatus = true;
    }

    public void gameEnd(){
        gameStatus = false;
    }


}
