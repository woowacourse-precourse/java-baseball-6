package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


class BaseballValidatorTest extends BaseballValidator{
    private static final String SIZE_EXCEPTION ="3개의 숫자를 입력해야 합니다.";
    private static final String DUPLICATE_EXCEPTION ="중복된 숫자를 입력할 수 없습니다.";
    private static final String RANGE_EXCEPTION ="1부터 9까지의 숫자만 입력할 수 있습니다.";

    @Test
    void 예외_크기_검증_테스트(){
        List<Integer> list1 = List.of(1,2,3,4);
        List<Integer> list2 = List.of(1,2,3,4,6,7,8,9);
        List<Integer> list3 = List.of(1,2);
        testListException(list1, SIZE_EXCEPTION);
        testListException(list2, SIZE_EXCEPTION);
        testListException(list3, SIZE_EXCEPTION);
    }

    @Test
    void 예외_중복_검증_테스트(){
        List<Integer> list1 = List.of(1,2,2);
        List<Integer> list2 = List.of(1,1,1);
        List<Integer> list3 = List.of(5,5,6);
        testListException(list1, DUPLICATE_EXCEPTION);
        testListException(list2, DUPLICATE_EXCEPTION);
        testListException(list3, DUPLICATE_EXCEPTION);
    }
    @Test
    void 예외_길이_검증_테스트(){
        List<Integer> list1 = List.of(0,1,2);
        List<Integer> list2 = List.of(10,1,2);
        List<Integer> list3 = List.of(0,1,9);
        testListException(list1, RANGE_EXCEPTION);
        testListException(list2, RANGE_EXCEPTION);
        testListException(list3, RANGE_EXCEPTION);
    }

    private void testListException(List<Integer> list, String message) {
        assertThatThrownBy(() -> validator(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }
}