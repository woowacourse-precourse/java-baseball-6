package baseball;

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

    // 안내 문구 출력 후 입력 받기
    private static String getInputWithAnnounce(String announcement) {
        System.out.print(announcement);
        return Console.readLine();
    }

    // 입력 받고 올바른 입력인지 확인
    public static String getInGameInput() {
        String input = getInputWithAnnounce(Announcement.IN_GAME);
        return InputValidator.inGameInput(input);
    }

    public static boolean isWin(Result result) {
        if (result.getStrike() == INPUT_LENGTH) {
            return true;
        } else {
            return false;
        }
    }
}
