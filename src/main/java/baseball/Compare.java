package baseball;

import static baseball.Application.COUNT_3;

public class Compare {

    public static int comp(String input, String answer) {

        int strike = 0, ball = 0;

        for (int i = 0; i < COUNT_3; i++) {
            if (answer.contains(Character.toString(input.charAt(i)))) {
                ball++;
            }
        }
        for (int i = 0; i < COUNT_3; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strike++;
            }
        }

        ball -= strike;

        return compResult(ball, strike);
    }

    private static int compResult(int ball, int strike) {

        if (strike == COUNT_3) {
            System.out.println("3스트라이크\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return 1;
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return 0;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }

        return 0;

    }
}
