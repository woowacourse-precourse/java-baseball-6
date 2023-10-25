package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.result.Status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatusTest {
    @Test
    @DisplayName("Getter가 작동한다.")
    public void getter_가_작동한다() {
        // given
        Status status = new Status(2);

        // when
        int count = status.count();

        // then
        assertThat(count).isEqualTo(2);
    }
}
