package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    ComputerController computerController = new ComputerController();
    InputNumberController inputNumberController = new InputNumberController();
    GameNumber computerNumber = new GameNumber();
    GameNumber playerNumber = new GameNumber();
    OutputView outputView = new OutputView();

    public void proceedGame(){
        boolean status = true;

        while(status){
            outputView.printGameStart();
            computerNumber = computerController.startGame();
            play();
            outputView.printGameEnd();
            status = retryGame();
        }
    }

    private void play(){
        boolean correctAnswer = false;

        while(!correctAnswer){
            playerNumber = inputNumberController.guessNumber();
            correctAnswer = computerController.proceedTodo(computerNumber, playerNumber);
        }
    }


    private boolean retryGame(){
        return inputNumberController.retryNumber();
    }


}
