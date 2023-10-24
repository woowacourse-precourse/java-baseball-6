package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class UserTest {

    User user = new User();

    /*@Test
    void 길이가3이아닐시_예외() {
        //given
        String input = "1234";

        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(() -> user.guessAnswer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된숫자포함시_예외() {
        //given
        String input = "111";

        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(() -> user.guessAnswer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 지정숫자가아닐시_예외() {
        //given
        String input = "012";

        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(() -> user.guessAnswer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 그외문자포함시_예외() {
        //given
        String input = "X12";

        //when
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(() -> user.guessAnswer()).isInstanceOf(IllegalArgumentException.class);
    }*/
}