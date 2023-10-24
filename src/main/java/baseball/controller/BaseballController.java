package baseball.controller;

import baseball.constant.BaseBallNumberConstant;
import baseball.constant.ChoiceNumberConstant;
import baseball.model.BaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.model.Computer;

import java.util.List;

public class BaseballController {
    private InputView inputView;
    private OutputView outputView;
    private Computer computer;
    private BaseballNumberGenerator baseballNumberGenerator;

    public BaseballController(InputView inputView,OutputView outputView,Computer computer,BaseballNumberGenerator baseballNumberGenerator ){
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
        this.baseballNumberGenerator = baseballNumberGenerator;
    }

    public void start(){
        outputView.printInitialMessage();

        while(true){
            playGame();
            outputView.printChoiceNumberInfoMessage();
            if(inputView.inputChoiceNumber()== ChoiceNumberConstant.END){
                break;
            }

        }


    }

    private void playGame(){
        computer.createBaseballNumber();
        while(true){
            if(strikeCountInOneRound()== BaseBallNumberConstant.DIGIT){
                outputView.printClosingMessage();
                break;
            }
        }


    }

    private Integer strikeCountInOneRound(){
        outputView.printInputNumberInfoMessage();
        Integer playerNumber = inputView.inputPlayerNumber();
        List<Integer> playerBaseballNumber = baseballNumberGenerator.createPlayerBaseballNumber(playerNumber);

        Integer strike = computer.countStrike(playerBaseballNumber);
        Integer ball= computer.countBall(playerBaseballNumber);

        outputView.printResultMessage(strike,ball);

        return strike;


    }
}
