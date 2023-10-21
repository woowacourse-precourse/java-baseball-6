package baseball.controller;

import baseball.domain.Game;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.domain.Validator;
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

    public Numbers convertToNumbers(String values){
        return new Numbers(values);
    }
    public boolean isContinue(String input){
        Validator validator=new Validator();
        validator.validateContinue(input);

        return isOne(input);
    }

    private boolean isOne(String input){
        return input.equals("1");
    }

    public void start(){
        String input="1";
        outputView.printProgramStartMessage();

        while(isOne(input)) {
            game = new Game();

            playGame();

            //재시작 여부
            input = inputView.inputContinue();
            Validator validator = new Validator();
            validator.validateContinue(input);
        }
    }

    private void playGame(){
        while (playOneTime())//게임 입출력 사이클 1회 반복
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
