package racingcar.domain.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SetNumberGeneratorTest {
    @Test
    void 설정_숫자_생성_테스트1() {
        int setNumber = 8;

        NumberGenerator setNumberGenerator = new SetNumberGenerator(setNumber);

        assertThat(setNumberGenerator.generate()).isEqualTo(setNumber);
    }
}
