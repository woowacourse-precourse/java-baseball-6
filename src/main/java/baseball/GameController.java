package baseball;
import java.util.List;

import baseball.dto.Result;
import baseball.global.Announcement;
import baseball.global.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    // 입력 받고 올바른 입력인지 확인
    public static String getInGameInput() {
        System.out.print(Announcement.IN_GAME);
        return InputValidator.inGameInput(Console.readLine());
    }

    // 받은 입력의 결과 기록
    public static Result recordResult(String input, List<Character> answer) {
        Result result = new Result();
        for (int i = 0; i < Game.INPUT_LENGTH; ++i) {
            char target = input.charAt(i);
            if (answer.contains(target)) {
                if (answer.get(i) == target) {
                    result.increaseStrike();
                } else {
                    result.increaseBall();
                }
            }
        }

        return result;
    }

    // 결과 출력
    public static void printResult(Result result) {
        int ball = result.getBall();
        int strike = result.getStrike();

        if (ball != 0 && strike != 0) {
            System.out.println(Announcement.ballAndStrike(ball, strike));
        } else if (ball != 0) {
            System.out.println(Announcement.ball(ball));
        } else if (strike != 0) {
            System.out.println(Announcement.strike(strike));
        } else {
            System.out.println(Announcement.nothing());
        }
    }

    public static boolean isWin(Result result) {
        if (result.getStrike() == Game.INPUT_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    // 게임 종료 여부 체크
    public static Integer getTerminateInput() {
        System.out.println(Announcement.GAME_TERMINATE);
        return InputValidator.terminateInput(Console.readLine());
    }
}
