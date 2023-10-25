package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void Restart의_from_메서드는_매개변수가_1또는_2가_아닌경우_IllegalArgumentException가_발생한다(int command) {
        assertThatThrownBy(() -> Restart.from(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void Restart의_from_메서드는_매개변수가_1또는_2인_경우_Restart_객체를_생성한다(int command) {
        assertThat(Restart.from(command)).isInstanceOf(Restart.class);
    }
}
