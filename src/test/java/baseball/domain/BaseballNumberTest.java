package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {


    @Test
    void validate_3개가_아닌_길이_확인(){
        assertThatThrownBy(() -> new BaseballNumber(List.of(1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void validate_숫자_중복_확인(){
        assertThatThrownBy(() -> new BaseballNumber(List.of(1,2,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_범위_밖의_숫자_입력_확인(){
        assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}