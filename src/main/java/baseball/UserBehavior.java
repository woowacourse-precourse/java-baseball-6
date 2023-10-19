package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserBehavior {
    private final List<Integer> computerNumbers;
    private int strike;
    private int ball;

    public UserBehavior(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void input() {
        strike = 0;
        ball = 0;

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        int first = Integer.parseInt(inputNumber.substring(0, 1));
        check(0, first);
        int second = Integer.parseInt(inputNumber.substring(1, 2));
        check(1, second);
        int third = Integer.parseInt(inputNumber.substring(2, 3));
        check(2, third);
    }

    public void check(int index, int number) {
        if (computerNumbers.get(index) == number) {
            strike++;
            return;
        }
        if (computerNumbers.contains(number)) {
            ball++;
        }
    }
}
