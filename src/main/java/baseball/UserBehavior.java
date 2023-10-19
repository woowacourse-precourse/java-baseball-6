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

        while (result()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        input();
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
    public boolean result() {
        if (strike == 3) {
            System.out.println(strike+"스트라이크");
            return true;
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball == 0) {
            System.out.println(strike+"스트라이크");
            return false;
        }
        if (strike == 0) {
            System.out.println(ball+"볼");
            return false;
        }
        System.out.println(ball+"볼 "+strike+"스트라이크");
        return false;
    }
}
