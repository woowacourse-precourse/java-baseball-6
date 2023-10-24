package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {

    private InputReader inputReader;

    @BeforeEach
    public void setUp() {
        inputReader = new InputReader(new GuessedNumberValidator(), new ContinueModeNumberValidator());
    }

    @Test
    public void 추측값_입력_테스트() {

        // 표준 입력에 값을 넣어서 유저가 입력한 것과 같은 효과를 낸다.
        String simulatedInput = "123";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // InputReader 검증
        List<Integer> input = inputReader.readGuessedNumber();
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertIterableEquals(input, expected);
    }

    @Test
    public void 게임_종료_여부_입력_테스트() {

        // 표준 입력에 값을 넣어서 유저가 입력한 것과 같은 효과를 낸다.
        String simulatedInput = "1";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // InputReader 검증
        assertEquals(1, Integer.parseInt(simulatedInput));
    }
}