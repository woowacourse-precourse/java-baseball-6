package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumberListTest {

    @Test
    @DisplayName("리스트의 길이가 3이 아닐때 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_lengthOfTheListIsNot3() {

        assertThrows(IllegalArgumentException.class, () ->
                BaseBallNumberList.from(
                        List.of(1, 5, 9, 6)));
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForNotNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                BaseBallNumberList.from(
                        "a13"));
    }

    @Test
    @DisplayName("문자로 숫자를 3개가 아닌 입력시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForStringLengthIsNot3() {
        assertThrows(IllegalArgumentException.class, () ->
                BaseBallNumberList.from(
                        "41"));
    }

}
