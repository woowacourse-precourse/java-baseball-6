package baseball.controller;

import baseball.model.ControllNumber;
import baseball.model.Count;
import baseball.model.Number;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameLogic {
    InputView inputView = new InputView();

    public void checkBaseball() {
        Number number = new Number();
        countBallAndStrike(number.getUserNumber(), number.getComputerNumber());
        printCount();
    }

    public void ball(int[] inputNumber, int[] computerNumber) {
        int count = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            for (int j = 0; j < computerNumber.length; j++) {
                if (i != j) {
                    if (compareNumber(inputNumber[i], computerNumber[j])) {
                        count++;
                    }
                }
            }
        }
        Count.setBall(count);
    }

    public void strike(int[] inputNumber, int[] computerNumber) {
        int count = 0;
        for (int i = 0; i < inputNumber.length; i++) {
            for (int j = 0; j < computerNumber.length; j++) {
                if (i == j) {
                    if (compareNumber(inputNumber[i], computerNumber[j])) {
                        count++;
                    }
                }
            }
        }
        Count.setStrike(count);
    }

    public boolean compareNumber(int inputNumber, int computerNumber) {
        return inputNumber == computerNumber;
    }

    public boolean checkExitGame(int exitNumber) throws IllegalArgumentException {
        if (exitNumber == 1) {
            return true;
        } else if (exitNumber == 2) {
            return false;
        }
        throw new IllegalArgumentException("1과2가 아닌 숫자를 입력하였습니다.");
    }

    public void countBallAndStrike(int[] inputNumber, int[] computerNumber) {
        ball(inputNumber, computerNumber);
        strike(inputNumber, computerNumber);
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
                System.out.print(Count.getStrike());
                OutputView.strike();
                ControllNumber.setStrikeCount(Count.getStrike());
                return true;
            }
            System.out.println(Count.getBall());
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
        Number number = new Number();
        number.setUserNumber(num);
    }

    public boolean gameStopCheckInputNumber(int strikeCount) {
        if (strikeCount == 3) {
            ControllNumber.setStrikeCount(0);
            inputGameExitNumber();
            return false;
        }
        return true;
    }

    public void inputGameExitNumber() {
        ControllNumber.setExitNumber(inputView.gameStopInputNumber());
    }

}
