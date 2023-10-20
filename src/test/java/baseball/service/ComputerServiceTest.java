package baseball.service;

import static baseball.controller.BaseballController.BASEBALL_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerServiceTest {
    
    private final ComputerService computerService = new ComputerService();
    
    @Test
    @DisplayName("상대방(컴퓨터) 3자리 숫자 생성 확인")
    void createComputerNumber() {
        
        String computerNumber = computerService.initComputer();
        int computerNumberLength = computerNumber.length();
        
        assertThat(computerNumberLength).isEqualTo(3);
    }
    
    @Test
    @DisplayName("상대방(컴퓨터) 3자리 숫자 중복 확인")
    void validateComputerNumber() {
        
        String computerNumber = computerService.initComputer();
        
        assertEquals(BASEBALL_NUMBERS_SIZE, computerNumber.length());
    }
    
    @Test
    @DisplayName("3스트라이크 확인")
    void checkThreeStrikes() {
        
        int result = computerService.countStrikes("123", "123");
        
        assertThat(result).isEqualTo(3);
    }
    
    @Test
    @DisplayName("1볼 확인")
    void checkOneBall() {
    
        int result = computerService.countBalls("123", "345");
    
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    @DisplayName("1볼 1스트라이크 확인")
    void checkOneBallAndOneStrike() {
        
        String computer = "123";
        String player = "134";
        
        int countStrikes = computerService.countStrikes(computer, player);
        int countBalls = computerService.countBalls(computer, player);
    
        Assertions.assertAll(
                () -> assertThat(countStrikes).isEqualTo(1),
                () -> assertThat(countBalls).isEqualTo(1)
        );
    }
    
    @Test
    @DisplayName("낫싱 확인")
    void checkNothing() {
    
        String computer = "123";
        String player = "456";
    
        int countStrikes = computerService.countStrikes(computer, player);
        int countBalls = computerService.countBalls(computer, player);
    
        Assertions.assertAll(
                () -> assertThat(countStrikes).isEqualTo(0),
                () -> assertThat(countBalls).isEqualTo(0)
        );
    }
}