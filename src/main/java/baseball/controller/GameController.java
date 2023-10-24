package baseball.controller;

import baseball.dto.RoundResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameController {
    private InputView inputView=new InputView();
    private OutputView outputView=new OutputView();
    private GameService gameService=new GameService();

    public void startProgram(){
        outputView.printProgramStartMessage();
        startGame();
    }

    private void startGame(){
        startRound();

        if(gameService.isRestart(inputRestart())){
            startGame();
        }
    }

    private void startRound(){
        RoundResult roundResult = gameService.playRound(inputNumbers());
        outputView.printResult(getResultMessage(roundResult));

        if(roundResult.isFinish()){
            outputView.printFinishGameMessage();
            return;
        }
        startRound();
    }

    private Numbers inputNumbers(){
        return new Numbers(inputView.inputNumbers());
    }

    private String getResultMessage(RoundResult roundResult){
        return roundResult.getResultMessage();
    }

    private Restart inputRestart(){
        return new Restart(inputView.inputContinue());
    }
}