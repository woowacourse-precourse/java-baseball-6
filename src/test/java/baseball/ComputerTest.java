package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {
    @Test
    void 랜덤한_숫자_3가지를_만들수_있다(){
        // Arrange
        Computer computer = new Computer();
        // Act
        List<Integer> randomNumberList = computer.createRandomNumber();
        Integer randomNumber = Integer.parseInt(randomNumberList.toString().replaceAll("[^0-9]",""));
        // Assert
        assertThat(randomNumber).isBetween(111, 999);
    }

}