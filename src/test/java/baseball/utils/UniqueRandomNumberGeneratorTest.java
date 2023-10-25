package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniqueRandomNumberGeneratorTest {
    static final int TRY_TEST_COUNT = 100;  // 테스팅 횟수 (랜덤성 고려)

    /**
     * 리스트 내에 중복된 숫자가 존재하는지 확인합니다.
     *
     * @param numbers 검증 대상 정수형 리스트
     * @return 중복된 숫자가 존재하면 true, 존재하지 않을 경우 false를 반환합니다.
     */
    public boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    @Test
    void generateUniqueRandomNumbers() {
        List<Integer> numbers;
        int startRange;
        int endRange;
        int count;

        for (int i = 0; i < TRY_TEST_COUNT; i++) {
            // 랜덤 범위 생성 (범위 시작, 범위 종료, 리스트 크기)
            startRange = Randoms.pickNumberInRange(0, 9);
            endRange = Randoms.pickNumberInRange(startRange, 9);
            count = Randoms.pickNumberInRange(1, endRange - startRange + 1);

            numbers = UniqueRandomNumberGenerator.generateUniqueRandomNumbers(startRange, endRange, count);

            // 중복 요소 확인
            assertFalse(hasDuplicates(numbers));

            // 범위 내에 있는지 확인
            for (Integer num : numbers) {
                assertTrue(num >= startRange && num <= endRange);
            }

            // 리스트 크기 확인
            assertEquals(count, numbers.size());
        }
    }
}