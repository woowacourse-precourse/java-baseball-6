package baseball.api;

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

    private PrintStream standardOut;
    private ByteArrayOutputStream captor;

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
                    init();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    printOutput();
                    assertThat(getOutput().trim()).isEqualTo(result);
                }),
                DynamicTest.dynamicTest("하나도 없는 경우", () -> {
                    //given
                    int strikeCount = 0;
                    int ballCount = 0;
                    String result = String.format(EMPTY_FORMAT);
                    init();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    printOutput();
                    assertThat(getOutput().trim()).isEqualTo(result);
                }),
                DynamicTest.dynamicTest("3개의 숫자를 모두 맞힐 경우", () -> {
                    //given
                    int strikeCount = 3;
                    int ballCount = 0;
                    String result = String.format(STRIKE_FORMAT, strikeCount);
                    init();
                    //when
                    Computer.hintMessage(strikeCount,ballCount);
                    //then
                    printOutput();
                    assertThat(getOutput().trim()).isEqualTo(result);
                })
        );
    }
    private void init() {
        standardOut = System.out; //표준 스트림 초기화
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    private void printOutput() {
        System.setOut(standardOut); // 표준 스트림 할당
        System.out.println(getOutput()); // 원하는 내용이 잘 나왔는지 문자열 디코딩 바이트를 가져와 출력
    }

    private String getOutput() {
        // 기본 문자집합을 사용하여 버퍼의 내용을 문자열 디코딩 바이트로 변환
        return captor.toString().trim();
    }

}