package baseball;

import java.util.List;

import baseball.dto.Result;
import baseball.global.Announcement;
import baseball.global.util.RandomUtil;

public class Game extends GameController {

    private List<Character> answer;
    private boolean terminate;

    Game() {
        System.out.println(Announcement.GAME_START);
        this.terminate = false;
    }

    // 게임 진행
    public void playGame() {
        this.answer = RandomUtil.randomNumber();

        Result result = new Result();
        // 정답이 아닌 동안 계속 게임 진행하기
        while (!isWin(result)) {
            String input = getInGameInput();
        }
    }
}
