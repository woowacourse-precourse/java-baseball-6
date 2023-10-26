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

    private static final String WRONG_ANSWER_INPUT_MESSAGE = "1 혹은 2만 입력 가능합니다.";
    private static final String BASEBALL_GAME_RESTART_ANSWER = "1";
    private static final String BASEBALL_GAME_END_ANSWER = "2";

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
            gameState = askRestartGame();
        }
    }

    private boolean askRestartGame() {
        String answer = inputView.enterAnswerRestartGame();
        return wantRestartGame(answer);
    }

    public boolean wantRestartGame(String answer) {
        if (answer.equals(BASEBALL_GAME_RESTART_ANSWER)) {
            return true;
        } else if (answer.equals(BASEBALL_GAME_END_ANSWER)) {
            return false;
        }

        throw new IllegalArgumentException(WRONG_ANSWER_INPUT_MESSAGE);
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
