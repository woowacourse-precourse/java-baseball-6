package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ComputerTest {
    private Computer computer;

    @Test
    @DisplayName("컴퓨터의 숫자와 함께 컴퓨터를 생성할 수 있다.")
    public void setComputer() {
        // given
        computer = new Computer("456");

        // then
        assertThat(computer.getNumber()).isEqualTo("456");
    }

    @Test
    @DisplayName("유저의 입력 숫자가 컴퓨터 숫자와 모두 같은 자리에 없는 경우 strike는 0 ball은 0인 Result를 반환한다.")
    public void compareNumberTest() {
        // given
        computer = new Computer("456");
        Result result = new Result(0, 0);

        // when
        Result response = computer.compareNumber("123");

        // then
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("유저의 입력 숫자가 컴퓨터 숫자와 모두 같은 자리에 있는 경우 strike는 3 ball은 0인 Result를 반환한다.")
    public void compareNumberTest2() {
        // given
        computer = new Computer("123");
        Result result = new Result(3, 0);

        // when
        Result response = computer.compareNumber("123");

        // then
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("유저의 입력 숫자가 중 컴퓨터 숫자가 같은 자리에 1개 있고, 다른 자리에 2개가 있는 경우  strike는 1 ball은 2인 Result를 반환한다.")
    public void compareNumberTest3() {
        // given
        computer = new Computer("123");
        Result result = new Result(1, 2);

        // when
        Result response = computer.compareNumber("132");

        // then
        assertThat(response).isEqualTo(result);
    }

    @Test
    @DisplayName("유저의 입력 숫자가 중 컴퓨터 숫자가 다른 자리에 3개가 있는 경우  strike는 0 ball은 3인 Result를 반환한다.")
    public void compareNumberTest4() {
        // given
        computer = new Computer("123");
        Result result = new Result(0, 3);

        // when
        Result response = computer.compareNumber("312");

        // then
        assertThat(response).isEqualTo(result);
    }
}
