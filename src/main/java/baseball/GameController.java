package baseball;
import java.util.List;

import baseball.dto.Result;
import baseball.global.Announcement;
import baseball.global.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public static final int INPUT_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int GAME_AGAIN_CODE = 1;
    public static final int GAME_TERMINATE_CODE = 2;

    // 입력 받고 올바른 입력인지 확인
    public static String getInGameInput() {
        System.out.print(Announcement.IN_GAME);
        return InputValidator.inGameInput(Console.readLine());
    }

    // 받은 입력의 결과 기록
    public static Result recordResult(String input, List<Character> answer) {
        Result result = new Result();
        for (int i = 0; i < INPUT_LENGTH; ++i) {
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
        if (result.getStrike() == INPUT_LENGTH) {
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
