package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserNumTest {
    @DisplayName("컴퓨터 3자리 수 생성 테스트")
    @Test
    public void userNumTest() {
        // given
        UserNum userNum = new UserNum();
        String number = "123";

        // when
        List<String> userNumList = userNum.userNum();

        // then
        System.out.println(userNumList);
        ssertThat(userNumList.size()).isEqualTo(3);
    }
}
