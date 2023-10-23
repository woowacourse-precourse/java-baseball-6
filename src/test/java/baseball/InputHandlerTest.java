package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * InputHandler.class 의 테스트 코드 이다.
 */
class InputHandlerTest {
    private final InputStream originalSystemIn = System.in;
    private final int THREE_NUMBER_INPUTS = 3;

    private void setInput(String inputString) {
        inputString += "\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    }

    @AfterEach
    void cleanUp() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    @Test
    void 세자리_숫자_입력시_리스트_형태로_리턴되는지_체크한다() {
        Integer[] numbers = new Integer[]{1,2,3};
        List<Integer> expectNumbers = new ArrayList<>(List.of(numbers));

        setInput("123");
        List<Integer> actualNumbers = InputHandler.getMultipleNumbersInput(THREE_NUMBER_INPUTS);

        assertThat(expectNumbers).isEqualTo(actualNumbers);
    }

    @Test
    void 세자리_숫자_입력시_숫자_이외_문자를_입력했을때_예외처리가_실행되는지_체크한다() {
        setInput("ab3");

        assertThatThrownBy(() -> {
            InputHandler.getMultipleNumbersInput(THREE_NUMBER_INPUTS);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 세자리_숫자_입력시_입력_문자가_세자리가_아닌경우_예외처리가_실행되는지_체크한다() {
        setInput("11");

        assertThatThrownBy(() -> {
            InputHandler.getMultipleNumbersInput(THREE_NUMBER_INPUTS);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한자리_숫자_입력시_숫자_형태로_리턴되는지_체크한다() {
        Integer expectNumber = 1;

        setInput("1");
        Integer actualNumber = InputHandler.getOneNumberInput();

        assertThat(expectNumber).isEqualTo(actualNumber);
    }

    @Test
    void 한자리_숫자_입력시_숫자_이외_문자를_입력했을때_예외처리가_실행되는지_체크한다() {
        setInput("a");

        assertThatThrownBy(() -> {
            InputHandler.getOneNumberInput();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한자리_숫자_입력시_입력_문자가_한자리가_아닌경우_예외처리가_실행되는지_체크한다() {
        setInput("11");

        assertThatThrownBy(() -> {
            InputHandler.getOneNumberInput();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}