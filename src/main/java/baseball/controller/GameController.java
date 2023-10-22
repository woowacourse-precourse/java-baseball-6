package baseball.controller;

import baseball.model.*;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private Game game;

    public GameController() {
        inputView=new InputView();
        outputView=new OutputView();
    }

    public void start(){
        outputView.printProgramStartMessage();
        startGame();
    }

    private void startGame(){
        game = new Game(); //게임 생성
        playGame(); //게임 수행

        if (checkRestart()){
            startGame();
        }
    }

    private boolean checkRestart(){
        Restart restart =new Restart(inputView.inputContinue());
        return restart.isContinue();
    }

    private void playGame(){
        playOneCycle();//게임 입출력 사이클 1회 반복
        
        outputView.printFinishGameMessage();//게임 종료문구 출력
    }

    private void playOneCycle(){
        GameCycle cycle=new GameCycle(game,inputUser());
        outputView.printResult(cycle.getResultMessage());

        if (cycle.isFinish()){
            return;
        }

        playOneCycle();
    }

    private Numbers inputUser(){ //입력
        return new Numbers(inputView.inputNumbers());
    }
}