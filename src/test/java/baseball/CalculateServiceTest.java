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
        // given
        CalculateService calculateService = new CalculateService();
        String computerNumber = "123";
        String userNumber = "125";
        
        // when
        int resultCount = calculateService.getStrikeCount(computerNumber, userNumber);
        
        // then
        assertThat(resultCount).isEqualTo(2);
    }
    
    @DisplayName("볼 개수가 0보다 크고 스트라이크 개수가 0인 경우, 볼만 출력한다.")
    @Test
    void displayIfBallCountExistsOnly() {
        // given
        CalculateService calculateService = new CalculateService();
        int ballCount = 2;
        int strikeCount = 0;
        
        // when
        String resultMessage = calculateService.getResultMessage(ballCount, strikeCount);
        
        // then
        assertThat(resultMessage).isEqualTo(ballCount + "볼 ");
    }
    
    @DisplayName("볼 개수가 0이고 스트라이크 개수가 0보다 큰 경우, 스트라이크만 출력한다.")
    @Test
    void displayIfStrikeCountExistsOnly() {
        // given
        CalculateService calculateService = new CalculateService();
        int ballCount = 0;
        int strikeCount = 2;
        
        // when
        String resultMessage = calculateService.getResultMessage(ballCount, strikeCount);
        
        // then
        assertThat(resultMessage).isEqualTo(strikeCount + "스트라이크");
    }
    
    @DisplayName("볼과 스트라이크 개수가 모두 0보다 큰 경우, 볼과 스트라이크 모두 출력한다.")
    @Test
    void displayIfBallAndStrikeCountExist() {
        // given
        CalculateService calculateService = new CalculateService();
        int ballCount = 2;
        int strikeCount = 1;
        
        // when
        String resultMessage = calculateService.getResultMessage(ballCount, strikeCount);
        
        // then
        assertThat(resultMessage).isEqualTo(ballCount + "볼 " + strikeCount + "스트라이크");
    }
    
    @DisplayName("볼과 스트라이크 개수가 모두 0인 경우, 낫싱을 출력한다.")
    @Test
    void displayIfNothing() {
        // given
        CalculateService calculateService = new CalculateService();
        int ballCount = 0;
        int strikeCount = 0;
        
        // when
        String resultMessage = calculateService.getResultMessage(ballCount, strikeCount);
        
        // then
        assertThat(resultMessage).isEqualTo("낫싱");
    }
}
