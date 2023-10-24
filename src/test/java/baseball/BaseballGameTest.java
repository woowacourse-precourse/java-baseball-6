package baseball;

import baseball.domain.CompareNumbers;
import baseball.domain.Computer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {
    @Test
    void 컴퓨터_랜덤숫자_생성() {
        List<Integer> computerNumbers = Computer.createRandomNumbers();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void 숫자_비교_완전_일치하지_않을때() {
        List<Integer> computer = List.of(1, 2, 9);
        List<Integer> player = List.of(7, 4, 6);
        CompareNumbers test = new CompareNumbers(computer, player);
        assertThat(test.generateResult()).isEqualTo("낫싱");
    }

    @Test
    void 숫자_비교_완전_일치할때() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 2, 3);
        CompareNumbers compare = new CompareNumbers(computer, player);
        assertThat(compare.generateResult()).isEqualTo("3스트라이크");
    }

    @Test
    void 숫자_비교_혼합된_결과() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> player = List.of(1, 3, 2);
        CompareNumbers compare = new CompareNumbers(computer, player);
        assertThat(compare.generateResult()).isEqualTo("2볼 1스트라이크");

    }
}
