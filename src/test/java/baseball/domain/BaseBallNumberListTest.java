package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumberListTest {

    @Test
    @DisplayName("리스트의 길이가 3이닐때 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_lengthOfTheListIs3() {

        assertThrows(IllegalArgumentException.class, () ->
                new BaseBallNumberList(
                        List.of(1, 5, 9, 6)));
    }

}
