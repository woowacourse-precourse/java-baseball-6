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
        if(strike==3){
            OutputView.printExit();
            return !checkRetry();
        }
        return false;
    }

    public boolean checkRetry(){
        String input = InputView.inputRestart();
        validateIsNumber(input);
        return validateIsOneOrTwo(input);
    }

    private void validateIsNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private boolean validateIsOneOrTwo(String input){
        if(input.equals("1")){
            computerNumber.clearRandomNumber();
            computerNumber.makeRandomNumber();
            return true;
        }
        else if(input.equals("2"))
            return false;
        else
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
    }
}
