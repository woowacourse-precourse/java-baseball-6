package baseball.core;

import static org.mockito.Mockito.mock;

import baseball.core.participant.Player;
import baseball.exception.IllegalCountException;
import baseball.exception.IllegalRangeException;
import baseball.exception.IllegalTypeException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void basicNumberPicTest() {
        //if
        NumberPicker numberPicker = new NumberPicker();
        String rawData = "1 2 3";

        //when
        Player player = Player.createPlayer(numberPicker);
        List<Integer> integers = player.pickNumber(rawData);

        //then
        Assertions.assertThat(integers).size().isEqualTo(3);
        Assertions.assertThat(integers).contains(1,2,3);

        Assertions.assertThatThrownBy(()->player.pickNumber("11 22 33"))
                .isInstanceOf(IllegalRangeException.class);
        Assertions.assertThatThrownBy(() -> player.pickNumber("1 2 3 4 5"))
                .isInstanceOf(IllegalCountException.class);
        Assertions.assertThatThrownBy(() -> player.pickNumber("s 2 3"))
            .isInstanceOf(IllegalTypeException.class);
    }

}