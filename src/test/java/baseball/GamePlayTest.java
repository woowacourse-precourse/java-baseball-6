package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GamePlayTest {

    @Test
    void testGenerateRandomNumber() {
        // 테스트하려는 클래스의 인스턴스 생성
        GamePlay gamePlay = new GamePlay();

        // generateRandomNumber 메소드를 호출하여 반환 값을 저장
        List<Integer> randomNumbers = gamePlay.generateRandomNumber();

        // 반환 값이 null이 아니며, 3개의 숫자로 이루어져 있는지 확인
        assertNotNull(randomNumbers);
        assertEquals(3, randomNumbers.size());

        // 1에서 9 사이의 숫자인지 확인
        for (int number : randomNumbers) {
            assertTrue(number >= 1 && number <= 9);
        }

        // 중복된 숫자가 없는지 확인
        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = i + 1; j < randomNumbers.size(); j++) {
                assertNotEquals(randomNumbers.get(i), randomNumbers.get(j));
            }
        }
    }
}