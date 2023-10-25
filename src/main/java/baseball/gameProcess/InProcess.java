package baseball.gameProcess;

import baseball.GameRole;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InProcess {
    private int number;
    private int ball;
    private int strike;
    private boolean isCorrect;
    private List<Integer> my;
    private List<Integer> computer;

    public boolean isNumberCorrect() {
        return isCorrect;
    }

    public InProcess(GameRole gameRole, List<Integer> computer) throws IllegalArgumentException {
        try {
            initVariables(computer);
            printInputNumberPhrase();
            inputNumber();
            checkInputNumber(gameRole);
            judgeInputNumber(gameRole, computer);
        } catch(IllegalArgumentException e) {
            throw e;
        }
    }

    private void initVariables(List<Integer> computer) {
        number = 0;
        ball = 0;
        strike = 0;
        isCorrect = false;
        this.my = new ArrayList<>();
        this.computer = computer;
    }

    private void printInputNumberPhrase() {
        System.out.print(InNotice.inputNumberPhrase);
    }

    private void inputNumber() throws IllegalArgumentException {
        try {
            number = Integer.parseInt(readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputNumber(GameRole gameRole) throws IllegalArgumentException{
        try {
            checkNumberCnt(gameRole);
            checkNumberDifferent(gameRole);
            numberToPerNumber(gameRole);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkNumberCnt(GameRole gameRole) throws IllegalArgumentException{
        if (String.valueOf(number).length() != gameRole.GAME_NUMBER_CNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberDifferent(GameRole gameRole) throws IllegalArgumentException {
        boolean[] exist = new boolean[gameRole.GAME_NUMBER_RANGE_UNDER+1];
        int share = number;

        try {
            for (int i = 0; i < gameRole.GAME_NUMBER_CNT; i++) {
                int remain = share % 10;
                share /= 10;

                if (outOfRange(gameRole, remain) || exist[remain]) {
                    throw new IllegalArgumentException();
                }
                else {
                    exist[remain] = true;
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private boolean outOfRange(GameRole gameRole, int remain) {
        if (remain >= gameRole.GAME_NUMBER_RANGE_OVER && remain <= gameRole.GAME_NUMBER_RANGE_UNDER) return false;
        else return true;
    }

    private void numberToPerNumber(GameRole gameRole) {
        String num = String.valueOf(number);
        for (int i = 0; i < gameRole.GAME_NUMBER_CNT; i++) {
            my.add(num.charAt(i) - '0');
        }
    }

    private void judgeInputNumber(GameRole gameRole, List<Integer> computer) {
        compareInputNumber(gameRole, computer);
        printCollectNumber();
        checkAllStrike(gameRole);
    }

    private void checkAllStrike(GameRole gameRole) {
        if (strike == gameRole.GAME_NUMBER_CNT) {
            isCorrect = true;
            printFinishPhrase(gameRole);
        }
    }

    private void printFinishPhrase(GameRole gameRole) {
        System.out.println(gameRole.GAME_NUMBER_CNT+InNotice.finishPhrase);
    }

    private void printCollectNumber() {
        if (ball == 0 && strike == 0) printNothing();
        else if (ball == 0 && strike > 0) printStrike();
        else if (ball > 0 && strike == 0) printBall();
        else printBallAndStrike();
    }

    private void printBallAndStrike() {
        System.out.println(ball+""+InNotice.ball+" "+strike+""+InNotice.strike);
    }

    private void printBall() {
        System.out.println(ball+""+InNotice.ball);
    }

    private void printStrike() {
        System.out.println(strike+""+InNotice.strike);
    }

    private void printNothing() {
        System.out.println(InNotice.nothing);
    }

    private void compareInputNumber(GameRole gameRole, List<Integer> computer) {
        for (int i = 0; i < gameRole.GAME_NUMBER_CNT; i++) {
            if (my.get(i) == computer.get(i)) {
                strike++;
            }
            else {
                if (computer.contains(my.get(i))) ball++;
            }
        }
    }
}
