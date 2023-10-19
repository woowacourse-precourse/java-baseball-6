package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseBallNumberGroupTest {
    @Test
    void 숫자_야구_개수가_3개가_아니면_예외_3개보다_적은_경우() {
        assertThatThrownBy(() -> new BaseBallNumberGroup(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_야구_개수가_3개가_아니면_예외_3개보다_많은_경우() {
        assertThatThrownBy(() -> new BaseBallNumberGroup(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_야구가_서로_중복되면_예외() {
        assertThatThrownBy(() -> new BaseBallNumberGroup(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
