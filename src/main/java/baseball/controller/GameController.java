package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Round;
import baseball.vo.Numbers;
import baseball.vo.Restart;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private GameService gameService;

    public GameController() {
        inputView=new InputView();
        outputView=new OutputView();
        gameService=new GameService();
    }

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
        Round round =gameService.playRound(inputUser());
        printResult(round.getResultMessage());

        if(round.isFinishGame()){
            gameService.finishGame();
            outputView.printFinishGameMessage();
            return;
        }
        startRound();
    }

    private void printResult(String resultMessage){
        outputView.printResult(resultMessage);
    }

    private Numbers inputUser(){
        return new Numbers(inputView.inputNumbers());
    }

    private Restart inputRestart(){
        return new Restart(inputView.inputContinue());
    }
}