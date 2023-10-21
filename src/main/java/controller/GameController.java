package controller;

import model.GameNumber;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * packageName    : controller
 * fileName       : GameController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-19        qkrtn_ulqpbq2       최초 생성
 */
public class GameController {

    OutputView outputView = new OutputView();
    GameNumber gameNumber = new GameNumber();
    ComputerController computer = new ComputerController();
    InputView inputView = new InputView();
    ValidationController validation = new ValidationController();

    public void proceedGame(){
        boolean gameState = true;

        while(gameState){
            outputView.printGameStart();
            computer.startGame(gameNumber);
            messagePrint();
        }
    }

    private void messagePrint(){
        boolean answer = false;
        while(!answer){
            validationPlayer();
            answer = computer.threeStrike(gameNumber);
            messagePrint(answer);
        }
    }

    private void messagePrint(boolean answer){
        if(answer){
            outputView.printGameEnd();
        }
    }

    private void validationPlayer(){
        gameNumber.setPlayerInput(inputView.inputNumber());
        List<Integer> playerNumbers = validation.validate(gameNumber.getPlayerInput());
        gameNumber.setPlayerNumbers(playerNumbers);
    }
}
