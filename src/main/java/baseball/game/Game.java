package baseball.game;

import baseball.object.Computer;
import baseball.object.NumberLength;

import java.util.stream.IntStream;

public class Game {

    private static int ball = 0;
    private static int strike = 0;

    public static void compareNumber(String answer) {
        ball = 0;
        strike = 0;

        String number = Computer.getNumber();
        IntStream.range(0, NumberLength.LENGTH)
                .forEach(index -> {
                    if(answer.charAt(index) == number.charAt(index))
                        strike++;
                    else if(answer.contains(String.valueOf(number.charAt(index))))
                        ball++;
                });
    }

    public static boolean printResult() {
        if(strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        if(ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if(ball == 0)
            System.out.println(strike + "스트라이크");
        else if(strike == 0)
            System.out.println(ball + "볼");
        else
            System.out.println(ball + "볼 " + strike + "스트라이크");

        return false;
    }
}
