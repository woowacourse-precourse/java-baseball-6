package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final List<Integer> computerNumber;
    private List<Integer> userNumber;

    public Game(Computer computer) {
        this.computerNumber = computer.getComputer();
    }

    public void start() {
        while (true) {
            if (playOneRound()) break;
        }
    }

    private boolean playOneRound() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        User user = new User(number);
        userNumber = user.getUser();
        return compareNumbers();
    }

    public boolean compareNumbers() {
        int ball = 0;
        int strike = 0;

        for(int i = 0; i < 3; i++ ){
            strike += getStrikeCount(i);
            ball += getBallCount(i);
        }

        printResult(ball, strike);

        if (strike == 3) {
            return true;
        }
        return false;
    }

    private static void printResult(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }

    private int getStrikeCount(int index) {
        if (computerNumber.get(index) == userNumber.get(index)) {
            return 1;
        }
        return 0;
    }

    private int getBallCount(int index) {
        int findIdx = userNumber.indexOf(computerNumber.get(index));
        if ( findIdx != -1 && index != findIdx) {
            return 1;
        }
        return 0;
    }
}
