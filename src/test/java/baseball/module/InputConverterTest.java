package baseball.module;

import baseball.input.converter.InputConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputConverterTest {

    @Test
    @DisplayName("서로 다른 3자리의 수 입력 테스트")
    public void testGetNumbers() {
        InputConverter inputConverter =mock(InputConverter.class);
        String userInput = "123";
        when(inputConverter.convertInputToNumbers(userInput)).thenCallRealMethod();
        List<Integer> result = inputConverter.convertInputToNumbers(userInput);
        assertEquals(List.of(1,2,3), result);
    }

    @Test
    @DisplayName("종료, 재시작 숫자 입력 테스트")
    public void testGetRestartChoice(){
        InputConverter inputConverter = mock(InputConverter.class);
        String userInput ="1";
        when(inputConverter.parseRestartChoice(userInput)).thenCallRealMethod();
        Integer choice = inputConverter.parseRestartChoice(userInput);
        assertEquals(1,choice);
    }
}