package baseball.Controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Baseball;
import baseball.utils.Utils;
import java.util.List;

public class GameRunner {
    private final Baseball baseball;
    public GameRunner(Baseball baseball) {
        this.baseball = baseball;
    }
}