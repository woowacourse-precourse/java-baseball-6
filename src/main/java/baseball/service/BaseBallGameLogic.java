package baseball.service;

import baseball.model.ControllNumber;
import baseball.model.Count;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameLogic {
    InputView inputView = new InputView();

    public void checkBaseball() {
        countBallAndStrike(Number.getUserNumber(), Number.getComputerNumber());
        printCount();
    }

    public void countNumber(int[] inputNumber, int[] computerNumber) {
        Count.setBall(0);
        Count.setStrike(0);
        for (int i = 0; i < inputNumber.length; i++) {
            compareBallAndStrike(inputNumber, computerNumber, i);
        }
    }

    public void compareBallAndStrike(int[] inputNumber, int[] computerNumber, int i) {
        for (int j = 0; j < computerNumber.length; j++) {
            if (i != j) {
                countBall(inputNumber[i], computerNumber[j]);
                continue;
            }
            countStrike(inputNumber[i], computerNumber[j]);
        }
    }

    public int[] arrayNumber(int num) {
        int[] sepNum = new int[3];
        int div = 100;
        for (int i = 0; i < sepNum.length; i++) {
            sepNum[i] = num / div;
            num -= sepNum[i] * div;
            div /= 10;
        }
        return sepNum;
    }

    public boolean compareNumber(int inputNumber, int computerNumber) {
        return inputNumber == computerNumber;
    }

    public void countBall(int inputNumber, int computerNumber) {
        if (compareNumber(inputNumber, computerNumber)) {
            Count.setBall(Count.getBall() + 1);
        }
    }

    public void countStrike(int inputNumber, int computerNumber) {
        if (compareNumber(inputNumber, computerNumber)) {
            Count.setStrike(Count.getStrike() + 1);
        }
    }

    public boolean checkExitGame(int exitNumber) {
        if (exitNumber == 1) {
            return true;
        } else if (exitNumber == 2) {
            //System.out.println("게임종료");
            return false;
        }
        //System.out.println("5번오류");
        throw new IllegalArgumentException();
    }

    public void countBallAndStrike(int[] inputNumber, int[] computerNumber) {
        /*ball(inputNumber, computerNumber);
        strike(inputNumber, computerNumber);*/
        countNumber(inputNumber, computerNumber);
    }

    public void printCount() {
        if (!checkBall()) {
            if (!checkStrike()) {
                OutputView.nothing();
            }
        }
    }

    public boolean checkBall() {
        if (Count.getBall() > 0) {
            if (Count.getStrike() > 0) {
                System.out.print(Count.getBall());
                OutputView.ball();
                System.out.print(" " + Count.getStrike());
                OutputView.strike();
                ControllNumber.setStrikeCount(Count.getStrike());
                return true;
            }
            System.out.print(Count.getBall());
            OutputView.ball();
            System.out.println();
            return true;
        }
        return false;
    }

    public boolean checkStrike() {
        if (Count.getStrike() > 0) {
            ControllNumber.setStrikeCount(Count.getStrike());
            System.out.print(Count.getStrike());
            OutputView.strike();
            return true;
        }
        return false;
    }

    public static void saveInputNumber(int[] num) {
        Number.setUserNumber(num);
    }

    public boolean gameStopCheckInputNumber(int strikeCount) {
        if (strikeCount == 3) {
            inputGameExitNumber();
            return false;
        }
        return true;
    }

    public void inputGameExitNumber() {
        ControllNumber.setExitNumber(inputView.gameStopInputNumber());
    }

}
