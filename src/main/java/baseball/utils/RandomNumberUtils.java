package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberUtils {

    /**
     * pickNumberInRange 사용한 랜덤 결과
     */
    public static List<Integer> pickNumberInRange(int startInclusive, int endInclusive, int capacity) {
        /**
         * Randoms.pickNumberInRange(final int startInclusive, final int endInclusive);
         * startInclusive ~ endInclusive 사이의 숫자 1개 리턴
         * validateRange 로 조건 확인
         */
        /**
         * validateRange - 시작, 종료 숫자 사이의 조건 확인
         * 1. 시작 > 종료
         * 2. 종료 == Integer.MAX_VALUE
         * 3. 종료 - 시작 >= Integer.MAX_VALUE
         * 위 3가지 사항에 해당 하는 경우 IllegalArgumentException 예외 발생
         */
        // 장점 : 범위 체크를 진행 하면 단순 범위의 랜덤 값 하나만 뽑아 낼 수 있어 간단 하다.
        // 단점 : 중복된 값이 나올 수 있다. -> LinkedHashSet 을 사용해서 순서가 보장되고 중복을 허용하지 않는 set을 활용
        // 리스트가 아닌 set을 이용해서 중복값 제거 하기
        Set<Integer> setResult = new LinkedHashSet<>();
        while (setResult.size() < capacity) {
            int num = Randoms.pickNumberInRange(startInclusive, endInclusive);
            setResult.add(num);
        }
        // 수정 가능한 리스트가 되지 않도록 unmodifiableList 사용
        return setResult.stream().collect(Collectors.toUnmodifiableList());
    }

    /**
     * pickNumberInList 사용한 랜덤 결과
     */
    public static List<Integer> pickNumberInList(List<Integer> numbers, int capacity) {
        /**
         * Randoms.pickNumberInList(final List<Integer> numbers);
         * numbers 리스트 안의 숫자 리스트 정보가 랜덤 하게 선택 되어 출력
         * validateNumbers 로 조건 확인
         */
        /**
         * validateNumbers - 리스트가 비어 잇는지 확인
         * 1. isEmpty() -> true
         * 위 사항에 해당 시 IllegalArgumentException 예외 발생
         */
        // 장점 : 랜덤 범위의 리스트를 주면 해당 리스트 안에서 랜덤한 인덱스에 해당 하는 값을 던저 준다.
        // 단점 : 랜덤 범위의 리스트를 생성 해서 던져 주어야 하며, 해당 메소드 또한 중복을 피할 수 없다. -> duplicateCheck 메소드를 활용 하여서 중복 숫자의 경우 List 에 add 되지 않도록 처리
        List<Integer> result = new ArrayList<>(capacity);
        while (result.size() < capacity) {
            int num = Randoms.pickNumberInList(numbers);
            // 중복 숫자 확인
            duplicateCheck(result, num);
        }
        return result;
    }

    /**
     * 숫자가 리스트에 포함되지 않은 경우에만 등록
     */
    private static void duplicateCheck(List<Integer> result, int num) {
        if (!result.contains(num)) {
            result.add(num);
        }
    }

    /**
     * pickUniqueNumbersInRange 사용한 랜덤 결과
     */
    public static List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive,
                                                         int capacity) {
        /**
         * List<Integer> pickUniqueNumbersInRange( final int startInclusive, final int endInclusive, final int count );
         * startInclusive ~ endInclusive 사이의 숫자를 리스트 나열 후 셔플 하여 count 만큼 잘라서 리스트 리턴
         * validateRange, validateCount 로 조건 확인
         */
        /**
         * validateCount - 가져올 리스트 갯수 조건 확인
         * 1. count < 0
         * 2. endInclusive - startInclusive + 1 < count 위 2가지 사항에 해당 하는 경우 위 2가지 사항에 해당 하는 경우
         * IllegalArgumentException 예외 발생
         */
        // 장점 : 범위의 숫자가 나열 식으로 생성 되고 셔플을 통해서 리스트의 순번을 섞어서 count 만큼 갯수만 가져 오면서 중복된 숫자가 없다.
        // 단점 : 셔플을 진행 하게 되면서 단순 값 하나만 가져 오는 Random 함수 보다 사용 되는 비용이 조금 더 비싸 보인다.
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, capacity);
    }
}
