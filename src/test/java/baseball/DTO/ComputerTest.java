package baseball.DTO;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ComputerTest {
    @Test
    void 랜덤생성_사이즈_테스트(){

        Computer computer = new Computer();

        assertThat(computer.computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void 랜덤생성_범위_테스트(){

        Computer computer = new Computer();

        assertThat(computer.computerNumbers.stream().allMatch(c -> c > 0 && c < 10)).isTrue();
    }

    @Test
    void 랜덤생성_서로다른_수(){
        Computer computer = new Computer();

        assertThat(computer.computerNumbers.get(0)).isNotEqualTo(computer.computerNumbers.get(1));
        assertThat(computer.computerNumbers.get(0)).isNotEqualTo(computer.computerNumbers.get(2));
        assertThat(computer.computerNumbers.get(1)).isNotEqualTo(computer.computerNumbers.get(2));
    }
}