package baseball;
import java.util.List;

import baseball.global.Announcement;

public class Game extends GameController {

    private List<Character> answer;
    private boolean terminate;

    Game() {
        System.out.println(Announcement.GAME_START);
        this.terminate = false;
    }
}
