package baseball.service;

import baseball.domain.Com;
import baseball.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GameServiceTest {

    @DisplayName("값 비교 테스트")
    @Test
    void ValueCompareTest(){
        //given
        Com com=new Com("713");//컴퓨터의 값
        User user=new User("123");//사용자의 값
        //when
        user.compare(com.value);
        //then
        assertThat(user.strike).isEqualTo(1);
        assertThat(user.ball).isEqualTo(1);

    }
}
