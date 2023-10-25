package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;


class UserTest {
    @DisplayName("")
    @Test
    void userGetNumTest() {
        //given
        User user = new User();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //when
        //then
        assertThat(user.getNum()).isEqualTo(input);
    }
}