package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

class ViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); //OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); //생성한 OutputStream으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @MethodSource("providePrintCondition")
    @ParameterizedTest
    void 힌트_형식에_맞게_출력(int strike, int ball, String answer) {

        //when
        View.printHint(strike, ball);

        //then
        Assertions.assertThat(outputMessage.toString()).isEqualTo(answer);
    }

    private static Stream<Arguments> providePrintCondition() {
        return Stream.of(
                Arguments.of(0, 0, "낫싱\n"),
                Arguments.of(1, 0, "1스트라이크\n"),
                Arguments.of(2, 0, "2스트라이크\n"),
                Arguments.of(3, 0, "3스트라이크\n"),
                Arguments.of(0, 1, "1볼 \n"),
                Arguments.of(0, 2, "2볼 \n"),
                Arguments.of(1, 2, "2볼 1스트라이크\n"),
                Arguments.of(2, 1, "1볼 2스트라이크\n")
        );
    }
}