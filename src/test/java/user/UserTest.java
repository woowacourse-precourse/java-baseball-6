package user;

import baseball.Application;
import baseball.Balls;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class UserTest {

    @Test
    @DisplayName("사용자의 숫자가 정확히 입력되었는지 확인")
    void 입력_테스트(){
        //given
        String input="123";
        Balls balls=new Balls(Arrays.asList(1,2,3));
        User user=new User();

        //when
        Balls userBalls=user.makeUserNumber(input);

        //then
        Assertions.assertThat(userBalls.getBalls()).isEqualTo(balls.getBalls());
    }


}