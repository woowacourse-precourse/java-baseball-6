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
                new BaseBallNumberList(
                        List.of(1, 5, 9, 6)));
    }
    @Test
    @DisplayName("문자로 숫자를 3개가 아닌 입력시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForStringLengthIsNot3() {
        assertThrows(IllegalArgumentException.class, () ->
                new BaseBallNumberList(new NumericString(
                        "41").toList()));
    }

    @Test
    @DisplayName("같은 숫자가 존재 할시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_haveASameNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new BaseBallNumberList(List.of(1,4,1)));
    }
}
