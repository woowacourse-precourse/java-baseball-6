package baseball.gameProcess;

import baseball.GameRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InProcess {
    private int number;
    private List<Integer> my;
    private List<Integer> computer;

    public InProcess(GameRole gameRole, List<Integer> computer) {
        initVariables(computer);

        printInputNumberPhrase();
        inputNumber();
        checkInputNumber(gameRole);

        judgeNumber(gameRole);
    }

    private void initVariables(List<Integer> computer) {
        number = 0;
        my = new ArrayList<>();
        this.computer = computer;
    }

    private void printInputNumberPhrase() {
        System.out.print(InNotice.inputNumberPhrase);
    }

    private void inputNumber() {
        Scanner sc = new Scanner(System.in);

        try {
            number = sc.nextInt();
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInputNumber(GameRole gameRole) {
        checkNumberThree(gameRole);
        checkNumberOneToNineDifferent(gameRole);
        numberToList(gameRole);
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

    private void judgeNumber(GameRole gameRole) {
        int ball = 0;
        int strike = 0;

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
