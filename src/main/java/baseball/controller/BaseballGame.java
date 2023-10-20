package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.service.CalcScore;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerNumber computerNumber;
    private int ball =0 ;
    private int strike =0;

    public BaseballGame(){
        computerNumber = new ComputerNumber();

    }

    public void start(){
        OutputView.printStart();
        System.out.println(computerNumber.getComputer());
        do{
            playGame();
            printScore();
        }while(!isFinished());

    }
    public void playGame(){
        UserNumber userNumber = new UserNumber(InputView.inputNumber());
        String input = userNumber.getUserNumber();

        CalcScore calcScore = new CalcScore(computerNumber.getComputer(), input);
        strike = calcScore.calcStrike();
        ball = calcScore.calcBall();

    }

    public void printScore(){
        if(strike == 3)
            OutputView.printStrike(strike);
        else if(strike == 0 && ball ==0)
            OutputView.printNothing();
        else if(strike!=0 && ball == 0)
            OutputView.printStrike(strike);
        else if(strike == 0)
            OutputView.printBall(ball);
        else
            OutputView.printBallAndStrike(ball, strike);
    }

    public boolean isFinished(){
        return strike == 3;
    }
}
