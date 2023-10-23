package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class ComputerTest {

    final int MAX_SIZE = 3;
    final int LOWER_INCLUSIVE = 1;
    final int UPPER_INCLUSIVE = 9;

    @RepeatedTest(100)
    @DisplayName("컴퓨터는 숫자를 생성한다.")
    void test() {
        generateRandomNumbers_숫자_범위_테스트();
        generateRandomNumbers_숫자_3개_생성_테스트();
        generateRandomNumbers_중복되지_않는_숫자_생성_테스트();
    }

    @DisplayName("컴퓨터는 랜덤으로 3개의 자연수를 생성한다.")
    void generateRandomNumbers_숫자_3개_생성_테스트() {
        Computer computer = new Computer();
        computer.generateRandomNumbers();
        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers).hasSize(MAX_SIZE);
    }

    @DisplayName("각 자릿수는 1이상 9이하이다.")
    void generateRandomNumbers_숫자_범위_테스트() {
        Computer computer = new Computer();
        computer.generateRandomNumbers();
        List<Integer> numbers = computer.getNumbers();

        for (Integer number : numbers) {
            assertThat(number).isBetween(LOWER_INCLUSIVE, UPPER_INCLUSIVE);
        }
    }

    @DisplayName("컴퓨터가 생성한 3개의 자연수는 서로 중복되지 않는다.")
    void generateRandomNumbers_중복되지_않는_숫자_생성_테스트() {
        Computer computer = new Computer();
        computer.generateRandomNumbers();
        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers).doesNotHaveDuplicates();
    }
}