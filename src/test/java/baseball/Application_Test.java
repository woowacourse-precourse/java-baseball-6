package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Application_Test {
    Compare compare;

    @BeforeEach
    void Init(){
        compare = new Compare();
    }

    @Test
    @DisplayName("3볼 테스트")
    void check_ball(){
        assertThat("3볼").isEqualTo(compare.Classification(Arrays.asList(3,1,2), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void check_strike(){
        assertThat("3스트라이크").isEqualTo(compare.Classification(Arrays.asList(1,2,3), Arrays.asList(1,2,3)));
    }

    @Test
    @DisplayName("낫싱 테스트")
    void check_nothing(){
        assertThat("낫싱").isEqualTo(compare.Classification(Arrays.asList(1,2,3), Arrays.asList(4,5,6)));
    }
}