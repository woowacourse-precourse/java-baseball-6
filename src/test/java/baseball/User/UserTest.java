package baseball.User;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UserTest {

    private static User user = new User();

    @Test
    void 사용자_세가지값_입력판단() {
        //given
        String str = "1234";

        //when
        boolean check = user.checkthreeNum(str);
        //then
        assertThat(check).isFalse();

    }

    @Test
    void 사용자_서로다른값_판단() {
        //given
        String str = "133";

        //when
        boolean check = user.checkdifferentNum(str);
        //then
        assertThat(check).isFalse();

    }

    @Test
    void 사용자_입력범위_판단() {
        //given
        String str = "150";
        String str2 = "151";

        //when
        boolean check = user.checkRange(str);
        boolean check2 = user.checkRange(str2);

        //then
        assertThat(check).isFalse();
        assertThat(check2).isTrue();
    }
}