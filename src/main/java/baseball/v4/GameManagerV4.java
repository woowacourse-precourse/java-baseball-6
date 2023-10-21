package baseball.v4;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameManagerV4 {

    public static void playGame(ComputerV4 computer, ChallengerV4 challengerV4) {
        // 컴퓨터의 숫자 설정
        List<Integer> computerNums = computer.setNum();

        // 게임 결과 초기화
        String gameResult = "";

        // 3스트라이크가 아닐 때까지 반복
        while (!"3스트라이크".equals(gameResult)) {
            // 플레이어의 숫자 설정
            List<Integer> challengerNums = challengerV4.setNum();

            // 게임 결과 계산
            gameResult = playAndResult(computerNums, challengerNums);
            System.out.println(gameResult);
        }
    }
    public static String playAndResult(List<Integer> computerNums, List<Integer> challengerNums) {

        int strike = 0;
        int ball = 0;

        // 스트라이크 판정
        for (int i = 0; i < 3; i++) {
            if (computerNums.get(i) == challengerNums.get(i)) {
                strike++;
            }
        }
        // 볼 판정
        for (int i = 0; i < 3; i++) {
            if (computerNums.contains(challengerNums.get(i))) {
                if (computerNums.get(i) != challengerNums.get(i)) {
                    ball++;
                }
            }
        }

        // 최종 결과 및 낫싱 판정
        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball).append("볼");
        }

        if (strike > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(strike).append("스트라이크");
        }

        if (strike == 0 && ball == 0) {
            result.append("낫싱");
        }

        return result.toString();

    }

    public static boolean askContinue() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void stop() {
        return;
    }

}
