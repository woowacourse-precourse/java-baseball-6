package baseball.service;

import baseball.domain.Com;
import baseball.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("3 스트라이크 여부 확인 테스트")
    @Test
    void ThreeStrikeTest(){
        String value="123";
        //given
        User user=new User(value);

        //when
        user.compare(value);

        //then
        assertThat(user.isThreeStrike()).isTrue();
    }

    @DisplayName("1번 기능(사용자 값 입력)의 예외처리 기능")
    @ParameterizedTest
    @ValueSource(strings={"1234","12","1a2","zxc","ab2","2ab","112","111","344"})
    void 사용자_입력_기능_예외처리_1번(String values){
        //given
        Validation validation=new Validation();

        //when & then
        asserThat(validation.playUserInput(values)).isFalse();
    }
}
