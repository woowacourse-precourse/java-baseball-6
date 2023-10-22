package baseball.controller;

import baseball.model.*;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.model.GameCycle;

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
        playGame();

        if(gameService.isRestart(inputRestart())){
            startGame();
        }
    }

    private void playGame(){
        GameCycle gameCycle=gameService.play(inputUser());
        outputView.printResult(gameCycle.getResultMessage());

        if(gameCycle.isFinish()){
            gameService.finishGame();
            outputView.printFinishGameMessage();
            return;
        }
        playGame();
    }

    private Numbers inputUser(){
        return new Numbers(inputView.inputNumbers());
    }

    private Restart inputRestart(){
        return new Restart(inputView.inputContinue());
    }
}