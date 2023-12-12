package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {

    @DisplayName("잘못된 입력이 들어오면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"asd", "012", "111", "1 2 3", "1234", " "})
    public void testConstructor(String input) {
        assertThatThrownBy(() -> new Computer(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정답인 getScore 케이스")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "147"})
    public void testGetScores(String input) {
        assertThat(new Computer(input).getScore(input).isWon()).isEqualTo(true);
    }

    @Test
    public void testGetScore() {
        Computer computer = new Computer("123");
        assertThat(computer.getScore("789").getBall()).isEqualTo(0);
        assertThat(computer.getScore("789").getStrike()).isEqualTo(0);
        assertThat(computer.getScore("891").getBall()).isEqualTo(1);
        assertThat(computer.getScore("189").getStrike()).isEqualTo(1);
    }
}