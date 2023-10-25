package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static baseball.exception.ErrorMessage.INVALID_BALLS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성")
    @Test
    public void createBalls_randomNums() throws Exception {
        //given
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        List<Integer> randomNumbers = numbersGenerator.createRandomNumbers();

        //when
        Balls balls = new Balls(randomNumbers);
        List<Ball> ballList = randomNumbers.stream()
                .map((num) -> new Ball(num))
                .toList();
        //then
        assertThat(balls.getBalls()).containsExactlyElementsOf(ballList);
    }

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성 예외 : 숫자가 3개가 아닌 경우 예외 발생")
    @Test
    public void createBalls_randomNums_exception_sizeNotMatch() throws Exception {
        //given
        List<Integer> IllegalList = List.of(1, 2);
        //when, then
        assertThatThrownBy(() -> new Balls(IllegalList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_BALLS_SIZE.toString());
    }

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성 예외 : null 값이 주어진 경우 예외 발생")
    @Test
    public void createBalls_randomNums_exception_nullPointer() throws Exception {
        //given
        List<Integer> IllegalList = null;

        //when, then
        assertThatThrownBy(() -> new Balls(IllegalList))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("입력받은 값으로 Balls 초기화")
    @Test
    public void createBalls_input() throws Exception {
        //given
        Balls balls = new Balls(InputNumbers.of("123"));
        List<Ball> ballList = List.of(new Ball(1), new Ball(2), new Ball(3));

        //when, then
        assertThat(balls.getBalls()).containsExactlyElementsOf(ballList);
    }

    @DisplayName("Balls끼리 비교 : 3스트라이크")
    @ParameterizedTest
    @CsvSource({"123,123", "345,345", "496,496"})
    public void compareBallWithBalls_3STRIKE(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("3스트라이크");
    }

    @DisplayName("Balls끼리 비교 : 2스트라이크")
    @ParameterizedTest
    @CsvSource({"123,124", "312,412", "964,974"})
    public void compareBallWithBalls_2STRIKE(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("2스트라이크");
    }

    @DisplayName("Balls끼리 비교 : 1볼 1스트라이크")
    @ParameterizedTest
    @CsvSource({"345,374", "123,325", "912,923"})
    public void compareBallWithBalls_1STRIKE_1BALL(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("1볼 1스트라이크");
    }

    @DisplayName("Balls끼리 비교 : 2볼 1스트라이크")
    @ParameterizedTest
    @CsvSource({"123,132", "312,321", "965,956"})
    public void compareBallWithBalls_1STRIKE_2BALL(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("2볼 1스트라이크");
    }

    @DisplayName("Balls끼리 비교 : 1볼")
    @ParameterizedTest
    @CsvSource({"123,561", "312,296", "965,257"})
    public void compareBallWithBalls_1BALL(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("1볼");
    }

    @DisplayName("Balls끼리 비교 : 낫싱")
    @ParameterizedTest
    @CsvSource({"123,567", "312,456", "965,347"})
    public void compareBallWithBalls_NOTHING(String nums1, String nums2) throws Exception {
        //given
        Balls balls1 = new Balls(InputNumbers.of(nums1));
        Balls balls2 = new Balls(InputNumbers.of(nums2));

        //when
        PlayResult playResult = balls1.checkBalls(balls2);

        //then
        assertThat(playResult.toString()).isEqualTo("낫싱");
    }
}
