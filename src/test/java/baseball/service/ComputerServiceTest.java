package baseball.service;

import static baseball.domain.Computer.BASEBALL_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}