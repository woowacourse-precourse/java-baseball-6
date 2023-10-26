package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberUtilsTest {

    private int start = 1;
    private int end = 9;
    private int count = 3;

    List<Integer> computer = null;

    @BeforeEach
    void before() {
        // 매 테스트마다 computer 숫자 초기화
        computer = null;
        System.out.println("computer 숫자 초기화 완료");
    }

    @Test
    @DisplayName("Randoms.pickNumberInRange 를 사용한 computer 숫자 3 자리")
    void createNumber01() {
        computer = RandomNumberUtils.pickNumberInRange(start, end, count);

        // 생성된 숫자의 크기 == count
        assertThat(computer.size()).isEqualTo(count);

        // 중복된 숫자 없이 크기 == count
        Set<Integer> result = computer.stream().collect(Collectors.toSet());
        assertThat(result.size()).isEqualTo(count);

        for (Integer i : computer) {
            System.out.println("i = " + i);
        }
    }

    @Test
    @DisplayName("Randoms.pickNumberInList 를 사용한 computer 숫자 3 자리")
    void createNumber02() {
        computer = RandomNumberUtils.pickNumberInList(List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), count);

        // 생성된 숫자의 크기 == count
        assertThat(computer.size()).isEqualTo(count);

        // 중복된 숫자 없이 크기 == count
        Set<Integer> result = computer.stream().collect(Collectors.toSet());
        assertThat(result.size()).isEqualTo(count);

        for (Integer i : computer) {
            System.out.println("i = " + i);
        }
    }

    @Test
    @DisplayName("Randoms.pickUniqueNumbersInRange 를 사용한 computer 숫자 3 자리")
    void createNumber03() {
        computer = RandomNumberUtils.pickUniqueNumbersInRange(start, end, count);

        // 생성된 숫자의 크기 == count
        assertThat(computer.size()).isEqualTo(count);

        // 중복된 숫자 없이 크기 == count
        Set<Integer> result = computer.stream().collect(Collectors.toSet());
        assertThat(result.size()).isEqualTo(count);

        for (Integer i : computer) {
            System.out.println("i = " + i);
        }
    }

}