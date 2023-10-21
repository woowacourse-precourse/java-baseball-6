package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    @DisplayName("1000개의 랜덤한 숫자를 생성하는 테스트")
    @Test
    void makeRandomInRange() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < 1000 ; i++) {
            int randomNumber = numberGenerator.generateRandomNumber();
            //확인차 출력
            System.out.println(randomNumber);
        }
    }
    @Test
    void getAnswer() {
    }
}