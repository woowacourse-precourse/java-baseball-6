package baseball;

import java.util.List;

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
    }
}
