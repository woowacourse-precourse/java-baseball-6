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
        while(true) {
            Game game = new Game();
            outputView.printProgramStartMessage();

            while (true) {//입력과 결과확인
                String userInput = inputView.inputNumbers();
                Numbers user = new Numbers(userInput);
                Result result = game.calculateResult(user);

                outputView.printResult(result.getResult());

                if (result.isThreeStrike()) {
                    outputView.printFinishGameMessage();
                    break;
                }
            }

            //재시작 여부
            String input = inputView.inputContinue();
            Validator validator = new Validator();
            validator.validateContinue(input);

            if (!isOne(input)) {
                break;
            }
        }
    }
}
