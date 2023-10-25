package baseball.gameProcess;

import baseball.GameRole;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InProcess {
    private int number;
    private List<Integer> my;
    private List<Integer> computer;
    private int ball;
    private int strike;
    private boolean isCorrect;

    public InProcess(GameRole gameRole, List<Integer> computer) throws Exception{
        try {
            initVariables(computer);

            printInputNumberPhrase();
            inputNumber();
            checkInputNumber(gameRole);

            judgeInputNumber(gameRole, computer);
        } catch(Exception e) {
            throw e;
        }
    }

    public boolean isNumberCorrect() {
        return isCorrect;
    }

    private void initVariables(List<Integer> computer) {
        number = 0;
        my = new ArrayList<>();
        this.computer = computer;
        isCorrect = false;
        ball = 0;
        strike = 0;
    }

    private void printInputNumberPhrase() {
        System.out.print(InNotice.inputNumberPhrase);
    }

    private void inputNumber() {
        try {
            number = Integer.parseInt(readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputNumber(GameRole gameRole) {
        try {
            checkNumberThree(gameRole);
            checkNumberOneToNineDifferent(gameRole);
            numberToList(gameRole);
        } catch (Exception e) {
            throw e;
        }
    }

    private void checkNumberThree(GameRole gameRole) {
        if (String.valueOf(number).length() != gameRole.GAME_NUMBER_CNT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberOneToNineDifferent(GameRole gameRole) {
        boolean[] exist = new boolean[gameRole.GAME_NUMBER_RANGE_UNDER+1];
        int share = number;
        int remain;

        for (int i = 0; i < gameRole.GAME_NUMBER_CNT; i++) {
            remain = share % 10;
            share /= 10;

            if (remain == 0 || exist[remain]) {
                throw new IllegalArgumentException();
            }
            exist[remain] = true;
        }
    }

    private void numberToList(GameRole gameRole) {
        my = new ArrayList<>();

        String num = String.valueOf(number);
        for (int i = 0; i < gameRole.GAME_NUMBER_CNT; i++) {
            my.add(num.charAt(i)-'0');
        }
    }

    private void judgeInputNumber(GameRole gameRole, List<Integer> computer) {
        compareInputNumber(gameRole, computer);
        printCollectNumber();
        checkAllStrike(gameRole);
    }

    public void checkAllStrike(GameRole gameRole) {
        if (strike == gameRole.GAME_NUMBER_CNT) {
            isCorrect = true;
            printFinishPhrase(gameRole);
        }
    }

    public void printFinishPhrase(GameRole gameRole) {
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
