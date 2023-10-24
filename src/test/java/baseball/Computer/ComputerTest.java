package baseball.Computer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer = new Computer();
    List<Integer> list = computer.answer;


    @Test
    @BeforeEach
    void 세개의_숫자_생성_테스트() {

        //when
        computer.generateNum();

        //then
        Assertions.assertThat(list.size()).isEqualTo(3);

        list.clear();


    }

    @Test
    void 올바른_범위인지_확인() {

        Assertions.assertThat(list.stream().allMatch(c -> c > 0 && c < 10)).isTrue();
    }

    @Test
    void 서로_다른수_테스트() {

        //when
        computer.generateNum();

        //then
        Assertions.assertThat(list.get(0)).isNotEqualTo(list.get(1));
        Assertions.assertThat(list.get(1)).isNotEqualTo(list.get(2));
        Assertions.assertThat(list.get(0)).isNotEqualTo(list.get(2));


    }
}