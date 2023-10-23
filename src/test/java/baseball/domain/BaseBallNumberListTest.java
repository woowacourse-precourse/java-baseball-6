package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallNumberListTest {

    @Test
    @DisplayName("불변 리스트를 반환한다")
    public void should_returnImmutableList_when_getList() {
        List<Integer> testNumberList = List.of(1, 5, 3);
        BaseBallNumberList baseBallNumberList = new BaseBallNumberList(testNumberList);

        List<Integer> result = baseBallNumberList.getList();

        assertThat(result.size()).isEqualTo(3);
        assertThat(result).isEqualTo(testNumberList);
        assertThatThrownBy(() -> result.add(1)).isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> result.remove(1)).isInstanceOf(
                UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("리스트의 길이가 3이 아닐때 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_lengthOfTheListIsNot3() {

        assertThatThrownBy(() ->
                new BaseBallNumberList(
                        List.of(1, 5, 9, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자로 숫자를 3개가 아닌 입력시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_inputForStringLengthIsNot3() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(new NumericString(
                        "41").toList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 숫자가 존재 할시 IllegalArgumentException이 발생한다")
    public void should_throwsIllegalArgumentException_when_haveASameNumber() {
        assertThatThrownBy(() ->
                new BaseBallNumberList(List.of(1, 4, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
