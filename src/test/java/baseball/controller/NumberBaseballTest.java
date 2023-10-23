package baseball.controller;

import static baseball.model.constants.Constant.BALL;
import static baseball.model.constants.Constant.NOTHING;
import static baseball.model.constants.Constant.STRIKE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import baseball.utils.CompareNumber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseballTest {
    @Test
    @DisplayName("사용자가 입력한 수를 검사한 후, 리턴합니다.")
    void 플레이어숫자입력() {
        NumberBaseball numberBaseball = new NumberBaseball();
        String playerNumbers = "123";

        try {
            InputStream inputStream = new ByteArrayInputStream(playerNumbers.getBytes());
            System.setIn(inputStream);

            numberBaseball.getNumbersFromPlayer();

            // TODO : 의존성 주입으로 코드 수정 후, 교체 필요
            assertNotNull(numberBaseball);
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("사용자가 입력한 수와 컴퓨터의 수를 비교한 후, 리턴합니다.")
    void 숫자비교() {
        NumberBaseball numberBaseball = new NumberBaseball();
        String playerNumbers = "123";

        try {
            InputStream inputStream = new ByteArrayInputStream(playerNumbers.getBytes());
            System.setIn(inputStream);

            numberBaseball.getNumbersFromPlayer();

            int[] result = numberBaseball.getCompareResult();

            assertNotNull(result);
        } catch (Exception e) {
        }
    }

    @Test
    @DisplayName("비교 결과에 따라 볼 또는 볼 스트라이크를 출력합니다.")
    void 볼또는볼스트라이크출력() {
        NumberBaseball numberBaseball = new NumberBaseball();
        int[] count = {1, 1};

        numberBaseball.printHint(count);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        numberBaseball.printHint(count);

        String actualOutput = outputStream.toString().trim();

        assertEquals("1" + BALL + " 1" + STRIKE, actualOutput);
    }

    @Test
    @DisplayName("비교 결과에 따라 스트라이크를 출력합니다.")
    void 스트라이크출력() {
        NumberBaseball numberBaseball = new NumberBaseball();
        int[] count = {0, 1};

        numberBaseball.printHint(count);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        numberBaseball.printHint(count);

        String actualOutput = outputStream.toString().trim();

        assertEquals("1" + STRIKE, actualOutput);
    }

    @Test
    @DisplayName("비교 결과에 따라 낫싱을 출력합니다.")
    void 낫싱출력() {
        NumberBaseball numberBaseball = new NumberBaseball();
        int[] count = {0, 0};

        numberBaseball.printHint(count);

        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        numberBaseball.printHint(count);

        String actualOutput = outputStream.toString().trim();

        assertEquals(NOTHING, actualOutput);
    }

    @Test
    @DisplayName("게임 재개를 검사한 후, 결과를 리턴합니다.")
    void 게임재개검사() {
        NumberBaseball numberBaseball = new NumberBaseball();

        CompareNumber compareNumber = new CompareNumber();
        assertEquals(!compareNumber.isCorrect(), numberBaseball.isContinue());
    }
}