package baseball.model.domain;

import static baseball.model.constants.GameConstants.GAME_NUMBERS_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.service.ComputerNumbersGenerator;
import baseball.model.service.ComputerNumbersGeneratorImp;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    private ComputerNumbersGenerator computerNumbersGenerator;

    @BeforeEach
    void setUp() {
        computerNumbersGenerator = new ComputerNumbersGeneratorImp();
    }

    @Test
    @DisplayName("상대방의 역할인 컴퓨터가 1부터 9까지 서로 다른 수로 이루어진 3자리의 랜덤 수를 리턴합니다.")
    void 세자리_랜덤_숫자_생성() {
        Computer computer = Computer.from(computerNumbersGenerator);
        List<Integer> randomNumbers = computer.getComputerNumbers();
        assertEquals(GAME_NUMBERS_SIZE, randomNumbers.size());
    }
}