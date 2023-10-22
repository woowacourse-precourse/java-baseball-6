package baseball.GameTest;

import baseball.game.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @Test
    public void 랜덤숫자생성_테스트() {
        // given
        RandomNumber randomNumberGenreator = new RandomNumber();

        //when
        List<Integer> generatedRandomNumber = randomNumberGenreator.generateRandomNumber();

        //then

        // 생성된 랜덤 숫자의 개수가 3개인지 확인
        assertEquals(RandomNumber.RANDOM_NUMBER_LENGTH, generatedRandomNumber.size());

        // 랜덤 숫자가 1부터 9사이에 있는지
        for (int number : generatedRandomNumber) {
            assertTrue(number >= RandomNumber.MIN_NUMBER_RANGE);
            assertTrue(number <= RandomNumber.MAX_NUMBER_RANGE);
            System.out.println(number);
        }

        // 랜덤 숫자에 중복이 없는지
        for (int i=0; i<generatedRandomNumber.size(); i++) {
            for (int j = i+1; j<generatedRandomNumber.size(); j++) {
                {
                    assertThat(generatedRandomNumber.get(i).equals(generatedRandomNumber.get(j)));
                }
            }
        }
    }
}
