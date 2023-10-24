package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitLineTest {

    @Test
    @DisplayName("플레이어가 입력한 문장 길이와 생성된 리스트 길이가 같아야 한다.")
    void is_same_player_string_length_to_generated_list_length() {
        // given
        String testPlayer = "123";

        // when & then
        assertEquals(testPlayer.length(), new SplitLine().splitLine(testPlayer).size());
    }
}