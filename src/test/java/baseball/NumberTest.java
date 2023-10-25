package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    
    @DisplayName("설정되는 컴퓨터의 숫자는 총 3자리의 수이다.")
    @Test
    void getComputersNumberWithThreeSize() {
        // given
        Number number = new Number();
        int targetLength = 3;
        
        // when
        String computersNumber = number.getComputersNumber();
        
        // then
        assertThat(computersNumber.length()).isEqualTo(targetLength);
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 1부터 9까지의 숫자로 구성된다.")
    @Test
    void getComputersNumberInOneToNine() {
        // given
        Number number = new Number();
        int minNumber = 1;
        int maxNumber = 9;
        
        // when
        String computersNumber = number.getComputersNumber();
        
        // then
        for (char digit : computersNumber.toCharArray()) {
            int intValue = Character.getNumericValue(digit);
            assertThat(intValue).isBetween(minNumber, maxNumber);
        }
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 서로 다른 숫자들로 구성된다.")
    @Test
    void getComputersNumberWithNonDuplicated() {
        // given
        Number number = new Number();
        
        // when
        String computersNumber = number.getComputersNumber();
        
        // then
        Set<Character> digits = new HashSet<>();
        for (char computerNumber : computersNumber.toCharArray()) {
            digits.add(computerNumber);
        }
        assertThat(computersNumber.length()).isEqualTo(digits.size());
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 문자열 타입을 반환한다.")
    @Test
    void getComputersNumberInStringType() {
        // given
        Number number = new Number();
        
        // when
        String computersNumber = number.getComputersNumber();
        
        // then
        assertThat(computersNumber).isInstanceOf(String.class);
    }
    
    @DisplayName("사용자의 입력은 숫자만 들어울 수 있다.")
    @Test
    void userInputShouldContainOnlyDigit() {
        // given
        Number number = new Number();
        String alphabets = "abc";
        String punctuationSymbols = "!@#";
        
        // when // then
        assertThatThrownBy(() -> number.getUserNumber(alphabets))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> number.getUserNumber(punctuationSymbols))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자가 총 3자리의 수이다.")
    @Test
    void userNumberShouldBeThreeDigits() {
        // given
        Number number = new Number();
        String lessThanThreeLengthNumber = "1";
        String moreThanThreeLengthNumber = "12456";
        
        // when // then
        assertThatThrownBy(() -> number.getUserNumber(lessThanThreeLengthNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> number.getUserNumber(moreThanThreeLengthNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자는 1부터 9까지의 숫자로 구성된다. 0은 들어올 수 없다.")
    @Test
    void userNumberShouldBeBetweenOneAndNine() {
        // given
        Number number = new Number();
        String nonNumberBetweenOneAndNine = "908";
        
        // when // then
        assertThatThrownBy(() -> number.getUserNumber(nonNumberBetweenOneAndNine))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자는 서로 다른 숫자들로 구성된다.")
    @Test
    void userNumberShouldNotContainDuplicateDigits() {
        // given
        Number number = new Number();
        String duplicateNumber = "998";
        
        // when // then
        assertThatThrownBy(() -> number.getUserNumber(duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
