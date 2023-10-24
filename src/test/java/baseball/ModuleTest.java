package baseball;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class ModuleTest {

    @Test
    void checkResult() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> b = List.of(1, 3, 2);
        Application.Result result = Application.checkResult(a, b);

        Assertions.assertThat(result.strike).isEqualTo(1);
        Assertions.assertThat(result.ball).isEqualTo(2);
    }
}