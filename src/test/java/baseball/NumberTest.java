package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    
    @DisplayName("설정되는 컴퓨터의 숫자는 총 3자리의 수이다.")
    @Test
    void setComputersNumberWithThreeSize() {
        // given
        Number number = new Number();
        int targetLength = 3;
        
        // when
        String computersNumber = number.setComputersNumber();
        
        // then
        assertThat(computersNumber.length()).isEqualTo(targetLength);
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 1부터 9까지의 숫자로 구성된다.")
    @Test
    void setComputersNumberInOneToNine() {
        // given
        Number number = new Number();
        int minNumber = 1;
        int maxNumber = 9;
        
        // when
        String computersNumber = number.setComputersNumber();
        
        // then
        for (char digit : computersNumber.toCharArray()) {
            int intValue = Character.getNumericValue(digit);
            assertThat(intValue).isBetween(minNumber, maxNumber);
        }
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 서로 다른 숫자들로 구성된다.")
    @Test
    void setComputersNumberWithNonDuplicated() {
        // given
        Number number = new Number();
        
        // when
        String computersNumber = number.setComputersNumber();
        
        // then
        Set<Character> digits = new HashSet<>();
        for (char computerNumber : computersNumber.toCharArray()) {
            digits.add(computerNumber);
        }
        assertThat(computersNumber.length()).isEqualTo(digits.size());
    }
    
    @DisplayName("설정되는 컴퓨터의 숫자는 문자열 타입을 반환한다.")
    @Test
    void setComputersNumberInStringType() {
        // given
        Number number = new Number();
        
        // when
        String computersNumber = number.setComputersNumber();
        
        // then
        assertThat(computersNumber).isInstanceOf(String.class);
    }
}
