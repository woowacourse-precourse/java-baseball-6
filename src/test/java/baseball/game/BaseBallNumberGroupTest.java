package baseball.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseBallNumberGroupTest {
    @Test
    void 숫자_야구_개수가_초기_개수보다_적은_경우_IllegalArgumentException_예외() {
        final List<Integer> baseBallNumbers = new ArrayList<>();

        for (int i = 0; i < GameConstants.SIZE_RANDOM_NUMBER - 1; i++) {
            baseBallNumbers.add(i + 1);
        }

        assertThatThrownBy(() -> new BaseBallNumberGroup(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_야구_개수가_초기_개수보다_많은_경우_IllegalArgumentException_예외() {
        final List<Integer> baseBallNumbers = new ArrayList<>();

        for (int i = 0; i < GameConstants.SIZE_RANDOM_NUMBER + 1; i++) {
            baseBallNumbers.add(i + 1);
        }

        assertThatThrownBy(() -> new BaseBallNumberGroup(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_야구가_서로_중복되면_예외() {
        final List<Integer> baseBallNumbers = new ArrayList<>();

        for (int i = 0; i < GameConstants.SIZE_RANDOM_NUMBER; i++) {
            baseBallNumbers.add(1);
        }

        assertThatThrownBy(() -> new BaseBallNumberGroup(baseBallNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
