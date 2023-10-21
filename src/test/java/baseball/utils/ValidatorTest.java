package baseball.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @Test
    void 중복된_숫자_확인(){
        Validator validator = new Validator();
        boolean duplicateFlag = true;

        assertThat(validator.isDuplicateNumber("122"))
                .isEqualTo(duplicateFlag);
    }
}