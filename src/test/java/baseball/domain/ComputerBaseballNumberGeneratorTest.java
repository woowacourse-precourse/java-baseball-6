package baseball.domain;

import baseball.infra.ComputerBaseballNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerBaseballNumberGeneratorTest {

    private BaseballNumberGenerator baseballNumberGenerator = new ComputerBaseballNumberGenerator();

    @Test
    @DisplayName("중복되지 않은 숫자 3자리 수 생성하는 지 테스트")
    public void testMakeNonDuplicate3Numbers () {
        BaseballNumber baseball = new BaseballNumber(baseballNumberGenerator);

        Assertions.assertEquals(3, baseball.size());
        Assertions.assertFalse(isDuplicate(baseball));
    }

    private boolean isDuplicate(BaseballNumber baseballNumbers) {
        for (int i = 0; i < baseballNumbers.size(); i++) {
            for (int j = i + 1; j < baseballNumbers.size(); j ++) {
                if (baseballNumbers.getBaseballNumber().get(i) == baseballNumbers.getBaseballNumber().get(j))
                    return true;
            }
        }

        return false;
    }

}
