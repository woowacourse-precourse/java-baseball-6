package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class HostV2 {
    public static void stop() {
        return;
    }
    private static void call() {
        ComputerV2 computer = new ComputerV2();
        PlayerV2 player = new PlayerV2();
    }

    private static List ready(SetNumV2 object) {
        return object.setNum();
    }

    private String playAndResult(List<Integer> computerNums, List<Integer> playerNums) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int strike = 0;
        int ball = 0;
        String printStrike = strike + "스트라이크";
        String printBall = ball + "볼";
        String printNotThing = "낫싱";
        String result = "";

        // 스트라이크 판정
        for (int i = 0; i < 3; i++) {
            if(computerNums.get(i) == playerNums.get(i)){
                strike++;
            }
        }
        // 볼 판정
        for (int i = 0; i < 3; i++) {
            if (computerNums.contains(playerNums.get(i))){
                if (computerNums.get(i) != playerNums.get(i)) {
                    ball++;
                }
            }
        }

        // 최종 결과 및 낫싱 판정
        if (strike > 0 && ball > 0) {
            result += printStrike + " " + printBall;
        } else if (strike > 0 && ball == 0) {
            result += printStrike;
        } else if (strike == 0 && ball > 0) {
            result += printBall;
        } else {
            result += printNotThing;
        }

        return result;
    }
    // 재시작에서 막혔다.
    private static String playOrNot(String result) {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        return input;
    }
}
