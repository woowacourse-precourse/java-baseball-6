package baseball.model;

import baseball.model.player.Player;
import org.junit.jupiter.api.*;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerTest {

    Player player = new Player();


    @Test
    @Order(1)
    @DisplayName("사용자가 예상한 숫자를 저장한다.")
    void save_player_expected_number(){
        //given
        player.updateExpectedNumbers("123");

        //when
        List<Integer> expectedNumbers = player.getExpectedNumbers();

        //then
        assertThat(expectedNumbers).containsExactly(1,2,3);
    }

    @Test
    @Order(2)
    @DisplayName("사용자가 새로 예상한 숫자를 입력하면 원래 저장된 숫자에서 업데이트된다.")
    void save_player_new_expected_number(){
        //given
        player.updateExpectedNumbers("456");

        //when
        List<Integer> expectedNumbers = player.getExpectedNumbers();

        //then
        assertThat(expectedNumbers)
                .isNotIn(1,2,3)
                .containsExactly(4,5,6);
    }
}
