package baseball.feature;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import baseball.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MakeUserNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "142", "534", "492", "369"})
    void makeUserNumber(String userInput) {
        Application app = new Application();
        List<Integer> userNumbers = app.makeUserNumber(userInput);

        // 갯수 확인
        assertEquals(3, userNumbers.size(), "리스트의 원소 개수가 3개가 아닙니다.");

        // 모든 원소가 int 형태인지 확인하기
        // Java의 autoboxing 기능으로 int와 Integer는 서로 자동변환
        // 따라서 리스트의 모든 원소가 Integer 인스턴스인지만 확인 시킴
        boolean allIntegers = userNumbers.stream().allMatch(element -> element instanceof Integer);
        assertTrue(allIntegers, "리스트의 모든 원소가 int 형태가 아닙니다.");


    }
}