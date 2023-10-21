package baseball.controller;

import baseball.domain.*;
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
        while(startGame());
    }

    private boolean startGame(){
        game = new Game(); //게임 생성
        playGame(); //게임 수행

        return checkRestart();
    }

    private boolean checkRestart(){
        Restart restart =new Restart(inputView.inputContinue());
        return restart.isContinue();
    }

    private void playGame(){
        while (playOneTime());//게임 입출력 사이클 1회 반복
        
        outputView.printFinishGameMessage();//게임 종료문구 출력
    }

    private boolean playOneTime(){
        Result result=game.calculateResult(inputUser()); //결과 반환
        outputView.printResult(result.getResult()); //내용 출력

        return isNotFinish(result);
    }

    private Numbers inputUser(){ //입력
        return new Numbers(inputView.inputNumbers());
    }

    private boolean isNotFinish(Result result){
        return !result.isThreeStrike();
    }
}
