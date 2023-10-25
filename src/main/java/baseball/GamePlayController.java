package baseball;

import static baseball.InputView.gameRestart;
import static baseball.InputView.userInputNumber;
import static baseball.OutputView.printGameEnd;
import static baseball.OutputView.printGameStart;

public class GamePlayController {
    private ComputerNumber computerNumber = new ComputerNumber();
    private UserNumber userNumber = new UserNumber();
    private CompareNumber compareNumber = new CompareNumber();
    boolean gameStatus = true;

    public void gameStart(){
        printGameStart();
        computerNumber.getComputerNumber();
        while (gameStatus){
            userNumber.UserNumber(userInputNumber());
            if(compareNumber.CompareNumber(userNumber.getUserNumber(),computerNumber.getComputerNumber())){
                printGameEnd();
                this.gameStatus = false;

                if(gameRestart().equals("1")){
                    gameStart();
                }
                if(gameRestart().equals("2")){
                    break;
                }
            }

        }

    }


}
