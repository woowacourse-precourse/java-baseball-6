package baseball.controller;

import baseball.model.CompareNumber;
import baseball.model.ProgramNumber;
import baseball.model.ResetGameNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    CompareNumber compareNumber = new CompareNumber();
    ProgramNumber program = new ProgramNumber();
    private UserNumber user;


    public void start(){
        do{
            checkUserNumber();
            printAll(getResultList());
        } while(!isEnd());
    }

    public boolean isEnd(){
        if (compareNumber.isThreeStrike()) {
            OutputView.printEnd();
            return true;
        }
        return false;
    }

    public int[] getResultList(){
        return compareNumber.getStrikeBall(user.getUserNumber(), program.getProgramNumber());
    }

    public void checkUserNumber(){
        //생성자에서 숫자 검증
        user = new UserNumber(InputView.inputUserNumber());
    }

    public void printBallStrike(int[] count){
        if (count[0] != 0 & count[1] != 0) { //볼, 스트라이크 모두 있다면
            OutputView.printCnt(count[0]);
            OutputView.printBallWithStrike();
            OutputView.printCnt(count[1]);
            OutputView.printStrike();
        }
    }

    public void printBall(int[] count){
        if (count[0] != 0 & count[1] == 0) {
            OutputView.printCnt(count[0]);
            OutputView.printBall();
        }
    }

    public void printStrike(int[] count){
        if (count[0] == 0 & count[1] != 0) {
            OutputView.printCnt(count[1]);
            OutputView.printStrike();
        }
    }

    public void printNothing(int[] count){
        if (count[0] == 0 & count[1] == 0) {
            OutputView.printNothing();
        }
    }

    public void printAll(int[] count){
        printBall(count);
        printBallStrike(count);
        printStrike(count);
        printNothing(count);
    }

    public boolean isReset(){
        ResetGameNumber resetGameNumber = new ResetGameNumber(InputView.resetNumber());
        return resetGameNumber.getResetNumber().equals("1");
    }
}
