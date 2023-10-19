package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("User는 서로 다른 임의의 3자리 수를 관리하는 Baseball(Modifiable)을 가진다")
    void applyBaseball() {
        // given
        final User user = new User();

        /* apply first chance */
        final List<Integer> balls1 = List.of(1, 5, 9);
        user.applyBaseball(balls1);

        assertThat(user.getBaseball()).containsExactlyElementsOf(balls1);

        /* apply second chance */
        final List<Integer> balls2 = List.of(2, 3, 7);
        user.applyBaseball(balls2);

        assertThat(user.getBaseball()).containsExactlyElementsOf(balls2);
    }
}
