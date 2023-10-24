package baseball;

import java.util.List;

import baseball.dto.Result;
import baseball.global.Announcement;
import baseball.global.util.RandomUtil;

public class Game extends GameController {

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
        while (!isWin(result)) {
            String input = getInGameInput();
            result = recordResult(input, answer);
            printResult(result);
        }

        System.out.println(Announcement.GAME_WIN);

        this.terminate = getTerminateInput();
    }

    public boolean isTerminate() {
        return this.terminate == GAME_TERMINATE_CODE;
    }
}
