package baseball.gameProcess;

import baseball.GameSetting;

import java.util.ArrayList;
import java.util.List;

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

    public InProcess(GameSetting gameSetting, List<Integer> computer) throws IllegalArgumentException {
        try {
            initVariables(computer);
            printInputNumberPhrase();
            inputNumber();
            checkInputNumber(gameSetting);
            judgeInputNumber(gameSetting, computer);
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

    private void checkInputNumber(GameSetting gameSetting) throws IllegalArgumentException{
        try {
            checkNumberCnt(gameSetting);
            checkNumberDifferent(gameSetting);
            numberToPerNumber(gameSetting);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void checkNumberCnt(GameSetting gameSetting) throws IllegalArgumentException{
        if (String.valueOf(number).length() != gameSetting.GAME_NUMBER_CNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberDifferent(GameSetting gameSetting) throws IllegalArgumentException {
        boolean[] exist = new boolean[gameSetting.GAME_NUMBER_RANGE_UNDER+1];
        int share = number;

        try {
            for (int i = 0; i < gameSetting.GAME_NUMBER_CNT; i++) {
                int remain = share % 10;
                share /= 10;

                if (outOfRange(gameSetting, remain) || exist[remain]) {
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

    private boolean outOfRange(GameSetting gameSetting, int remain) {
        if (remain >= gameSetting.GAME_NUMBER_RANGE_OVER && remain <= gameSetting.GAME_NUMBER_RANGE_UNDER) return false;
        else return true;
    }

    private void numberToPerNumber(GameSetting gameSetting) {
        String num = String.valueOf(number);
        for (int i = 0; i < gameSetting.GAME_NUMBER_CNT; i++) {
            my.add(num.charAt(i) - '0');
        }
    }

    private void judgeInputNumber(GameSetting gameSetting, List<Integer> computer) {
        compareInputNumber(gameSetting, computer);
        printCollectNumber();
        checkAllStrike(gameSetting);
    }

    private void checkAllStrike(GameSetting gameSetting) {
        if (strike == gameSetting.GAME_NUMBER_CNT) {
            isCorrect = true;
            printFinishPhrase(gameSetting);
        }
    }

    private void printFinishPhrase(GameSetting gameSetting) {
        System.out.println(gameSetting.GAME_NUMBER_CNT+InNotice.finishPhrase);
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

    private void compareInputNumber(GameSetting gameSetting, List<Integer> computer) {
        for (int i = 0; i < gameSetting.GAME_NUMBER_CNT; i++) {
            if (my.get(i) == computer.get(i)) {
                strike++;
            }
            else {
                if (computer.contains(my.get(i))) ball++;
            }
        }
    }
}
