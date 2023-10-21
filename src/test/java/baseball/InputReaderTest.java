package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {
    private static InputReader inputReader;

    @BeforeAll
    static void setUp(){
        inputReader = new InputReader();
    }

    @Test
    @DisplayName("게임 진행 중 올바른 입력이 입력될 때 테스트")
    void typeCorrectGameInput(){
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> inputList = inputReader.readUserGameInput();

        assertEquals(1, inputList.get(0));
        assertEquals(2, inputList.get(1));
        assertEquals(3, inputList.get(2));
    }

    @Test()
    @DisplayName("게임 진행 중 3자리 숫자가 아닐 때 예외 발생 테스트")
    void typeIncorrectInputSizeOfGameInput(){
        String input = "1234";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> inputList = inputReader.readUserGameInput();
        });
    }

    @Test
    @DisplayName("게임 진행 중 숫자가 아닌 다른 문자를 입력할 때 예외 발생 테스트")
    void typeIncorrectInputTypeOfGameInput(){
        String input = "12a";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> inputList = inputReader.readUserGameInput();
        });
    }

    @Test
    @DisplayName("게임 진행 중 입력의 숫자가 중복이 될 때 예외 발생 테스트")
    void typeIncorrectInputDuplicationOfGameInput(){
        String input = "122";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> inputList = inputReader.readUserGameInput();
        });
    }
}