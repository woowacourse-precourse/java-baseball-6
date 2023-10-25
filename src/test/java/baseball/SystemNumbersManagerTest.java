package baseball;

import baseball.domain.SystemNumbersManager;
import baseball.util.RegularExpression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SystemNumbersManagerTest {

    private final List<Integer> systemList = SystemNumbersManager.createSystemNumbers();
    
    @Test
    void 생성된_시스템_숫자_리스트_크기_확인() {
        Assertions.assertThat(systemList.size()).isEqualTo(3);
    }

    @Test
    void 생성된_시스템_숫자가_숫자인지_확인() {
        Assertions.assertThat(systemList.stream().allMatch(v -> Integer.toString(v).matches(RegularExpression.NUMBER_REGEX))).isTrue();
    }

    @Test
    void 생성된_시스템_숫자_중복_확인() {
        Assertions.assertThat(systemList.size() == systemList.stream().distinct().count()).isTrue();
    }

    @Test
    void 생성된_시스템_숫자의_범위_확인() {
        Assertions.assertThat(systemList.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }
}
