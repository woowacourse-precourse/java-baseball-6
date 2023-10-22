package baseball.object;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static String number;
    private static int ball = 0;
    private static int strike = 0;

    public static void generateNumber() {
        List<Integer> list = new ArrayList<>();

        int cnt = 3;
        while(cnt-- > 0) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!list.contains(randomNumber))
                list.add(randomNumber);
        }

        number = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void compareNumber(String answer) {
        ball = 0;
        strike = 0;

        for(int i = 0; i < number.length(); i++) {
            if(answer.contains(String.valueOf(number.charAt(i)))) {
                if(answer.charAt(i) == number.charAt(i))
                    strike++;
                else
                    ball++;
            }
        }
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
