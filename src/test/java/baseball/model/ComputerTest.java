package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    public void 랜덤숫자_3자리수가_생성된다() {
        // given
        Computer computer = new Computer();

        // when
        computer.generateRandomNumber();
        List<Integer> randomNumber = computer.getRandomNumber();

        // then
        assertThat(randomNumber.size()).isEqualTo(Number.NUMBER_SIZE);

    }

    @Test
    public void 랜덤숫자의_각_자릿수가_모두_다르다() {
        //given
        Computer computer = new Computer();

        //when
        computer.generateRandomNumber();
        List<Integer> randomNumber = computer.getRandomNumber();

        //then
        assertThat(randomNumber.stream().distinct().count()).isEqualTo(Number.NUMBER_SIZE);
    }
}