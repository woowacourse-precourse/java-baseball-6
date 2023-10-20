package client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OptionTest {

    @Test
    @DisplayName("enum valueOf 테스트")
    void enumTest01() {
        //given
        String name = "CONTINUE";

        //when
        Option option = Option.valueOf(name);

        //then
        assertThat(option).isEqualTo(Option.CONTINUE);
    }

    @Test
    @DisplayName("enum values 테스트")
    void enumTest02() {
        Option[] options = Option.values();
        for (Option o : options) {
            System.out.println("o = " + o);
        }
    }

    @Test
    @DisplayName("enum values stream 테스트")
    void enumTest03() {
        // given
        Option[] options = Option.values();
        String status = "1";

        // when
        Option option = Arrays.stream(options)
                .filter(o -> status.equals(o.getStatus()))
                .findFirst()
                .orElse(null);

        //then
        assertThat(option).isEqualTo(Option.CONTINUE);
    }

    @Test
    @DisplayName("enum 내부 메소드 활용하여 원하는 상수 찾기")
    void enumTest04() {
        // given
        String status = "2";

        //when
        Option option = Option.findByStatus(status);

        //then
        assertThat(option).isEqualTo(Option.FINISH);
    }

    @Test
    @DisplayName("enum 내부 메소드를 활용하여, 상태 확인하기")
    void enumTest05() {
        // given
        String continueStatus = "1";
        String finishStatus = "2";

        //when
        boolean mustBeFalse = Option.findByStatus(continueStatus).isFinish();
        boolean mustBeTrue = Option.findByStatus(finishStatus).isFinish();

        //then
        assertThat(mustBeFalse).isEqualTo(false);
        assertThat(mustBeTrue).isEqualTo(true);
    }
}