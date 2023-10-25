package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @Test
    @DisplayName("중복된 숫자가 있을땐 오류가 발생해야 한다.")
    void 중복_검사(){
        //given
        List<Integer> testBalls=new ArrayList<>(Arrays.asList(1,2,2));

        //when
        Balls balls;

        //then
        Assertions.assertThatThrownBy(()->new Balls(testBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("입력된 숫자의 사이즈가 3이 아니면 오류가 발생해야 한다.")
    void 사이즈_검사(){
        //given
        List<Integer> testBalls=new ArrayList<>(Arrays.asList(1,2,3,4));

        //when
        Balls balls;

        //then
        Assertions.assertThatThrownBy(()->new Balls(testBalls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개");
    }

}