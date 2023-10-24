package baseball;

import java.util.List;

import baseball.dto.Result;
import baseball.global.Announcement;
import baseball.global.util.RandomUtil;

public class Game {

    public static final int INPUT_LENGTH = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int GAME_AGAIN_CODE = 1;
    public static final int GAME_TERMINATE_CODE = 2;

    private List<Character> answer;
    private int terminate;

    Game() {
        System.out.println(Announcement.GAME_START);
        this.terminate = GAME_AGAIN_CODE;
    }

    // 게임 진행
    public void playGame() {
        this.answer = RandomUtil.randomNumber();

        Result result = new Result();
        while (!GameController.isWin(result)) {
            String input = GameController.getInGameInput();
            result = GameController.recordResult(input, answer);
            GameController.printResult(result);
        }

        System.out.println(Announcement.GAME_WIN);

        this.terminate = GameController.getTerminateInput();
    }

    public boolean isTerminate() {
        return this.terminate == GAME_TERMINATE_CODE;
    }
}
