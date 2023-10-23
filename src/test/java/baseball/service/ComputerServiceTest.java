package baseball.service;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerServiceTest {
    @DisplayName("createRandomNumber 메소드를 실행시켰을 때 3자리 랜덤한 숫자를 반환하는가?")
    @Test
    public void testThreeDigitRandomNumberReturned() {
        //given
        ComputerService computerService = new ComputerService();
        ValidationService validationService = new ValidationService();
        //when
        String oldString = computerService.createRandomNumber();
        //then
        String newString = computerService.createRandomNumber();

        assertNotEquals(oldString, newString);
        assertDoesNotThrow(() -> validationService.isValidNumber(newString));
    }
}