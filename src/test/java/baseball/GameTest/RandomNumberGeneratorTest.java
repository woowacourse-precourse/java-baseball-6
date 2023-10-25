package baseball.GameTest;

import baseball.number.ComputerNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberGeneratorTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @Test
    public void 랜덤숫자생성_테스트() {
        // given
        ComputerNumbers computerNumbers = new ComputerNumbers();

        //when
        String generatedRandomNumber = computerNumbers.getRandomNumber();

        //then

        // 생성된 랜덤 숫자의 개수가 3개인지 확인
        assertEquals(ComputerNumbers.RANDOM_NUMBER_LENGTH, generatedRandomNumber.length());

        // 랜덤 숫자에 중복이 없는지
        for (int i=0; i<generatedRandomNumber.length(); i++) {
            for (int j = i+1; j<generatedRandomNumber.length(); j++) {
                {
                    assertTrue(generatedRandomNumber.charAt(i) != (generatedRandomNumber.charAt(j)));
                }
            }
        }
    }
}
