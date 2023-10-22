package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserNumTest {
    @DisplayName("사용지 3자리 수 입력 테스트")
    @Test
    public void userNumTest() {
        // given
        UserNum user = new UserNum();
        String userNum = "123";

        // when
        List<String> userNumList = user.getUserNum();

        // then
        System.out.println(userNumList);
    }
}