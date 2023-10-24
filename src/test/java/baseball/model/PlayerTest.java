package baseball.model;

import baseball.model.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("사용자가 예상한 숫자를 저장한다.")
    void save_player_expected_number(){
        //given
        Player player = new Player();
        player.updateExpectedNumbers("123");

        //when
        List<Integer> expectedNumbers = player.getExpectedNumbers();

        //then
        assertThat(expectedNumbers).containsExactly(1,2,3);
    }
}
