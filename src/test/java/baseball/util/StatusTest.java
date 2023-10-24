package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    @DisplayName("음수의 값일 경우 IllegalArgumentException을 반환한다.")
    public void 음수의_값일_경우_IllegalArgumentException을_반환한다() {
        // given
        Status status = new Status(-1);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> status.checkValidate());
    }

    @Test
    @DisplayName("4 이상의 값일 경우 IllegalArgumentException을 반환한다.")
    public void 범위_밖의_값일_경우_IllegalArgumentException을_반환한다() {
        // given
        Status status = new Status(5);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> status.checkValidate());
    }
}
