package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {

    @Test
    @DisplayName("컴퓨터 숫자 생성 완료")
    void 컴퓨터_숫자_생성_확인() throws Exception {
        //given
        ComputerNumber computerNumber = new ComputerNumber();
        //when
        List<Integer> number = computerNumber.getNumber();
        boolean empty = number.isEmpty();
        long count = number.stream().distinct().count();
        boolean contains = number.contains(0);
        //then
        assertThat(empty).isEqualTo(false);
        assertThat(number.size()).isEqualTo(3);
        assertThat(count).isEqualTo(3);
        assertThat(contains).isEqualTo(false);


    }

}