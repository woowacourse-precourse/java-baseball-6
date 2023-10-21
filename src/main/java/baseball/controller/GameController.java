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
        Result result=new Result(new Numbers("123"),new Numbers("456"));

        while (!result.isThreeStrike()) {//입력과 결과확인
            String userInput = inputView.inputNumbers();
            Numbers user = new Numbers(userInput);
            result = game.calculateResult(user);

            outputView.printResult(result.getResult());
        }

        outputView.printFinishGameMessage();
    }
}
