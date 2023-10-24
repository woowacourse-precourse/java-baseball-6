package baseball.controller;

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
            outputView.printChoiceInfoMessage();
            if(inputView.inputChoiceNumber()==2){
                break;
            }

        }


    }

    private void playGame(){
        computer.createBaseballNumber();
        while(true){
            if(strikeCountInOneRound()==3){
                outputView.printClosingMessage();
                break;
            }
        }


    }

    private int strikeCountInOneRound(){
        outputView.printInputInfoMessage();
        int playerNumber = inputView.inputPlayerNumber();
        List<Integer> playerBaseballNumber = baseballNumberGenerator.createPlayerBaseballNumber(playerNumber);

        int strike = computer.countStrike(playerBaseballNumber);
        int ball= computer.countBall(playerBaseballNumber);

        outputView.printResultMessage(strike,ball);

        return strike;


    }
}
