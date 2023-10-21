package baseball.player;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 사용자_입력() {
        Player player = new Player();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> playerNum = player.enter();
        System.out.println(playerNum);

        List<Integer> expected = List.of(1,2,3);
        assertThat(expected).isEqualTo(playerNum);
    }
}
