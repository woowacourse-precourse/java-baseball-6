package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballRandomNumberGeneratorTest {
    @Test
    void 컴퓨터_랜덤_생성된_숫자_사이즈_중복_테스트(){
        //given
        BaseballNumberGenerator baseballNumberGenerator = new BaseballRandomNumberGenerator();

        //when
        final List<Integer> case1 = baseballNumberGenerator.generate();
        final Set<Integer> case1Set = new HashSet<>(case1);

        //then
        assertThat(case1.contains(0)).isEqualTo(false);
        assertThat(case1.size() == 3).isEqualTo(true);
        assertThat(case1.size() == case1Set.size()).isEqualTo(true);

    }

}