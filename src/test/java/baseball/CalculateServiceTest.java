package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateServiceTest {
    
    @DisplayName("다른 위치, 같은 숫자가 있는 경우, 볼의 개수가 1 증가한다.")
    @Test
    void getBallCount() {
        // given
        CalculateService calculateService = new CalculateService();
        String computerNumber = "123";
        String userNumber = "345";
        
        // when
        int resultCount = calculateService.getBallCount(computerNumber, userNumber);
        
        // then
        assertThat(resultCount).isEqualTo(1);
    }
    
    @DisplayName("같은 위치, 같은 숫자가 존재하는 경우, 스트라이크의 개수가 1 증가한다.")
    @Test
    void getStrikeCount() {
        CalculateService calculateService = new CalculateService();
        String computerNumber = "123";
        String userNumber = "125";
        
        // when
        int resultCount = calculateService.getStrikeCount(computerNumber, userNumber);
        
        // then
        assertThat(resultCount).isEqualTo(2);
    }
}
