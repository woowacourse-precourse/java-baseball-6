package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberServiceTest {
    
    @DisplayName("설정되는 컴퓨터의 숫자는 총 3자리의 수이다.")
    @Test
    void computerNumberShouldBeThreeDigits() {
        // given
        NumberService numberService = new NumberService();
        int targetLength = 3;
        
        // when
        String computerNumber = numberService.getComputerNumber();
        
        // then
        assertThat(computerNumber).hasSize(targetLength);
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 1부터 9까지의 숫자로 구성된다.")
    @Test
    void computerNumberShouldBeBetweenOneAndNine() {
        // given
        NumberService numberService = new NumberService();
        int minNumber = 1;
        int maxNumber = 9;
        
        // when
        String computerNumber = numberService.getComputerNumber();
        
        // then
        for (char digit : computerNumber.toCharArray()) {
            int intValue = Character.getNumericValue(digit);
            assertThat(intValue).isBetween(minNumber, maxNumber);
        }
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 서로 다른 숫자들로 구성된다.")
    @Test
    void computerNumberShouldNotContainDuplicateDigits() {
        // given
        NumberService numberService = new NumberService();
        
        // when
        String computerNumber = numberService.getComputerNumber();
        
        // then
        Set<Character> digits = new HashSet<>();
        for (char digit : computerNumber.toCharArray()) {
            digits.add(digit);
        }
        assertThat(computerNumber.length()).isEqualTo(digits.size());
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 문자열 타입을 반환한다.")
    @Test
    void computerNumberShouldBeStringType() {
        // given
        NumberService numberService = new NumberService();
        
        // when
        String computerNumber = numberService.getComputerNumber();
        
        // then
        assertThat(computerNumber).isInstanceOf(String.class);
    }
    
    @DisplayName("사용자의 입력은 숫자만 들어울 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "!@#"})
    void userInputShouldContainOnlyDigit(String userInput) {
        // given
        NumberService numberService = new NumberService();
        
        // when // then
        assertThatThrownBy(() -> numberService.getUserNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자가 총 3자리의 수이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void userNumberShouldBeThreeDigits(String userInput) {
        // given
        NumberService numberService = new NumberService();
        
        // when // then
        assertThatThrownBy(() -> numberService.getUserNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자는 1부터 9까지의 숫자로 구성된다. 0은 들어올 수 없다.")
    @Test
    void userNumberShouldBeBetweenOneAndNine() {
        // given
        NumberService numberService = new NumberService();
        String nonNumberBetweenOneAndNine = "908";
        
        // when // then
        assertThatThrownBy(() -> numberService.getUserNumber(nonNumberBetweenOneAndNine))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("사용자가 입력하는 숫자는 서로 다른 숫자들로 구성된다.")
    @Test
    void userNumberShouldNotContainDuplicateDigits() {
        // given
        NumberService numberService = new NumberService();
        String duplicateNumber = "998";
        
        // when // then
        assertThatThrownBy(() -> numberService.getUserNumber(duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
