package baseball;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerValidationTest {

    @DisplayName("validatedInput 실행시 중복값이 없고, 각 값들은 1에서 9사이의 원소를 갖기에 True 를 반환한다")
    @Test
    void combinationValidTest() {
        //given
        Computer computer = new Computer();
        List<Integer> answerList = computer.makeAnswerList();
        ComputerValidation computerValidation = new ComputerValidation(answerList);

        //when
        boolean validatedResult = computerValidation.validatedInput();

        //then
        Assertions.assertThat(validatedResult).isTrue();
    }
}