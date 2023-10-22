package baseball.game_manager;

import baseball.GameManager;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayGameTest extends NsTest {

    private int strikeCount;

    @Test
    void 입력한_숫자의_strike_개수가_몇개인지를_반환합니다() {
        // when
        run();

        // then
        assertThat(strikeCount).isEqualTo(1);
    }

    @Override
    public void runMain() {
        List<Integer> computerNumber = new ArrayList<>();
        List<Integer> guessNumber = new ArrayList<>();

        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(7);

        guessNumber.add(1);
        guessNumber.add(7);
        guessNumber.add(2);

        GameManager gameManager = GameManager.initGame();
        strikeCount = gameManager.playGame(computerNumber, guessNumber);
    }
}
