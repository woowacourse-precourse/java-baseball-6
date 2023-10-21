package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("1000개의 랜덤한 숫자를 생성하는 테스트")
    @Test
    void makeRandomInRangeTest() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < 1000 ; i++) {
            int randomNumber = numberGenerator.generateRandomNumber();
            //확인차 출력
            System.out.println(randomNumber);
        }
    }

    @DisplayName("1000개의 랜덤한 숫자 리스트를 생성하는 테스트")
    @Test
    void generateRandomList() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < 1000; i++) {
            List<Integer> randomList = numberGenerator.makeRandomAnswerList();
        }
    }

    @Test
    void getAnswer() {
    }
}