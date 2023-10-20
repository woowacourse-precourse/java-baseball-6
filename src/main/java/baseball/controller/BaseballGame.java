package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.service.CalcScore;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private ComputerNumber computerNumber;
    private CalcScore calcScore;

    public BaseballGame(){
        computerNumber = new ComputerNumber();

    }

    public void start(){
        OutputView.printStart();
        playGame();

    }
    public void playGame(){
        UserNumber userNumber = new UserNumber(InputView.inputNumber());
        String input = userNumber.getUserNumber();

        calcScore = new CalcScore(computerNumber.getComputer(), input);
        int strike = calcScore.calcStrike();
        int ball = calcScore.calcBall();


    }
}
