package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {

    public static void stop() {
//        System.exit(0);
        return;
    }


    public static List<Integer> ready(SetNumV3 object) {
        return object.setNum();
    }

    public static String playAndResult(List<Integer> computerNums, List<Integer> playerNums) {

        int strike = 0;
        int ball = 0;

        // 스트라이크 판정
        for (int i = 0; i < 3; i++) {
            if (computerNums.get(i) == playerNums.get(i)) {
                strike++;
            }
        }
        // 볼 판정
        for (int i = 0; i < 3; i++) {
            if (computerNums.contains(playerNums.get(i))) {
                if (computerNums.get(i) != playerNums.get(i)) {
                    ball++;
                }
            }
        }

        String printStrike = strike + "스트라이크";
        String printBall = ball + "볼";
        String printNotThing = "낫싱";
        String result = "";

        // 최종 결과 및 낫싱 판정
        if (strike == 0 && ball == 0) {
            result = printNotThing;
        } else {
            if (ball > 0) {
                result += printBall;
            }
            if (strike > 0) {
                if (ball > 0) {
                    result += " ";
                }
                result += printStrike;
            }
        }



        return result;
    }
    public static String playOrNot() {
        try {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if ("1".equals(input) || "2".equals(input)) {
                return input;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            GameManager.stop();
            return "";
        }
    }
}