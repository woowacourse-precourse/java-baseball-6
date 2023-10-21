package baseball.controller;

import baseball.model.BaseBall;
import baseball.service.InputView;
import baseball.service.OutputView;

import java.util.List;

public class GameController {
    private static final String WRONG_ANSWER_INPUT = "1 혹은 2만 입력 가능합니다.";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BaseBall baseBall = new BaseBall();
    NumberValidator numberValidator = new NumberValidator();
    ComputerController computerController = new ComputerController();

    public void gameProcess(){
        boolean gameState = true;
        while(gameState){
            outputView.showStartMessage();
            //난수 생성->computerNumber생성
            computerController.startGame(baseBall);
            guessAnswer();
            gameState = restartGame();
        }

    }

    private void guessAnswer(){
        boolean answerState = false;

        while(!answerState){
            baseBall.setPlayerNumber(inputView.enterPlayerNumber());
            List<Integer> playerNumbers = numberValidator.validateData(baseBall.getPlayerNumber());
            baseBall.setPlayerNumbers(playerNumbers);
            answerState = computerController.gameProcess(baseBall);
            sendEndMessage(answerState);
        }
    }

    private void sendEndMessage(boolean answerState){
        if(answerState){
            outputView.endMessage();
        }
    }

    private boolean restartGame(){
        String answer = inputView.enterEndOrRestartGame();
        return wantRestart(answer);
    }

    public boolean wantRestart(String answer){
        if(answer.equals("1")) {
            return true;
        } else if (answer.equals("2")){
            return false;
        }

        throw new IllegalArgumentException(WRONG_ANSWER_INPUT);
    }



}
