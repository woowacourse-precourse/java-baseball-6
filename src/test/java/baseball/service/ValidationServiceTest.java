package baseball.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationServiceTest {

    @DisplayName("문자열의 길이가 3이 아닐 때 에러를 반환하는가?")
    @Test
    public void testErrorIsReturnedForNonThreeStringLength() {
        //given
        ValidationService validationService = new ValidationService();
        //when
        String invalidString = "1234";
        String validString = "123";
        //then
        assertThrows(IllegalArgumentException.class, () -> validationService.isThreeDigits(invalidString));
        assertDoesNotThrow(() -> validationService.isThreeDigits(validString));
    }

}