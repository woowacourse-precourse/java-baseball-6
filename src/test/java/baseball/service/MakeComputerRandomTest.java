package baseball.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeComputerRandomTest {
    private final MakeComputerRandom makeComputerRandom;

    public MakeComputerRandomTest() {
        this.makeComputerRandom = new MakeComputerRandom();
    }

    @DisplayName("컴퓨터 랜덤 값 생성")
    @Test
    void createRandom() {
        //given
        Computer computer = makeComputerRandom.createRandom();

        //then
        assertSimpleTest(() ->
                assertThat(computer.getComputerValue()).doesNotHaveDuplicates()
        );

        assertSimpleTest(() ->
                assertThat(computer.getComputerValue()).hasSize(3)
        );
    }
}