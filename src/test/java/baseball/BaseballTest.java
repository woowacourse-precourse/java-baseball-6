package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballTest {

    @Test
    void 같은_숫자_넣었을_때_예외처리() {
        List<Integer> duplicateList = Arrays.asList(1, 2, 2);
        assertThrows(IllegalStateException.class, () -> Exception.duplicateNum(duplicateList));
    }

    @Test
    void 세자리로_안넣었을_때_예외처리() {
        List<Integer> invalidInput = Arrays.asList(1, 2);
        assertThrows(IllegalArgumentException.class, () -> Exception.invalidInput(invalidInput));
    }

    @Test
    void 숫자가_아닌_문자입력_예외처리() {
        String input = "12A"; // 유효하지 않은 입력 (문자 포함)
        assertThrows(IllegalArgumentException.class, () -> BaseballService.changeStrToList(input));
    }

    @Test
    void 게임_재시작_할때_올바르지않은_입력_예외처리() {
        ByteArrayInputStream inContent = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(inContent);
        assertThrows(IllegalStateException.class, () -> BaseballController.restartGame());
    }
}

