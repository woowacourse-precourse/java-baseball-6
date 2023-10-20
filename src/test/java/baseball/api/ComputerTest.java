package baseball.api;

import baseball.api.constants.ResponseFormatConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static baseball.api.constants.ResponseFormatConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private ByteArrayOutputStream outputStreamCaptor;

    @Test
    @DisplayName("1-9까지의 수를 3개 얻을 수 있다.")
    public void getResultCheckMatches() {
        // when
        String result = Computer.getResult();
        // then
        boolean matches = Pattern.matches("^[1-9]{3}$", result);
        assertAll(
                () -> assertEquals(result.length(), 3),
                () -> assertEquals(matches, true)
        );
    }

    @Test
    @DisplayName("result의 값은 중복된 값이 올 수 없다.")
    public void getResultDuplicateNumber() {
        // when
        String result = Computer.getResult();
        boolean hasDuplicateDigits = hasDuplicateDigits(result);
        // then
        assertAll(
                () -> assertEquals(result.length(), 3),
                () -> assertEquals(hasDuplicateDigits, true)
        );
    }

    private boolean hasDuplicateDigits(String result) {
        int length = result.chars()
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toSet())
                .size();

        return length == 3 ? true : false;
    }

    @DisplayName("Strike 개수와 ball 개수를 통해서 힌트정보를 출력할 수 있다.")
    @TestFactory
    public Collection<DynamicTest> hintMessage() {
        // given
        return List.of(
                DynamicTest.dynamicTest("입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시", () -> {
                    //given
                    int strikeCount = 1;
                    int ballCount = 1;
                    String result = String.format(BALL_AND_STRIKE_FORMAT, ballCount, strikeCount);
                    setUp();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    assertThat(getOutput().trim()).isEqualTo(result);
                }),
                DynamicTest.dynamicTest("하나도 없는 경우", () -> {
                    //given
                    int strikeCount = 0;
                    int ballCount = 0;
                    String result = String.format(EMPTY_FORMAT);
                    setUp();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    assertThat(getOutput().trim()).isEqualTo(result);
                }),
                DynamicTest.dynamicTest("3개의 숫자를 모두 맞힐 경우", () -> {
                    //given
                    int strikeCount = 3;
                    int ballCount = 0;
                    String result = String.format(STRIKE_FORMAT, strikeCount);
                    setUp();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    assertThat(getOutput().trim()).isEqualTo(result);
                })
        );
    }
    private void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    private String getOutput() {
        // ByteArrayOutputStream의 toString은 기본 문자집합을 사용하여 버퍼의 내용을 문자열 디코딩 바이트로 변환해줍니다.
        return outputStreamCaptor.toString();
    }

}