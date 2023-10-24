//package baseball.util;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class ResultTest {
//    static ByteArrayOutputStream outContent;
//
//    @BeforeEach
//    void beforeEach() {
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @Test
//    @DisplayName("범위밖이라면_IllegalArgumentException을 반환한다.")
//    public void 범위밖이라면_IllegalArgumentException을_반환한다() {
//        // given
//        Result result = new Result(new Status(-1), new Status(4));
//
//        // when & then
//        assertThrows(IllegalArgumentException.class, () -> result.checkValidate());
//    }
//
//    @Test
//    @DisplayName("낫싱일 경우 true를 반환한다.")
//    public void 낫싱일_경우_true를_반환한다() {
//        // given
//        Result result = new Result(new Status(0), new Status(0));
//
//        // when
//        boolean isNothing = result.checkNothing();
//
//        // then
//        assertThat(isNothing).isTrue();
//    }
//
//    @Test
//    @DisplayName("낫싱이 아닐 경우 false를 반환한다.")
//    public void 낫싱이_아닐_경우_false를_반환한다() {
//        // given
//        Result result = new Result(new Status(0), new Status(1));
//
//        // when
//        boolean isNothing = result.checkNothing();
//
//        // then
//        assertThat(isNothing).isFalse();
//    }
//
//    @Test
//    @DisplayName("3스트라이크일 경우 3스트라이크를 반환한다.")
//    public void 스트라이크3일_경우_3스트라이크를_반환한다() {
//        // given
//        Result result = new Result(new Status(0), new Status(3));
//
//        // when
//        result.printResult();
//
//        // then
//        String expectedOutput = "3스트라이크" + "\n";
//        assertThat(outContent.toString()).contains(expectedOutput);
//    }
//
//    @Test
//    @DisplayName("1볼 2스트라이크일 경우 1볼 2스트라이크를 반환한다.")
//    public void 볼1_스트라이크2일_경우_1볼_2스트라이크를_반환한다() {
//        // given
//        Result result = new Result(new Status(1), new Status(2));
//
//        // when
//        result.printResult();
//
//        // then
//        String expectedOutput = "1볼 2스트라이크" + "\n";
//        assertThat(outContent.toString()).contains(expectedOutput);
//    }
//
//    @Test
//    @DisplayName("3볼일 경우 3볼을 반환한다.")
//    public void 볼3일_경우_3볼을_반환한다() {
//        // given
//        Result result = new Result(new Status(3), new Status(0));
//
//        // when
//        result.printResult();
//
//        // then
//        String expectedOutput = "3볼" + "\n";
//        assertThat(outContent.toString()).contains(expectedOutput);
//    }
//}
